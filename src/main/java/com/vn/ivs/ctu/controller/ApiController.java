package com.vn.ivs.ctu.controller;

import java.util.List;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vn.ivs.ctu.entity.Attendance;
import com.vn.ivs.ctu.entity.AttendanceID;
import com.vn.ivs.ctu.entity.JoinClub;
import com.vn.ivs.ctu.entity.Branch;
import com.vn.ivs.ctu.entity.Club;
import com.vn.ivs.ctu.entity.Member;
import com.vn.ivs.ctu.entity.Role;
import com.vn.ivs.ctu.entity.Schedule;
import com.vn.ivs.ctu.entity.Train;
import com.vn.ivs.ctu.service.AttendanceService;
import com.vn.ivs.ctu.service.TrainService;
import com.vn.ivs.ctu.service.impl.DowServiceImpl;
import com.vn.ivs.ctu.service.impl.RoleServiceImpl;
import com.vn.ivs.ctu.service.impl.ScheduleServiceImpl;
import com.vn.ivs.ctu.utils.SecurityUtils;
import com.vn.ivs.ctu.service.BranchService;
import com.vn.ivs.ctu.service.ClubService;
import com.vn.ivs.ctu.service.DowService;
import com.vn.ivs.ctu.service.JoinClubService;
import com.vn.ivs.ctu.service.MemberService;
import com.vn.ivs.ctu.service.RoleService;
import com.vn.ivs.ctu.service.ScheduleService;

@Controller
@RequestMapping("api/")
public class ApiController {

	@Autowired RoleService roleService;
	@Autowired DowService dowService;	
	@Autowired BranchService branchService;	
	@Autowired MemberService memberService;
	@Autowired ClubService clubService;
	@Autowired ScheduleService scheduleService;
	@Autowired TrainService trainservice;
	@Autowired JoinClubService joinClubService;
	@Autowired AttendanceService attendanceService;
	
//role
	@PostMapping("deleteRole")
	@ResponseBody
	public String deleteRole(@RequestParam int id) {		
		boolean rs = roleService.deleteRole(id);
		if(rs) {
			return "true";
		}else {
			return "false";
		}
	}	
	
	@PostMapping("getRoleById")
	@ResponseBody
	public Map<String,Object> getRoleById(@RequestParam int id) {		
		Map<String,Object> map = new HashMap<String, Object>();
		System.out.println(id);
		Role rs = roleService.getRoleById(id);
		if(rs!=null) {
			map.put("status", "200");
			map.put("role", rs);
		}else {
			map.put("status", "404");
		}		
		return map;
	}
	
	@PostMapping("saveChangeRole")
	@ResponseBody
	public Map<String , Object> saveChangeRole(@ModelAttribute("role") Role role){
		
		Map<String,Object> map = new HashMap<String, Object>();
				
		if(roleService.createOrUpdate(role)>0) {			
			map.put("status", "200");			
		}else {
			map.put("status", "400");			
		}
		return map;
	}//end role
	//dow

	@GetMapping("deleteDow")
	@ResponseBody
	public String deleteDow(@RequestParam int id) {		
		boolean rs = dowService.deleteDow(id);
		if(rs) {
			return "true";
		}else {
			return "false";
		}
	}//end dow
	
	//start branch
	@PostMapping("deleteBranch")
	@ResponseBody
	public String deleteBranch(@RequestParam int id) {		
		boolean rs = branchService.delete(id);
		if(rs) {
			return "true";
		}else {
			return "false";
		}
	}
	
