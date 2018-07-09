package com.vn.ivs.ctu.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
				url = "/admin";
			} else if (RoleUtils.isLeader(roles)) {
				url = "/leader";
			} else if (RoleUtils.isLeaderClub(roles)) {
				url = "/leaderclub";
			} else if (RoleUtils.isMember(roles)) {
				url = "/member";
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
	public String leader() {
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
	
	@GetMapping("test1")
	public String test1() {
		List<Club> clubs = clubService.getAll();
		for(Club c:clubs) {			
			List<Train> trains = trainService.getAllTrainByClub(DateUtils.getCurentMonth(), DateUtils.getCurentYear(), c.getIdClub());
			int sobuoi = trains.size();
			List<JoinClub> joinClubs = joinClubService.getJoinClubByClub(c.getIdClub());
			for(JoinClub j: joinClubs) {
				int sbdd = 0;
				float scoreClub = 0;
				for(Train train: trains) {
					Attendance ats = attendanceService.getAttendByIdMember(j.getMember().getIdMember(), train.getIdTrain());	
					if(ats!=null) {
						if(ats.isAttendance()) {
							sbdd +=1;
						}
					}										
				}	
				if(sobuoi-sbdd==0) {					
					scoreClub = 100;
				}else {
					if(sobuoi-sbdd<=2) 
						scoreClub = 80;
					else 
						scoreClub = 80 - (sobuoi-sbdd) * 20;
				}
				Summarization sum = new Summarization();
				sum.setMember(j.getMember());
				sum.setClub(j.getClub());
				sum.setScoreClub(scoreClub);
				sum.setRequireDonate(false);
				sum.setSeeDonate(false);
				sum.setToAriseScore(0);
				sum.setMonthSum(DateUtils.getCurentMonth()-1);
				sum.setYearSum(DateUtils.getCurentYear());
				sumarizationService.createOrUpdate(sum);				
			}
		}			
		return "404";
	}
	
	@GetMapping("test")
	public String test() {	
		List<Branch> branchs = branchService.getAll();
		int month = DateUtils.getCurentMonth()-1;
		int year = DateUtils.getCurentYear();
		
		for(Branch b:branchs) {
			List<Member> members = memberService.getAllByBranch(b.getIdBranch());
			for(Member member:members) {
				float score=0,total = 0;
				float c = 0;		
				boolean requireDonate = false;
				List<Summarization> sums = sumarizationService.getSumByMemberPreMonth(member.getIdMember(), month, year);
				try {
					if(sums.size()>0 && sums!=null) {
						for(Summarization sum:sums) {
							c+=1;
							score += sum.getScoreClub() + sum.getToAriseScore();
							if(sum.isRequireDonate()) {
								requireDonate=true;
							}
						}
						total = (score + (c-1)*10);
						SumarizationBranch sum =  new SumarizationBranch();
						sum.setScoreBranch(total*Float.parseFloat("0.8"));
						sum.setMember(member);
						sum.setBranch(b);
						sum.setDonate(requireDonate);
						sum.setConfirm(false);
						sum.setMonth(month);
						sum.setYear(year);
						sum.setConfirmDonate(false);						
					}
				}catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		}
		
		return "404";
	}
	@GetMapping(path="chooseClub")
	public String chooseClub(ModelMap modelMap) {
		MyUserDetail myUser = SecurityUtils.getMyUserDetail();	
		modelMap.put("clubs", myUser.getClubs());		
		return "chooseClub";
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@PostMapping(path="chooseClub")
	public String chooseClub(@RequestParam(name="club",required=false) String idClub,HttpServletRequest request) {
		if(idClub!=null) {
			MyUserDetail myUser = SecurityUtils.getMyUserDetail();	
			Set<Club> clubs = myUser.getClubs() ;
			for(Club club:clubs) {
				if(idClub.equals(club.getIdClub())) {
					request.getSession().setAttribute("club",club);
				}
			}			
			return "redirect:/";
		}else {
			return "redirect:/chooseClub";
		}
	}
}
