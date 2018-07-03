package com.vn.ivs.ctu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.ivs.ctu.entity.Club;
import com.vn.ivs.ctu.entity.Schedule;
import com.vn.ivs.ctu.service.AttendanceService;
import com.vn.ivs.ctu.service.ClubService;
import com.vn.ivs.ctu.service.JoinClubService;
import com.vn.ivs.ctu.service.ScheduleService;
import com.vn.ivs.ctu.service.TrainService;
import com.vn.ivs.ctu.utils.SecurityUtils;

@Controller
@RequestMapping("attendance")
public class AttendanceController {
	
	@Autowired AttendanceService attendanceService;
	@Autowired TrainService trainService;
	@Autowired JoinClubService joinclubService;
	@Autowired ClubService clubService;
	
	@GetMapping ("/index")
	public String Index(ModelMap modelMap) {

		modelMap.put("action1","attendance");
		modelMap.put("action2","index");
		modelMap.put("title","Attendance");
		int idLeader =  SecurityUtils.getMyUserDetail().getIdMember();
		Club club = clubService.getLeaderClub(idLeader);
		if(club!=null) {
			modelMap.put("listAllTrainOnWeek", trainService.getListAllTrainOnWeek(club.getIdClub()));			
		}else {
			modelMap.put("status", 403);
			modelMap.put("message", "bạn không có quyền truy cập!");
		}	
		return "attendance";
	}
}
