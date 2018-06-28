package com.vn.ivs.ctu.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.ivs.ctu.dao.RoleDAO;
import com.vn.ivs.ctu.entity.Member;
import com.vn.ivs.ctu.service.BranchService;
import com.vn.ivs.ctu.service.ClubService;
import com.vn.ivs.ctu.service.MemberService;
import com.vn.ivs.ctu.service.RoleService;
import com.vn.ivs.ctu.utils.CustomFormBinder;
import com.vn.ivs.ctu.utils.PasswordEncoder;
import com.vn.ivs.ctu.utils.SecurityUtils;

@Controller
@RequestMapping(path = "/member")
public class MemberController {

	@Autowired	RoleService roleService;
	@Autowired	MemberService memberService;
	@Autowired	BranchService branchSevice;
	@Autowired	RoleDAO roleDAO;
	@Autowired	ClubService clubSerive;

	@InitBinder
	public void bindForm(final WebDataBinder binder) {

		binder.registerCustomEditor(Set.class, "roles", new CustomFormBinder<RoleService>(roleService, Set.class));
	}

	@GetMapping(path = "/create")
	public String Index(@RequestParam(name="status",required=false) String status,ModelMap modelMap) {
		modelMap.put("action1", "member");
		modelMap.put("action2", "indexmember");
		modelMap.put("title", "Member");
		Member member = new Member();
		modelMap.put("member", member);
		modelMap.put("listRole", roleService.getAll());
		modelMap.put("listMember", memberService.findAll());
		modelMap.put("listBranch", branchSevice.getAll());
		if(status!=null) {
			if(status.equals("200")) {
				modelMap.put("status", 200);
				modelMap.put("message", "Thành Công!");
			}else {
				modelMap.put("status", 400);
				modelMap.put("message", "Thất Bại!");
			}
		}
		
		return "member";
	}

	@PostMapping(path = "/create")
	public String add(@ModelAttribute("member") Member member, BindingResult result, ModelMap modelMap) {

		member.setPassWordMember(PasswordEncoder.BCryptPassdEncoder(member.getPassWordMember()));
		if (memberService.saveOrUpdate(member) > 0) {
			return "redirect:/member/create?status=200";
		} else {
			return "redirect:/member/create?status=400";
		}
	}

	
	@GetMapping(path="profile")
	public String profileMember(ModelMap modelMap) {
		int idMember = SecurityUtils.getMyUserDetail().getIdMember();
		
		modelMap.put("member",memberService.getMemberById(idMember));
		return "profile";		
	}
}
