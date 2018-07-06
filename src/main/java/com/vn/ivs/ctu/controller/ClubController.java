package com.vn.ivs.ctu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import com.vn.ivs.ctu.entity.Club;
import com.vn.ivs.ctu.entity.JoinClub;
import com.vn.ivs.ctu.entity.Member;
import com.vn.ivs.ctu.service.BranchService;
import com.vn.ivs.ctu.service.ClubService;
import com.vn.ivs.ctu.service.JoinClubService;
import com.vn.ivs.ctu.service.MemberService;
import com.vn.ivs.ctu.utils.SecurityUtils;

@Controller
@RequestMapping(path="/club")
public class ClubController {
	
	@Autowired BranchService branchSevice;
	@Autowired ClubService clubService;
	@Autowired MemberService memberService;
	@Autowired JoinClubService joinClubService;
	
	@GetMapping(path="/index")
	public String index(@RequestParam(name="message",required=false) String message, ModelMap modelMap){
		modelMap.put("action1", "club");
		modelMap.put("action2", "create");
		modelMap.put("title", "Câu Lạc Bộ");			
		int idLeader = SecurityUtils.getMyUserDetail().getIdMember();
		Branch branch = branchSevice.getBranchByMember(idLeader);		
		Club club = new Club();
		modelMap.put("clubs", clubService.getAll());
		List<Member> members = memberService.getAllLeaderClubByBranch(branch.getIdBranch());
		List<Member> notfount = new ArrayList<>();
		for(Member m:members) {
			if(clubService.getLeaderClub(m.getIdMember())==null) {
				notfount.add(m);
			}			
		}
 		modelMap.put("members",notfount);
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
		
		if(SecurityUtils.getMyUserDetail()!=null) {
			int idLeader = SecurityUtils.getMyUserDetail().getIdMember();
			Branch branch = branchSevice.getBranchByMember(idLeader);
			club.setBranch(branch);
			if(clubService.saveOrUpdate(club)>0) {
				return "redirect:/club/index?message=success";
			}else {
				return "redirect:/club/index?message=error";
				}
		}else {
			return "redirect:/club/index?message=error";
		}
	}
	
	@GetMapping(path = "/joinClub")
	public String joinClub(@RequestParam(name="message",required=false)String message,ModelMap modelMap) {
		modelMap.put("action1", "club");
		modelMap.put("action2", "joinClub");
		modelMap.put("title", "Thêm thành viên vào Club");
		int idOTC = SecurityUtils.getMyUserDetail().getIdMember();
		Branch branch = branchSevice.getBranchByMember(idOTC);
		if(branch!=null) {
			modelMap.put("members", memberService.getAllByBranch(branch.getIdBranch()));
			modelMap.put("clubs", clubService.getClubByBranch(branch.getIdBranch()));
		}else{
			modelMap.put("status", 403);
			modelMap.put("message", "Bạn không phải là quản lý!");
		}		
		if(message!=null) {
			if(message.equals("success")) {
				modelMap.put("status", 200);
				modelMap.put("message", "Thành Công!");
			}else {
				modelMap.put("status", 400);
				modelMap.put("message", "Thất Bại!");
			}
		}
		return "joinClub";
	}

	@PostMapping(path = "/joinClub")
	public String createJoinClub(@RequestParam("idMember") int idMember, @RequestParam("clubs") String[]  clubs) {
		boolean success = true;
		for(String s:clubs) {
			try {
				Club club = new Club();			
				club.setIdClub(Integer.parseInt(s));
				JoinClub joinClub = new JoinClub();
				joinClub.setDateJoin(new Date());
				club.setIdClub(Integer.parseInt(s));
				joinClub.setClub(club);	
				joinClub.setStatus(true);
				Member member = new Member();
				member.setIdMember(idMember);
				joinClub.setMember(member);
				if(joinClubService.createOrUpdate(joinClub)>0) {
					success = true;
				}else {
					success = false;
				}
			}catch(Exception e) {
				System.out.println(e.toString());
				return "redirect:/club/joinClub?message=error";				
			}			
		}		
		if(success) {
			return "redirect:/club/joinClub?message=success";
		}else {
			return "redirect:/club/joinClub?message=error";
		}
		
	}
	
	@PostMapping(path="checkMember")
	@ResponseBody
	public Map<String,Object> checkMember(int idMember){
		Map<String,Object> map =new HashMap<>();
		if(clubService.getLeaderClub(idMember)!=null) {
			map.put("status", 200);
		}else {
			map.put("status", 404);
		}
		return map;
	}
	
	@GetMapping(path="/listJoinClub")
	public String listJoinClub(ModelMap modelMap) {
		modelMap.put("action1", "club");
		modelMap.put("action2", "listJoinClub");
		modelMap.put("title", "Danh sách hoạt động");	
		int idLeader = SecurityUtils.getMyUserDetail().getIdMember();
		Branch branch = branchSevice.getBranchByMember(idLeader);
		List<Club> clubs = clubService.getClubByBranch(branch.getIdBranch());
		modelMap.put("clubs", clubs);
		return "listJoinClub";
	}
	
	@PostMapping("/active")
	@ResponseBody
	public Map<String,Object> offActive(int idJoinClub,boolean status){
		Map<String,Object> map = new HashMap<>();
		JoinClub joinClub = joinClubService.getJoinClub(idJoinClub);
		joinClub.setIdJoinClub(idJoinClub);
		joinClub.setStatus(status);
		joinClub.setDateLeave(new Date());
		if(joinClubService.createOrUpdate(joinClub)>0) {
			map.put("status", 200);
		}else {
			map.put("status", 400);
		}
		return map;
	}
	
	@PostMapping("/getMemberJoinClub")
	@ResponseBody
	public Map<String,Object> getMemberJoinClub(int idClub){
		Map<String,Object> map = new HashMap<>();
		map.put("member", joinClubService.getListMemberActive(idClub));
		map.put("status", 200);
		return map;
	}
}
