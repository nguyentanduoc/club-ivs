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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vn.ivs.ctu.entity.Branch;
import com.vn.ivs.ctu.service.impl.BranchServiceImpl;
import com.vn.ivs.ctu.service.impl.MemberServiceImpl;;

@Controller
@RequestMapping("/branch")
public class BranchController {
	
	@Autowired BranchServiceImpl  branchServiceImpl;	
	@Autowired MemberServiceImpl memberServiceImpl;
	
	@GetMapping(path="/index")
	public String Index(@RequestParam(name="message",required=false)String message, ModelMap modelMap) {
				
		modelMap.put("action1","branch");
		modelMap.put("action2","indexbranch");
		modelMap.put("title","Branch");		
		Branch branch  = new Branch();
		modelMap.put("branch",branch);
		modelMap.put("listMember", memberServiceImpl.getAllRoleOTC());
		modelMap.put("listBranch", branchServiceImpl.getAll());
		if(message!=null) {
			if(message.equals("success")) {
				modelMap.put("status", 200);
				modelMap.put("message", "Thành Công!");
			}else {
				modelMap.put("message", "Thất Bại!");
				modelMap.put("status", 400);
			}
		}
		return "branch";
	}
	
	@PostMapping("/insert")
	public String createBranch(@ModelAttribute("branch") Branch branch, BindingResult result, ModelMap modelMap) {
				
		if(branchServiceImpl.saveOrUpdate(branch) >  0) {
			return "redirect:/branch/index?message=success";	
		}else {
			return "redirect:/branch/index?message=errors";	
		}		
	}
	
	@PostMapping(path="/checkMember")
	@ResponseBody
	public Map<String,Object> checkMemberBranch(int idMember){
		Map<String,Object> map = new HashMap<>();
		if(branchServiceImpl.getBranchByMember(idMember)==null) {
			map.put("status", 404);
		}else {
			map.put("status",200);
		}
		return map;
	}
}
