package com.vn.ivs.ctu.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.ivs.ctu.entity.Branch;
import com.vn.ivs.ctu.entity.Club;
import com.vn.ivs.ctu.entity.JoinClub;
import com.vn.ivs.ctu.entity.Member;
import com.vn.ivs.ctu.entity.Status;
import com.vn.ivs.ctu.service.BranchService;
import com.vn.ivs.ctu.service.ClubService;
import com.vn.ivs.ctu.service.MemberService;
import com.vn.ivs.ctu.utils.SecurityUtils;

@Controller
@RequestMapping(path="/club")
public class ClubController {
	
	@Autowired BranchService branchService;
	@Autowired ClubService clubService;
	@Autowired MemberService memberService;
		
	
	@GetMapping(path="/index")
	public String index(@RequestParam(name="message",required=false) String message, ModelMap modelMap){
		Club club = new Club();
		modelMap.put("branchs", branchService.getAll());
		modelMap.put("clubs", clubService.getAll());
		modelMap.put("members",memberService.getAllLeaderClub());
		modelMap.put("club", club);
		if(message!=null) {
			if(message.equals("success")) {
				modelMap.put("message", "Thành Công!");
				modelMap.put("status", 200);
			}else {
				modelMap.put("message", "Thất Bại!");
				modelMap.put("status", 400);
			}
		}
		return "club";
	}
	
	@PostMapping(path="/create")
	public String create(@ModelAttribute("club") Club club,BindingResult result, ModelMap modelMap ) {
		
		if(clubService.saveOrUpdate(club)>0) {
			return "redirect:/club/index?message=success";
		}else {
			return "redirect:/club/index?message=error";
		}
	}
	
	@GetMapping(path = "/joinClub")
	public String joinClub(ModelMap modelMap) {
		modelMap.put("action1", "club");
		modelMap.put("action2", "joinClub");
		modelMap.put("title", "Join Club");

		int idOTC = SecurityUtils.getMyUserDetail().getIdMember();
		Branch branch = branchService.getBranchByMember(idOTC);
		if(branch!=null) {
			modelMap.put("members", memberService.getAllByBranch(branch.getIdBranch()));
			modelMap.put("clubs", clubService.getClubByBranch(branch.getIdBranch()));
		}else{
			modelMap.put("status", "200");
			modelMap.put("message", "Bạn không phải là quản lý!");
		}
		
		return "joinClub";
	}

	@PostMapping(path = "/joinClub")
	public String createJoinClub(@ModelAttribute("idMember") int idMember, @RequestParam("clubs") String[]  clubs) {
		
		System.out.println(idMember);
		for(String s:clubs) {
			Club club = new Club();
			club.setIdClub(Integer.parseInt(s));
			JoinClub joinClub = new JoinClub();
			joinClub.setDateJoin(new Date());
			joinClub.setClub(club);
			Status status =new Status();
			status.setIdStatus(1);
			joinClub.setStatus(status);
			Member member = new Member();
			member.setIdMember(idMember);
			joinClub.setMember(member);
			
		}		
		
		return "redirect:/club/joinClub";
	}
}
