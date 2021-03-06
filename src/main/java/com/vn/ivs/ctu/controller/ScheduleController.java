package com.vn.ivs.ctu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vn.ivs.ctu.entity.Club;
import com.vn.ivs.ctu.entity.Schedule;
import com.vn.ivs.ctu.service.ClubService;
import com.vn.ivs.ctu.service.ScheduleService;
import com.vn.ivs.ctu.service.TrainService;
import com.vn.ivs.ctu.service.impl.DowServiceImpl;


@Controller
@RequestMapping("schedule")
@Scope("session")
public class ScheduleController {
	
	@Autowired ScheduleService scheduleService;
	@Autowired DowServiceImpl dowServiceImpl;
	@Autowired ClubService clubService;
	@Autowired TrainService trainService;
	
	
	@GetMapping ("/index")
	public String Index(ModelMap modelMap,HttpSession session){
		modelMap.put("action1","schedule");
		modelMap.put("action2","index");
		modelMap.put("title","Thêm lịch tự động");	
		Schedule schedule = new Schedule();
		schedule.setAutoSchedule(true);
		Club club = (Club)session.getAttribute("club");
		if(club!=null) {
		modelMap.put("schedule", schedule);
		modelMap.put("listDow",dowServiceImpl.getAll());
		modelMap.put("listScheduleAuto", scheduleService.getListScheduleAuto(club.getIdClub()));
		} else {
			modelMap.put("status", 403);
			modelMap.put("message", "bạn không có quyền truy cập");
		}
		return "schedule";
	}
	@PostMapping ("/create")
	public String createSchedule(@ModelAttribute("schedule") Schedule schedule, BindingResult result, ModelMap modelMap, HttpSession session) {		
		Club club = (Club)session.getAttribute("club");
		schedule.setClub(club);
		if (scheduleService.create(schedule)>0) {
			modelMap.put("status", "add complete");
		}else {
			modelMap.put("status", "add fail");
		}
		return "redirect:/schedule/index";
	}
	
	@GetMapping(path = "/scheduletotal")
	public String trainTotal(ModelMap modelMap, HttpSession session) {
		modelMap.put("action1", "schedule");
		modelMap.put("action2", "scheduletotal");
		modelMap.put("title", "Tổng lịch");
		
		Club club = (Club)session.getAttribute("club");
		if(club!=null) {
		modelMap.put("listSchedule",scheduleService.getAll(club.getIdClub()));
		}else {
			modelMap.put("status", 403);
			modelMap.put("message", "bạn không có quyền truy cập");
		}
		return "scheduletotal";
	}
	
	@PostMapping(path="/change")
	@ResponseBody
	public Map<String, Object> change(int idSchedule, boolean autoSchedule){
		Map<String, Object> map = new HashMap<>();
		Schedule schedule = scheduleService.getScheduleById(idSchedule);
		schedule.setAutoSchedule(autoSchedule);
		if(scheduleService.create(schedule)>0) {
			map.put("status", 200);
		}else {
			map.put("status", 400);
		}
		return map;
	}
}
