package com.vn.ivs.ctu.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vn.ivs.ctu.dao.RoleDAO;
import com.vn.ivs.ctu.entity.Branch;
import com.vn.ivs.ctu.entity.Club;
import com.vn.ivs.ctu.entity.JoinClub;
import com.vn.ivs.ctu.entity.JoinDateLeave;
import com.vn.ivs.ctu.entity.Member;
import com.vn.ivs.ctu.entity.Role;
import com.vn.ivs.ctu.service.BranchService;
import com.vn.ivs.ctu.service.ClubService;
import com.vn.ivs.ctu.service.JoinClubService;
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
	@Autowired JoinClubService joinClubService;

	@InitBinder
	public void bindForm(final WebDataBinder binder) {
		binder.registerCustomEditor(Set.class, "roles", new CustomFormBinder<RoleService>(roleService, Set.class));
	}

	@GetMapping(path = "/admin")
	public String Index(@RequestParam(name="status",required=false) String status,ModelMap modelMap,Integer offset, Integer maxResults) {
		maxResults=maxResults!=null?maxResults:5;
		offset=offset!=null?offset:0;
		modelMap.put("action1", "member");
		modelMap.put("action2", "adminMember");
		modelMap.put("title", "Thêm thành viên");
		Member member = new Member();
		member.setSexMember(true);
		modelMap.put("member", member);
		modelMap.put("listRole", roleService.getAll());
		modelMap.put("listMember", memberService.findAll(offset, maxResults));
		modelMap.put("listBranch", branchSevice.getAll());		
		modelMap.put("count", memberService.count());
		modelMap.put("offset", offset);
	
		if(status!=null) {
			if(status.equals("200")) {
				modelMap.put("status", 200);
				modelMap.put("message", "Thành Công!");
			}else {
				modelMap.put("status", 400);
				modelMap.put("message", "Thất Bại!");
			}
		}
		
		return "memberAdmin";
	}

	@PostMapping(path = "/admin")
	public String add(@ModelAttribute("member") Member member, BindingResult result, ModelMap modelMap) {
		member.setStatus(true);
		member.setPassWordMember(PasswordEncoder.BCryptPassdEncoder(member.getPassWordMember()));
		if (memberService.saveOrUpdate(member) > 0) {
			return "redirect:/member/admin?status=200";
		} else {
			return "redirect:/member/admin?status=400";
		}
	}
	
	@GetMapping(path = "/create")
	public String create(@RequestParam(name="status",required=false) String status,ModelMap modelMap,Integer offset, Integer maxResult) {
		modelMap.put("action1", "member");
		modelMap.put("action2", "indexMember");
		modelMap.put("title", "Thêm thành viên");
		maxResult=maxResult!=null?maxResult:5;
		offset=offset!=null?offset:0;
		if(SecurityUtils.getMyUserDetail()!=null) {
			long idLeader = SecurityUtils.getMyUserDetail().getIdMember();
			Branch branch = branchSevice.getBranchByMember(idLeader);
			if(branch!=null) {								
				List<Member> members = memberService.getAllByBranch(branch.getIdBranch());
				Member member = new Member();				
				modelMap.put("member", member);
				modelMap.put("listRole", roleService.getOfLeader());
				modelMap.put("listMember", memberService.getAllByBranch(branch.getIdBranch(), offset, maxResult));
				modelMap.put("count", members.size());
				modelMap.put("offset", offset);
				modelMap.put("idBranch",branch.getIdBranch());
			}else {
				modelMap.put("status", 403);
				modelMap.put("message", "Bạn chưa quản lý chi nhánh nào!");
			}	
		}else {
			return "redirect:/";
		}
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
	public String create(@ModelAttribute("member") Member member, BindingResult result, ModelMap modelMap) {
		try {
			long idLeader = SecurityUtils.getMyUserDetail().getIdMember();
			Branch branch = branchSevice.getBranchByMember(idLeader);
			member.setBranch(branch);
			member.setStatus(true);
			member.setPassWordMember(PasswordEncoder.BCryptPassdEncoder(member.getPassWordMember()));
			if (memberService.saveOrUpdate(member) > 0) {
				return "redirect:/member/create?status=200";
			} else {
				return "redirect:/member/create?status=400";
			}
		}catch (Exception e) {
			return "redirect:/member/create?status=400";
		}
		
	}
	
	@GetMapping(path="profile")
	public String profileMember(ModelMap modelMap) {
		long idMember = SecurityUtils.getMyUserDetail().getIdMember();		
		modelMap.put("member",memberService.getMemberById(idMember));
		modelMap.put("action1", "profile");
		modelMap.put("title", "Trang cá nhân");
		List<JoinClub> joinclubs = joinClubService.getJoinClubByIdMember(idMember);
		List<JoinDateLeave> days = new ArrayList<>();
		for(JoinClub j:joinclubs) {
			if(j.isStatus()==false) {	
				days.add(new JoinDateLeave(j.getDateLeave(),j.getClub().getNameClub(),j.isStatus()));
				days.add(new JoinDateLeave(j.getDateJoin(),j.getClub().getNameClub(),j.isStatus()));
			}	else {
				days.add(new JoinDateLeave(j.getDateJoin(),j.getClub().getNameClub(),j.isStatus()));
			}
		}
		 Collections.sort(days, new Comparator<JoinDateLeave>() {
		      @Override
		      public int compare(final JoinDateLeave object1, final JoinDateLeave object2) {
		          return - object1.getDateSort().compareTo(object2.getDateSort());
		      }
		  });
		 modelMap.put("listDateSort",days);
		return "profile";		
	}
	/*@PostMapping(path="loadMember")
	@ResponseBody
	public Map<String,Object> loadMember(@RequestParam("page") int page){
		Map<String, Object> map = new HashMap<>();
		map.put("status","200");
		map.put("listMember", memberService.findAll(Pagination.MAX_SIZE_MEMBER*(page-1)));
		return map;
	}*/
	
	/*@PostMapping(path="loadMemberBranch")
	@ResponseBody
	public Map<String,Object> loadMemberBranch(@RequestParam("page") int page,@RequestParam("idBranch") int idBranch){
		Map<String, Object> map = new HashMap<>();
		map.put("status","200");
		map.put("listMember", memberService.getAllByBranch(idBranch,Pagination.MAX_SIZE_MEMBER*(page-1)));
		return map;
	}*/
	
	@GetMapping(path="editMember/{idMember}")
	public String editMember(@PathVariable(name="idMember",required=false)String idMember,ModelMap modelMap) {

		if(idMember!=null) {
			try {
				modelMap.put("action1", "member");
				modelMap.put("title", "Sửa thông tin");
				int IntidMember = Integer.parseInt(idMember);
				Member member = memberService.getMemberById(IntidMember);
				modelMap.put("member", member);
				modelMap.put("listRole", roleService.getOfLeader());
				return "editMember";
			}
			catch(Exception e) {
				return "redirect:/404";
			}
		}		
		else {
			return "redirect:/404";
		}
	}	
	@GetMapping(path="editAdminMember/{idMember}")
	public String editAdminMember(@PathVariable(name="idMember",required=false)String idMember,ModelMap modelMap) {

		if(idMember!=null) {
			try {
				modelMap.put("action1", "member");
				modelMap.put("title", "Member");
				int IntidMember = Integer.parseInt(idMember);
				Member member = memberService.getMemberById(IntidMember);
				modelMap.put("member", member);
				modelMap.put("listRole", roleService.getAll());
				return "editMember";
			}
			catch(Exception e) {
				return "redirect:/404";
			}
		}		
		else {
			return "redirect:/404";
		}
	}	
	@PostMapping(path="/update")
	public String updateMember(@RequestParam("idMember")int idMember, @RequestParam("roles") String[] roles, @RequestParam(name="status")boolean status) {
	
		Member member = memberService.getMemberById(idMember);
		member.setStatus(status);
		Set<Role>  rolesMember = new HashSet<>();
		for(String s:roles) {
			Role r = new Role();
			r.setIdRole(Integer.parseInt(s));
			rolesMember.add(r);			
		}
		member.setRoles(rolesMember);
		if(memberService.saveOrUpdate(member)>0) {
			return "redirect:/member/editMember/"+idMember;
		}
		else {
			return "redirect:/member/editMember/"+idMember;
		}
	}
	
	@PostMapping(path="resetPassWord")
	@ResponseBody
	public Map<String, Object> restPassWord(int idMember){
		Map<String, Object> map =new HashMap<>();
		Member member = memberService.getMemberById(idMember);
		member.setPassWordMember(PasswordEncoder.defaultPassWord());
		if(memberService.saveOrUpdate(member)>0) {
			map.put("status", 200);
			map.put("message", "Cập nhật thành công!");
		}else {
			map.put("status", 400);
			map.put("message", "Xảy ra lỗi!");
		}
		return map;
	}
	
	@PostMapping("deleteMember")
	@ResponseBody
	public Map<String,Object> deleteMember(int idMember){
		Map<String,Object> map = new HashMap<>();
		if(memberService.delete(idMember)) {
			map.put("status", 200);
		}
		else {
			map.put("status", 400);
		}
		return map;
	}
	/*@PostMapping(path="searchMember")
	@ResponseBody			
	public Map<String,Object> searchMember(String txtSearch){
		Map<String,Object> map = new HashMap<>();
		String[]  arraySearch =  txtSearch.split(" ");
		
		return map;
	}*/
	@PostMapping("updateInfo")
	public String updateInfo(@ModelAttribute(name="member") Member member){
		Member member2 = memberService.getMemberById(SecurityUtils.getMyUserDetail().getIdMember());
		member2.setBirthDayMember(member.getBirthDayMember());
		member2.setNameMember(member.getNameMember());
		member2.setSexMember(member.isSexMember());
		member2.setPhoneNumberMember(member.getPhoneNumberMember());
		Map<String,Object> map = new HashMap<>();
		if(memberService.saveOrUpdate(member2)>0) {
			map.put("status", 200);
		}
		else {
			map.put("status", 400);
		}
		return "redirect:/member/profile";
	}
	@PostMapping(path="/updatePass")
	public String updatePass(@RequestParam("reTypePassWord")String passwordMember) {
		Member member = memberService.getMemberById(SecurityUtils.getMyUserDetail().getIdMember());
		member.setPassWordMember(PasswordEncoder.BCryptPassdEncoder(passwordMember));
		memberService.saveOrUpdate(member);
			return "redirect:/logout";
	}
	@PostMapping(path="/checkPassWord")
	@ResponseBody
	public Map<String, Object> checkPassWord(String password){
		Map<String, Object> map =new HashMap<>();
		Member member = memberService.getMemberById(SecurityUtils.getMyUserDetail().getIdMember());
		if(member!=null) {
			String pass = PasswordEncoder.BCryptPassdEncoder(password);
			
			System.out.println(pass);
			if(PasswordEncoder.matches(pass, member.getPassWordMember())) {
				map.put("status", 200);
				map.put("matches", true);
			}else {
				map.put("status", 200);
				map.put("matches", false);
			}
		}else {
			map.put("status", 400);
			map.put("message", "Xảy ra lỗi!");
		}
		return map;
	}
}
