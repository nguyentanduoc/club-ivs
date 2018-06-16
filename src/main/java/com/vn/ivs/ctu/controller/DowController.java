package com.vn.ivs.ctu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.ivs.ctu.entity.DateOfWeek;
import com.vn.ivs.ctu.service.impl.DowServiceImpl;

@Controller
@RequestMapping("dow/")
public class DowController {
	@Autowired
	DowServiceImpl dowServiceImpl;
	
	@GetMapping	
	public String Index(ModelMap modelMap) {
		modelMap.put("action1","dow");
		modelMap.put("action2","index");
		modelMap.put("title","Date of week");		
		
		modelMap.put("listDow",dowServiceImpl.getAll());
		
		return "dow/index";
	}
	@PostMapping
	public String insertDow(@RequestParam String nameDow, int variableDow) {		
		DateOfWeek dow = new DateOfWeek();
		dow.setNameDow(nameDow);
		dow.setVariableDow(variableDow);
		dowServiceImpl.create(dow);	
		return "redirect:/dow/";
	}

}
