package com.vn.ivs.ctu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value= {"/home",})
public class HomeController {
	
	@RequestMapping("/")
	public String Index(ModelMap modelMap) {
		modelMap.put("action1", "dasboard");
		modelMap.put("action2", "dasboard");
		modelMap.put("title","Dasboard");
		return "home/index";
	}
}
