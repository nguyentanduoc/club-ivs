package com.vn.ivs.ctu.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.ivs.ctu.entity.Attendance;
import com.vn.ivs.ctu.entity.AttendanceID;
import com.vn.ivs.ctu.entity.Club;
import com.vn.ivs.ctu.entity.JoinClub;
import com.vn.ivs.ctu.entity.Schedule;
import com.vn.ivs.ctu.entity.Train;
import com.vn.ivs.ctu.service.AttendanceService;
import com.vn.ivs.ctu.service.ClubService;
import com.vn.ivs.ctu.service.DowService;
import com.vn.ivs.ctu.service.JoinClubService;
import com.vn.ivs.ctu.service.ScheduleService;
import com.vn.ivs.ctu.service.TrainService;
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
	
	@GetMapping(path = "/index")
	public String Index(ModelMap modelMap) {
		modelMap.put("action1", "train");
		modelMap.put("action2", "index");
		modelMap.put("title", "Train");
		modelMap.put("listSchedule",scheduleService.getAll());
		modelMap.put("listTrain", trainService.getAllTrainAuto());
		modelMap.put("listAllTrainOnWeek", trainService.getListAllTrainOnWeek());
		return "train";
	}

	@PostMapping ("/create")
	public String insertTrain(@RequestParam Date dateTrain, @RequestParam String nameSchedule, @RequestParam String timeSchedule, @RequestParam String locationSchedule, @RequestParam boolean autoSchedule, ModelMap modelMap) {	
		Schedule schedule = new Schedule();
		Train train = new Train();
		train.setDateTrain(dateTrain);
		
		schedule.setNameSchedule(nameSchedule);
		schedule.setTimeSchedule(timeSchedule);
		schedule.setLocationSchedule(locationSchedule);
		schedule.setAutoSchedule(false);
		
		int idLeader = SecurityUtils.getMyUserDetail().getIdMember();
		Club club = clubService.getLeaderClub(idLeader);
		schedule.setClub(club);
		Date myDate = dateTrain;
		Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        
		int week = cal.get(Calendar.WEEK_OF_YEAR);
        int year = cal.getWeekYear();
		if(scheduleService.create(schedule)>0) {
			train.setSchedule(schedule);
			train.setWeekend(week);
			train.setYear(year);
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
		
		return Index(modelMap);
	}
	@GetMapping(path = "/trainauto")
	public String trainAuto(ModelMap modelMap) {
		modelMap.put("action1", "train");
		modelMap.put("action2", "trainauto");
		modelMap.put("title", "Train");
		modelMap.put("listTrain", trainService.getAllTrain());
		return "trainauto";
	}
	

}
