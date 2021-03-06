package com.vn.ivs.ctu.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.ivs.ctu.entity.Attendance;
import com.vn.ivs.ctu.entity.AttendanceID;
import com.vn.ivs.ctu.entity.Branch;
import com.vn.ivs.ctu.entity.Club;
import com.vn.ivs.ctu.entity.DateOfWeek;
import com.vn.ivs.ctu.entity.JoinClub;
import com.vn.ivs.ctu.entity.Schedule;
import com.vn.ivs.ctu.entity.Train;
import com.vn.ivs.ctu.service.AttendanceService;
import com.vn.ivs.ctu.service.BranchService;
import com.vn.ivs.ctu.service.ClubService;
import com.vn.ivs.ctu.service.DowService;
import com.vn.ivs.ctu.service.JoinClubService;
import com.vn.ivs.ctu.service.ScheduleService;
import com.vn.ivs.ctu.service.TrainService;
import com.vn.ivs.ctu.utils.DateUtils;
import com.vn.ivs.ctu.utils.SecurityUtils;

@Component
@Controller
@RequestMapping("train")
public class TrainController {

	@Autowired TrainService trainService;
	@Autowired ScheduleService scheduleService;
	@Autowired DowService dowService;
	@Autowired JoinClubService joinClubService;
	@Autowired AttendanceService attendanceService;
	@Autowired ClubService clubService;
	@Autowired BranchService branchService;
	
	@GetMapping(path = "/index")
	public String Index(ModelMap modelMap,HttpSession session) {
		modelMap.put("action1", "schedule");
		modelMap.put("action2", "train");
		modelMap.put("title", "Thêm lịch thủ công");
		Club club = (Club)session.getAttribute("club");
		if(club!=null) {
		modelMap.put("listSchedule",scheduleService.getAll(club.getIdClub()));
		modelMap.put("listTrainManual",trainService.getAllTrainManual(club.getIdClub()));
		modelMap.put("listTrainOnWeek", trainService.getListAllTrainOnWeek(club.getIdClub()));
		}else {
			modelMap.put("status", 403);
			modelMap.put("message", "bạn không có quyền truy cập!");
		}
		return "train";
	}

	@PostMapping ("/create")
	public String insertTrain(@RequestParam Date dateTrain, @RequestParam String nameSchedule, @RequestParam String timeSchedule, @RequestParam String locationSchedule, @RequestParam boolean autoSchedule, ModelMap modelMap,HttpSession session) {	
		Schedule schedule = new Schedule();
		Train train = new Train();
		train.setDateTrain(dateTrain);
		DateOfWeek dow = dowService.getByVariable(DateUtils.getDateOfWeek(dateTrain));
		schedule.setDateOfWeek(dow);
		schedule.setNameSchedule(nameSchedule);
		schedule.setTimeSchedule(timeSchedule);
		schedule.setLocationSchedule(locationSchedule);
		schedule.setAutoSchedule(false);
		Club club = (Club)session.getAttribute("club");
		schedule.setClub(club);
		Date myDate = dateTrain;
		Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
		int week = cal.get(Calendar.WEEK_OF_YEAR);
		if(scheduleService.create(schedule)>0) {
			train.setSchedule(schedule);
			train.setWeekend(week);
			if(trainService.create(train)>0)
			{
				List<JoinClub> joinClubs = joinClubService.getJoinClubByClub(schedule.getClub().getIdClub());
				if(joinClubs!=null) {
		        	
		        	for(JoinClub joinClub:joinClubs) {
		        		AttendanceID attendanceID = new AttendanceID();
		        		attendanceID.setIdMember(joinClub.getMember().getIdMember());
		        		attendanceID.setIdTrain(train.getIdTrain());
		        		Attendance attendance = new Attendance();
		        		attendance.setAttendance(true);
		        		attendance.setAttendanceID(attendanceID);
		        		System.out.println(attendanceService.createOrUpdate(attendance));
		        	}
		        }
				modelMap.put("status", 200);
				modelMap.put("message", "Thành công!");
			}
			else {
				modelMap.put("status", 400);
				modelMap.put("message", "Tạo hoạt động bị lỗi!");
			}
		}else {
			modelMap.put("status", 400);
			modelMap.put("message", "Tạo lịch bị lỗi!");
		}
		
		return "redirect:/train/index";
	}
	@GetMapping(path = "/trainauto")
	public String trainAuto(ModelMap modelMap, HttpSession session) {
		modelMap.put("action1", "train");
		modelMap.put("title", "Lịch tự động tạo");
		Club club = (Club)session.getAttribute("club");
		if(club!=null) {
			modelMap.put("listTrainAuto", trainService.getAllTrainAuto(club.getIdClub()));
		} else {
			modelMap.put("status", 403);
			modelMap.put("message", "bạn không có quyền truy cập!");
		}
		return "trainauto";
	}
	@GetMapping(path = "/getAllTrain")
	public String getAllTrain(ModelMap modelMap, HttpSession session) {
		modelMap.put("action1", "getAllTrain");
		modelMap.put("title", "Tất cả lịch CLB");
		long idLeader = SecurityUtils.getMyUserDetail().getIdMember();
		Branch branch = branchService.getBranchByMember(idLeader);
		modelMap.put("listTrainBranch", trainService.getAllTrainBranch(branch.getIdBranch()));
		return "scheduleTotalBranch";
	}
}
