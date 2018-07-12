package com.vn.ivs.ctu.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.vn.ivs.ctu.entity.Branch;
import com.vn.ivs.ctu.entity.Club;
import com.vn.ivs.ctu.entity.JoinClub;
import com.vn.ivs.ctu.entity.Member;
import com.vn.ivs.ctu.entity.Role;
import com.vn.ivs.ctu.service.BranchService;
import com.vn.ivs.ctu.service.ClubService;
import com.vn.ivs.ctu.service.JoinClubService;
import com.vn.ivs.ctu.service.MemberService;
import com.vn.ivs.ctu.service.RoleService;
import com.vn.ivs.ctu.utils.BinderMember;
import com.vn.ivs.ctu.utils.MyUserDetail;
import com.vn.ivs.ctu.utils.SecurityUtils;

@Controller
@RequestMapping(path="/club")
public class ClubController {
	
	@Autowired BranchService branchSevice;
	@Autowired ClubService clubService;
	@Autowired MemberService memberService;
	@Autowired JoinClubService joinClubService;
	@Autowired RoleService roleService;
	
	@InitBinder
	public void bindForm(final WebDataBinder binder) {
		binder.registerCustomEditor(Set.class, "members", new BinderMember<MemberService>(memberService, Set.class));
	}
	
	@GetMapping(path="/index")
	public String index(@RequestParam(name="message",required=false) String message, ModelMap modelMap){
		modelMap.put("action1", "club");
		modelMap.put("action2", "create");
		modelMap.put("title", "Câu Lạc Bộ");			
		long idLeader = SecurityUtils.getMyUserDetail().getIdMember();
		Branch branch = branchSevice.getBranchByMember(idLeader);		
		Club club = new Club();
		club.setBranch(branch);
		modelMap.put("clubs", clubService.getAll());
		List<Member> members = memberService.getAllLeaderClub();
 		modelMap.put("members",members);
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
		String url="";
		if(SecurityUtils.getMyUserDetail()!=null) {
			MyUserDetail user = SecurityUtils.getMyUserDetail();
			Branch branch = branchSevice.getBranchByMember(user.getIdMember());
			club.setBranch(branch);
			if(clubService.saveOrUpdate(club)>0) {
				Set<Member> members  = club.getMembers();
				boolean isMember=false;
				for(Member m:members) {
					Set<Role> roles= m.getRoles();
					if(roles!=null) {
						for(Role r:m.getRoles()) {
							if(r.getCodeRole().equals("MEMBER")) {
								isMember=true;
							}
						}
					}
					if(isMember==false) {
						Role r = roleService.getRoleByCode("MEMBER");
						roles.add(r);
						m.setRoles(roles);
						memberService.saveOrUpdate(m);
					}
					JoinClub jc = new JoinClub();
					jc.setClub(club);
					jc.setMember(m);
					jc.setStatus(true);
					jc.setDateJoin(new Date());
					joinClubService.createOrUpdate(jc);
				}
				url= "redirect:/club/index?message=success";
			}else {
				url  = "redirect:/club/index?message=error";
				}
		}else {
			url = "redirect:/club/index?message=error";
		}
		return url;
	}
	
	@GetMapping(path = "/joinClub")
	public String joinClub(@RequestParam(name="status",required=false)String message,ModelMap modelMap) {
		modelMap.put("action1", "club");
		modelMap.put("action2", "joinClub");
		modelMap.put("title", "Thêm thành viên vào Club");
		long idOTC = SecurityUtils.getMyUserDetail().getIdMember();
		Branch branch = branchSevice.getBranchByMember(idOTC);
		if(branch!=null) {
			modelMap.put("members", memberService.getAllByBranch(branch.getIdBranch()));
			modelMap.put("clubs", clubService.getClubByBranch(branch.getIdBranch()));
		}else{
			modelMap.put("status", 403);
		}		
		if(message!=null) {
			if(message.equals("200")) {
				modelMap.put("status", 200);
			}else {
				modelMap.put("status", 400);
			}
		}
		return "joinClub";
	}

	@PostMapping(path = "/joinClub")
	public String createJoinClub(@RequestParam("idMember") long idMember, @RequestParam("clubs") String[]  clubs) {
		boolean success = true;
		for(String idClub:clubs) {
			try {
				Club club = clubService.getClubById(Integer.parseInt(idClub));
				Member member = memberService.getMemberById(idMember);
				JoinClub joinClub = new JoinClub();
				joinClub.setDateJoin(new Date());
				joinClub.setMember(member);
				joinClub.setClub(club);
				joinClub.setStatus(true);
				List<JoinClub> jl = joinClubService.getJoinClubByIdMember(idMember);
				for(JoinClub j:jl) {
					if((j.getClub().getIdClub()==club.getIdClub())&&(j.isStatus()==true)) {
						success = false;
					}else {
						success= true;					
					}					
				}	
				if(success) {
					if(joinClubService.createOrUpdate(joinClub)>0) {
						success = true;
					}else {
						success = false;
					}
				}
			}catch(Exception e) {
				return "redirect:/club/joinClub?status=404";				
			}			
		}		
		if(success) {
			return "redirect:/club/joinClub?status=200";
		}else {
			return "redirect:/club/joinClub?status=400";
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
		long idLeader = SecurityUtils.getMyUserDetail().getIdMember();
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
	
	@GetMapping(path="/edit")
	public String editClub(@RequestParam(name="id",required=false) String id,@RequestParam(name="status",required=false) String status, ModelMap map) {
		String url="/404";
		if(id!=null) {
			try {
				int intId= Integer.parseInt(id);
				Club club  = clubService.getClubById(intId);				
				if(club!=null) {
					if(status!=null) {
						map.put("status",status);
					}
					List<Member> members = memberService.getAllLeaderClub();
					map.put("members",members);
					map.put("club", club);
					url="/editClub";
				}else {
					url="/404";
				}				
			}catch (Exception e) {
				url="/404";
			}
		}		
		return url;
	}
	@PostMapping(path="/edit")
	public String updateClub(@ModelAttribute("club") Club club) {		
		String url = "redirect:/club/edit/?id="+club.getIdClub();
		Club clubget = clubService.getClubById(club.getIdClub());
		clubget.setNameClub(club.getNameClub());
		clubget.setMembers(club.getMembers());
		if(clubService.saveOrUpdate(clubget)>0) {
			url+="&status=200";
		}else {
			url+="&status=400";
		}		
		return url;
	}
}
