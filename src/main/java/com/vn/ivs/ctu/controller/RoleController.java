package com.vn.ivs.ctu.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.ivs.ctu.service.impl.RoleServiceImpl;
import com.vn.ivs.ctu.entity.Role;

@Controller
@RequestMapping("role/")
public class RoleController {
	
	@Autowired
	RoleServiceImpl roleServiceImpl;
	
	@GetMapping	
	public String Index(ModelMap modelMap) {
		modelMap.put("action1","role");
		modelMap.put("action2","index");
		modelMap.put("title","Role");		
		
		modelMap.put("listRole",roleServiceImpl.getAll());
		
		return "role/index";
	}
	@PostMapping
	public String insertRole(@RequestParam String nameRole) {		
		Role role = new Role();
		role.setNameRole(nameRole);
		roleServiceImpl.create(role);		
		return "redirect:/role/";
	}
	
}
