package com.vn.ivs.ctu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.ivs.ctu.entity.Attendance;
import com.vn.ivs.ctu.entity.Branch;
import com.vn.ivs.ctu.entity.Club;
import com.vn.ivs.ctu.entity.ClubView;
import com.vn.ivs.ctu.entity.JoinClub;
import com.vn.ivs.ctu.entity.Member;
import com.vn.ivs.ctu.entity.SumarizationBranch;
import com.vn.ivs.ctu.entity.Summarization;
import com.vn.ivs.ctu.entity.Train;
import com.vn.ivs.ctu.service.AttendanceService;
import com.vn.ivs.ctu.service.BranchService;
import com.vn.ivs.ctu.service.ClubService;
import com.vn.ivs.ctu.service.JoinClubService;
import com.vn.ivs.ctu.service.MemberService;
import com.vn.ivs.ctu.service.ScheduleService;
import com.vn.ivs.ctu.service.SumarizationBranchService;
import com.vn.ivs.ctu.service.SumarizationService;
import com.vn.ivs.ctu.service.TrainService;
import com.vn.ivs.ctu.utils.DateUtils;
import com.vn.ivs.ctu.utils.MyUserDetail;
import com.vn.ivs.ctu.utils.RoleUtils;
import com.vn.ivs.ctu.utils.SecurityUtils;

@Controller
@RequestMapping(value= {"/"})
@Scope("session")
public class HomeController {	
	
	@Autowired TrainService trainService;
	@Autowired AttendanceService attendanceService;
	@Autowired ClubService clubService;
	@Autowired MemberService memberService;
	@Autowired JoinClubService joinClubService;
	@Autowired SumarizationService sumarizationService;
	@Autowired BranchService branchService;
	@Autowired ScheduleService scheduleService;
	@Autowired SumarizationBranchService sumarizationBranchService;
	
	@GetMapping(path="")
	public String Index() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<String> roles = SecurityUtils.getAuthorities();
		String url = "login";
		if(auth!=null) {
			if (RoleUtils.isAdmin(roles)) {
				url = "/member/admin";
			} else if (RoleUtils.isLeader(roles)) {
				url = "/leader";
			} else if (RoleUtils.isLeaderClub(roles)) {
				url = "/schedule/scheduletotal";
			} else if (RoleUtils.isMember(roles)) {
				url = "/member/profile";
			}
		}
		return "redirect:"+url;
	}
	
	@GetMapping(value="logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }	
        return "redirect:/login";
    }
	
	@RequestMapping(path= {"login"})
	public String login(){
		return "login";
	}
	
	@RequestMapping(path= {"admin"})
	public String admin() {
		return "index";
	}
	
	@RequestMapping(path= {"leader"})
	public String leader(ModelMap modelMap) {
		long idLeader = SecurityUtils.getMyUserDetail().getIdMember();
		Branch branch = branchService.getBranchByMember(idLeader);		
		List<Club> clubs = clubService.getClubByBranch(branch.getIdBranch());
		List<ClubView> clv  =  new ArrayList<>();
		for(Club c:clubs) {
			List<JoinClub> jls = joinClubService.getAllJoinClub(c.getIdClub());
			int index =0;
			int deduct = 0;
			if(jls!=null) {
				for(JoinClub jl:jls) {
					if(DateUtils.getMonth(jl.getDateJoin())==DateUtils.getCurentMonth()-1) {
						index++;
					}	
					if(jl.getDateLeave()!=null) {
						if(DateUtils.getMonth(jl.getDateLeave())==DateUtils.getCurentMonth()-1){
							deduct++;
						}
					}				
				}
			clv.add(new ClubView(c.getNameClub(),index,deduct));		
			}
		}	
		modelMap.put("club", clv);
		return "index";
	}
	
	@RequestMapping(path= {"leaderclub"})
	public String leaderClub() {
		return "index";
	}
	@RequestMapping(path= {"member"})
	public String member() {
		return "index";
	}
	@RequestMapping(path="403")
	public String accessDinied() {		
		return "redirect:/login?accessDinied";
	}
	@RequestMapping(path="404")
	public String notFount() {		
		return "404";
	}
	
	@GetMapping(path="chooseClub")
	public String chooseClub(ModelMap modelMap) {
		MyUserDetail myUser = SecurityUtils.getMyUserDetail();	
		modelMap.put("clubs", myUser.getClubs());		
		return "chooseClub";
	}
	
	@PostMapping(path="chooseClub")
	public String chooseClub(@RequestParam(name="club",required=false) String idClub, HttpSession session) {
		
		if(idClub!=null) {
			MyUserDetail myUser = SecurityUtils.getMyUserDetail();	
			Set<Club> clubs = myUser.getClubs() ;
			for(Club club:clubs) {
				int intIdClub = Integer.parseInt(idClub);
				if(intIdClub==club.getIdClub()) {
					session.setAttribute("club",club);		
				}
			}			
			//System.out.println(((Club)session.getAttribute("club")).getNameClub());
			return "redirect:/";
		}else {
			return "redirect:/chooseClub";
		}
	}
}
