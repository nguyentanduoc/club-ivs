package com.vn.ivs.ctu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vn.ivs.ctu.entity.Role;
import com.vn.ivs.ctu.service.impl.DowServiceImpl;
import com.vn.ivs.ctu.service.impl.RoleServiceImpl;

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
	
}
