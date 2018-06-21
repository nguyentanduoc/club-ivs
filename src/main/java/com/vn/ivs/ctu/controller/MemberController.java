package com.vn.ivs.ctu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vn.ivs.ctu.entity.Member;
import com.vn.ivs.ctu.service.MemberService;
import com.vn.ivs.ctu.service.RoleService;

@Controller
@RequestMapping("member/")
public class MemberController {
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	MemberService memberService;
	
	@GetMapping(path="")
	public String Index(ModelMap modelMap) {
		modelMap.put("action1","member");
		modelMap.put("action2","indexmember");
		modelMap.put("title","Member");		
		Member member = new Member();
		modelMap.put("member",member);
		modelMap.put("listRole", roleService.getAll());	
		modelMap.put("listMember",memberService.findAll());
		return "member";
	}
	
	@PostMapping(path="")
	public String add(@ModelAttribute("member") Member member,BindingResult result, ModelMap modelMap) {
		//System.out.println(member.getRoles().size());
//		if(memberService.saveOrUpdate(member) > 0) {
//			return "redirect:/member/";
//		}else {
//			return "redirect:/member/";
//		}
		return "redirect:/member/";
	}
	
	@ResponseBody
	@PostMapping(path="/check")	
	public Map<String,Object> check(String name){
		boolean rs = memberService.check(name);
		Map<String, Object> map = new HashMap<>();
		if(rs) {
			map.put("status", "200");
		}else {
			map.put("status", "404");
		}		
		return map; 
	}
}
