package com.vn.ivs.ctu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vn.ivs.ctu.entity.Attendance;
import com.vn.ivs.ctu.entity.AttendanceID;
import com.vn.ivs.ctu.entity.JoinClub;
import com.vn.ivs.ctu.entity.Role;
import com.vn.ivs.ctu.entity.Schedule;
import com.vn.ivs.ctu.entity.Train;
import com.vn.ivs.ctu.service.AttendanceService;
import com.vn.ivs.ctu.service.TrainService;
import com.vn.ivs.ctu.service.impl.DowServiceImpl;
import com.vn.ivs.ctu.service.impl.RoleServiceImpl;
import com.vn.ivs.ctu.service.impl.ScheduleServiceImpl;

@Controller
@RequestMapping("api/")
public class ApiController {
	
	@Autowired
	RoleServiceImpl roleServiceImpl;
	
	@GetMapping("deleteRole")
	@ResponseBody
	public String deleteRole(@RequestParam int id) {		
		boolean rs = roleServiceImpl.deleteRole(id);
		if(rs) {
			return "true";
		}else {
			return "false";
		}
	}
	
	
	@Autowired
	DowServiceImpl dowServiceImpl;
	
	@GetMapping("deleteDow")
	@ResponseBody
	public String deleteDow(@RequestParam int id) {		
		boolean rs = dowServiceImpl.deleteDow(id);
		if(rs) {
			return "true";
		}else {
			return "false";
		}
	}
	@Autowired
	ScheduleServiceImpl scheduleServiceImpl;
	
	@GetMapping("deleteSchedule")
	@ResponseBody
	public String deleteSchedule(@RequestParam int id) {		
		boolean rs = scheduleServiceImpl.deleteSchedule(id);
		if(rs) {
			return "true";
		}else {
			return "false";
		}
	}
	
	@Autowired TrainService trainservice;
	@GetMapping("deleteTrain")
	@ResponseBody
	public String deleteTrain(@RequestParam int id)
	{
		boolean rs = trainservice.deleteTrain(id);
		if(rs) {
			return "true";
		}else {
			return "false";
		}
	}
//	@Autowired TrainService trainService;
//	
//	
//	@GetMapping("ListAllTrainOnWeek")
//	@ResponseBody
//	public List getListAllTrainOnWeek(@RequestParam int idTrain) {
//		Train train = new Train();
//		List<Train> trains = trainService.getListAllTrainOnWeek(idTrain);
//		return getListAllTrainOnWeek(train.getIdTrain());
//	}
}
