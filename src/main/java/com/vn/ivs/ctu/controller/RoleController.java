package com.vn.ivs.ctu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.ivs.ctu.entity.Role;
import com.vn.ivs.ctu.service.impl.RoleServiceImpl;

@Controller
@RequestMapping("role/")
public class RoleController {
	
	@Autowired	RoleServiceImpl roleServiceImpl;

	@GetMapping(path="index")
	public String Index(@RequestParam(name="status",required=false)String status ,ModelMap modelMap) {
		modelMap.put("action1","role");
		modelMap.put("action2","index");
		modelMap.put("title","Chức vụ");				
		modelMap.put("role", new Role());
		modelMap.put("listRole",roleServiceImpl.getAll());		
		if(status!=null) {			
			if(status.equals("200")) {
				modelMap.put("status", 200);
				modelMap.put("message", "Thành Công!");
			}			
			else {
				modelMap.put("status", 400);
				modelMap.put("message", "Thất Bại!");
			}
		}		
		return "role";
	}

	@PostMapping(path="insert")
	public String insertRole(@ModelAttribute("role") Role role) {		
				
		if(roleServiceImpl.createOrUpdate(role) > 0 ) {
			return "redirect:/role/index?status=200";
		}else {
			return "redirect:/role/index?status=400";
		}
	}	

}
