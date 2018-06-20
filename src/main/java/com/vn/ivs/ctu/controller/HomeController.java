package com.vn.ivs.ctu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value= {"/",})
public class HomeController {
	
	@RequestMapping("logout")
	public String logout(Model model) {
		model.addAttribute("message", "Logout success!");
		return "index";
	}
	
	@RequestMapping(path= {"","login"})
	public String login(){
		return "login";
	}
	
	@RequestMapping(path= {"admin/home"})
	public String home() {
		return "home";
	}
}
