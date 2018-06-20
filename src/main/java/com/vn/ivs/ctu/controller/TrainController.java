package com.vn.ivs.ctu.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.ivs.ctu.entity.Schedule;
import com.vn.ivs.ctu.entity.Train;
import com.vn.ivs.ctu.service.impl.DowServiceImpl;
import com.vn.ivs.ctu.service.impl.ScheduleServiceImpl;
import com.vn.ivs.ctu.service.impl.TrainServiceImpl;

@Component
@Controller
@RequestMapping("train/")
public class TrainController {

	@Autowired
	TrainServiceImpl trainServiceImpl;
	@Autowired
	ScheduleServiceImpl scheduleServiceImpl;
	@Autowired
	DowServiceImpl dowServiceImpl;

	@GetMapping(path = "")
	public String Index(ModelMap modelMap) {
		modelMap.put("action1", "train");
		modelMap.put("action2", "index");
		modelMap.put("title", "Train");
		Train train = new Train();

		modelMap.put("train", train);
		modelMap.put("listTrain", trainServiceImpl.getAll());
		return "train/index";
	}

	@PostMapping
	public String createTrain(@ModelAttribute("train") Train train, BindingResult result, ModelMap modelMap) {

		if (trainServiceImpl.create(train) > 0) {
			modelMap.put("status", "add complete");
		} else {
			modelMap.put("status", "add fail");
		}
		return "redirect:/train/";
	}

	@Scheduled(cron = "0 00 21 * * SUN")
	public static void showCalendar() {
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);

		List<Schedule> schedules = new ArrayList<>();

		for (Schedule s : schedules) {
			c.add(Calendar.DATE, s.getDateOfWeek().getVariableDow());
			dt = c.getTime();
			Train train = new Train();
			train.setDateTrain(dt);

		}
	}

}
