package com.vn.ivs.ctu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="to-grade/")
public class ToGradeController {
	
	@RequestMapping(path="index")
	public String tableScore() {
		return "tableScore";
	}
}
