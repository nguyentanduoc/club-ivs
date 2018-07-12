package com.vn.ivs.ctu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vn.ivs.ctu.entity.Attendance;
import com.vn.ivs.ctu.entity.Club;
import com.vn.ivs.ctu.service.AttendanceService;
import com.vn.ivs.ctu.service.ClubService;
import com.vn.ivs.ctu.service.JoinClubService;
import com.vn.ivs.ctu.service.ScheduleService;
import com.vn.ivs.ctu.service.TrainService;

@Controller
@RequestMapping("attendance")
public class AttendanceController {
	
	@Autowired AttendanceService attendanceService;
	@Autowired TrainService trainService;
	@Autowired JoinClubService joinclubService;
	@Autowired ClubService clubService;
	@Autowired ScheduleService scheduleService;
	
	@GetMapping ("/index")
	public String Index(ModelMap modelMap,HttpSession session) {

		modelMap.put("action1","attendance");
		modelMap.put("title","Sự kiện trong tuần");
		Club club = (Club)session.getAttribute("club");
		if(club!=null) {
			modelMap.put("listSchedule",scheduleService.getAll(club.getIdClub()));
			modelMap.put("listAllTrainOnWeek", trainService.getListAllTrainOnWeek(club.getIdClub()));			
		}else {
			modelMap.put("status", 403);
			modelMap.put("message", "bạn không có quyền truy cập!");
		}
		return "attendance";
	}
	@GetMapping ("/diemdanh/{id}")
	public String Diemdanh(@PathVariable("id") int id, ModelMap modelMap,HttpSession session) {

		modelMap.put("action1","attendance");
		modelMap.put("title","Danh sách điểm danh");
		Club club = (Club)session.getAttribute("club");
		if(club!=null) {
			modelMap.put("listAttendance", attendanceService.getAttendanceByTrain(id));
			modelMap.put("listSchedule",scheduleService.getAll(club.getIdClub()));
		}else {
			modelMap.put("status", 403);
			modelMap.put("message", "bạn không có quyền truy cập!");
		}
		return "diemdanh";
	}
	@PostMapping(path="/check")
	@ResponseBody
	public Map<String, Object> check(int idMember, int idTrain, boolean isAttendance, String reason){
		Map<String, Object> map = new HashMap<>();
		Attendance ats = attendanceService.getAttendByIdMember(idMember, idTrain);	
		ats.setAttendance(isAttendance);
		ats.setReason(reason);
		if(attendanceService.createOrUpdate(ats)) {
			map.put("status", 200);
		}
		
		return map;
	}
}
