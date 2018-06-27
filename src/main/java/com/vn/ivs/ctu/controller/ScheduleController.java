package com.vn.ivs.ctu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.ivs.ctu.entity.Club;
import com.vn.ivs.ctu.entity.Schedule;
import com.vn.ivs.ctu.service.ClubService;
import com.vn.ivs.ctu.service.impl.DowServiceImpl;
import com.vn.ivs.ctu.service.impl.ScheduleServiceImpl;
import com.vn.ivs.ctu.utils.SecurityUtils;


@Controller
@RequestMapping("schedule")
public class ScheduleController {
	
	@Autowired ScheduleServiceImpl scheduleServiceImpl;
	@Autowired DowServiceImpl dowServiceImpl;
	@Autowired ClubService clubService;
	
	
	@GetMapping ("/index")
	public String Index(ModelMap modelMap){
		modelMap.put("action1","schedule");
		modelMap.put("action2","index");
		modelMap.put("title","Schedule");	
		Schedule schedule = new Schedule();
		schedule.setAutoSchedule(true);
		modelMap.put("schedule", schedule);
		modelMap.put("listDow",dowServiceImpl.getAll());
		modelMap.put("listSchedule",scheduleServiceImpl.getAll());
		
		return "schedule";
	}
	@PostMapping
	public String createSchedule(@ModelAttribute("schedule") Schedule schedule, BindingResult result, ModelMap modelMap) {		
		int idLeader = SecurityUtils.getMyUserDetail().getIdMember();
		Club club = clubService.getLeaderClub(idLeader);
		schedule.setClub(club);
		if (scheduleServiceImpl.create(schedule)>0) {
			modelMap.put("status", "add complete");
		}else {
			modelMap.put("status", "add fail");
		}
		return "redirect:/schedule/index";
	}
}
