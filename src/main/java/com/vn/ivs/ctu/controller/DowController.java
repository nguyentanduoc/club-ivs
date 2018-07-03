package com.vn.ivs.ctu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.ivs.ctu.entity.DateOfWeek;
import com.vn.ivs.ctu.service.impl.DowServiceImpl;

@Controller
@RequestMapping("dow")
public class DowController {
	@Autowired
	DowServiceImpl dowServiceImpl;
	
	@GetMapping("/index")
	public String Index(ModelMap modelMap) {
		modelMap.put("action1","dow");
		modelMap.put("action2","index");
		modelMap.put("title","Date of week");		
		DateOfWeek dow = new DateOfWeek();
		modelMap.put("dow",dow);
		modelMap.put("listDow",dowServiceImpl.getAll());
		return "dow";
	}
	@PostMapping("/create")
	public String insertDow(@ModelAttribute("dow")DateOfWeek dow,BindingResult result, ModelMap modelMap) {
		dowServiceImpl.create(dow);	
		return "redirect:/dow/index";
	}

}
