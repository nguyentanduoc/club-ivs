package com.vn.ivs.ctu.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.cj.api.xdevapi.Result;
import com.vn.ivs.ctu.entity.DateOfWeek;
import com.vn.ivs.ctu.entity.Schedule;
import com.vn.ivs.ctu.service.impl.DowServiceImpl;
import com.vn.ivs.ctu.service.impl.ScheduleServiceImpl;


@Controller
@RequestMapping("schedule/")
public class ScheduleController {
	
	@Autowired
	ScheduleServiceImpl scheduleServiceImpl;
	@Autowired
	DowServiceImpl dowServiceImpl;
	
	@GetMapping (path="")
	public String Index(ModelMap modelMap){
		modelMap.put("action1","schedule");
		modelMap.put("action2","index");
		modelMap.put("title","Schedule");	
		Schedule schedule = new Schedule();
		modelMap.put("schedule", schedule);
		modelMap.put("listDow",dowServiceImpl.getAll());
		modelMap.put("listSchedule",scheduleServiceImpl.getAll());
		
		return "schedule/index";
	}
	@PostMapping
	public String createSchedule(@ModelAttribute("schedule") Schedule schedule, BindingResult result, ModelMap modelMap) {		
		System.out.println(schedule.getTimeSchedule());
//		System.out.println("date"+schedule.getDateOfWeek());
//			if (scheduleServiceImpl.create(schedule)>0) {
//			modelMap.put("status", "Add complete");
//			
//		}else {
//			modelMap.put("status", "Add fail");
//		}
		
		return "redirect:/schedule/";
	}
	
}
