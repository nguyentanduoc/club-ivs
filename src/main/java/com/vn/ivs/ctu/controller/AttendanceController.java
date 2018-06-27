package com.vn.ivs.ctu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.ivs.ctu.service.AttendanceService;

@Controller
@RequestMapping("attendance")
public class AttendanceController {
	@Autowired
	AttendanceService attendanceService;
	
	@GetMapping ("/index")
	public String Index(ModelMap modelMap) {
		modelMap.put("action1","attendance");
		modelMap.put("action2","index");
		modelMap.put("title","Attendance");		
		
		//modelMap.put("listAttendance",attendanceService.getAllAttendance());
		
		return "attendance";

}
}