	@PostMapping("getBranchById")
	@ResponseBody
	public Map<String,Object> getBranchById(@RequestParam int id) {		
		Map<String,Object> map = new HashMap<>();		
		try{
			map.put("status",200);
			map.put("branch", branchService.getBranchById(id));
			map.put("members", memberService.getAllRoleOTC());
		}catch(Exception e) {
			map.put("status", 400);
		}
		return map;
	}
	@PostMapping("saveChangeBranch")
	@ResponseBody
	public Map<String , Object> saveChangeBranch(@ModelAttribute("branch") Branch branch){
				
		Map<String,Object> map = new HashMap<String, Object>();
				
		if(branchService.saveOrUpdate(branch)>0) {			
			map.put("status", "200");			
		}else {
			map.put("status", "400");			
		}
		return map;
	}
	//end Branch
	//get Member by Branch
	@PostMapping("getMemberByBranch")
	@ResponseBody
	public  Map<String , Object> getMemberByBranch(@RequestParam int idBranch,HttpSession session) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<Member> members =  memberService.getAllByBranch(idBranch);
		
		if(members!=null) {
			map.put("status", "200");
			/*List<MemberView> mvs = new  ArrayList<>();			
			for(Member m :members) {
				mvs.add(new MemberView(m.getIdMember(), m.getNameMember()));
			}*/
			map.put("members",members);
		}else {
			map.put("status", "400");
		}
		return map;
	}
	//./getMemberByBranch
	
	//checkMember
	@ResponseBody
	@PostMapping(path="/checkMember")	
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
	//./checkMember
	
	//start club
	@PostMapping(path="/getClubById")
	@ResponseBody
	public Map<String, Object> getClubById(@RequestParam("id") int id) {
		Map<String,Object> map = new HashMap<>();
		Club club = clubService.getClubById(id);
		if(club!=null) {
			map.put("status",200);
			map.put("club",club);
			map.put("branchs", branchService.getAll());
			map.put("members",memberService.getAllLeaderClub());
		}else {
			map.put("status",400);
		}
		return map;
	}
	
	@PostMapping(path="/saveChangeClub")
	@ResponseBody
	public Map<String,String> saveChangeClub(@ModelAttribute("club") Club club){
		Map<String,String>  map =  new HashMap<>();
		if(clubService.saveOrUpdate(club)>0) {
			map.put("status", "200");
		}else {
			map.put("status", "400");
		}		
		return map;
	}
	@PostMapping(path="/deleteClub")
	@ResponseBody
	public Map<String,String> deleteClub(@RequestParam("idClub") int id){
		Map<String,String>  map =  new HashMap<>();		
		if(clubService.deleteClub(id)) {
			map.put("status", "200");
		}else {
			map.put("status", "400");
		}		
		return map;
	}
	//end club
	
	@GetMapping("deleteSchedule")
	@ResponseBody
	public String deleteSchedule(@RequestParam int id) {		
		boolean rs = scheduleService.deleteSchedule(id);
		if(rs) {
			return "true";
		}else {
			return "false";
		}
	}
	
	@GetMapping("deleteTrain")
	@ResponseBody
	public String deleteTrain(@RequestParam int id)
	{
		boolean rs = trainservice.deleteTrain(id);
		if(rs) {
			return "true";
		}else {
			return "false";
		}
	}
	
	@PostMapping(path="getJoinClubByTrain")
	@ResponseBody
	public Map<String,Object> getJoinClubByTrain(@RequestParam("idTrain") int idTrain){
		Map<String,Object> map = new HashMap<String, Object>();		
		
		List<Attendance> as = attendanceService.getAttendanceByTrain(idTrain);
		if(as!=null) {
			if(as.size()>0) {
				map.put("status",200);
				map.put("listJoinClubByClub",as);
			}else {
				map.put("status",404);
			}
		}else {
			map.put("status",400);
		}
		return map;
	}
	@PostMapping(path="attendance")
	@ResponseBody
	public int attendance(@RequestParam("idMember") int idMember, @RequestParam("idTrain") int idTrain,@RequestParam("attendance")boolean attendance) {
		AttendanceID attendanceID = new AttendanceID();
		attendanceID.setIdMember(idMember);
		attendanceID.setIdTrain(idTrain);
		Attendance attendanceEntity = new Attendance();
		attendanceEntity.setAttendanceID(attendanceID);
		attendanceEntity.setAttendance(attendance);
		System.out.println(attendanceEntity);
		if(attendanceService.createOrUpdate(attendanceEntity)) {
			return 200;
		}
		return 400;
	}
}
