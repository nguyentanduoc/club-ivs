package com.vn.ivs.ctu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.ivs.ctu.entity.Attendance;
import com.vn.ivs.ctu.entity.Club;
import com.vn.ivs.ctu.entity.JoinClub;
import com.vn.ivs.ctu.entity.Member;
import com.vn.ivs.ctu.entity.Summarization;
import com.vn.ivs.ctu.entity.Train;
import com.vn.ivs.ctu.service.AttendanceService;
import com.vn.ivs.ctu.service.ClubService;
import com.vn.ivs.ctu.service.JoinClubService;
import com.vn.ivs.ctu.service.MemberService;
import com.vn.ivs.ctu.service.SumarizationService;
import com.vn.ivs.ctu.service.TrainService;
import com.vn.ivs.ctu.utils.DateUtils;

@Controller
@RequestMapping(value= {"/"})
public class HomeController {
	
	
	@Autowired TrainService trainService;
	@Autowired AttendanceService attendanceService;
	@Autowired ClubService clubService;
	@Autowired MemberService memberService;
	@Autowired JoinClubService joinClubSerive;
	@Autowired SumarizationService sumarizationService;
	
	@GetMapping(value="logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }
		
	@RequestMapping(path= {"","login"})
	public String login(){
		return "login";
	}
	
	@RequestMapping(path= {"admin"})
	public String admin() {
		return "admin/index";
	}
	
	@RequestMapping(path= {"otc"})
	public String otc() {
		return "otc/index";
	}
	@RequestMapping(path= {"otcclub"})
	public String otcclub() {
		return "otcclub/index";
	}
	@RequestMapping(path= {"member"})
	public String member() {
		return "member/index";
	}
	@RequestMapping(path="403")
	public String accessDinied() {		
		return "redirect:/login?accessDinied";
	}
	@RequestMapping(path="404")
	public String notFount() {		
		return "404";
	}
	
	@GetMapping("test")
	public String test() {	
		
		List<Club> clubs = clubService.getAll();
		for(Club c:clubs) {			
			List<Train> trains = trainService.getAllTrainByClub(DateUtils.getCurentMonth(), DateUtils.getCurentYear(), c.getIdClub());
			int sobuoi = trains.size();
			List<JoinClub> joinClubs = joinClubSerive.getJoinClubByClub(c.getIdClub());
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
				sum.setMonthSum(DateUtils.getCurentMonth());
				sum.setYearSum(DateUtils.getCurentYear());
				if(sumarizationService.createOrUpdate(sum)>0) {
					System.out.println("----------------------------------------- Thanh CONG");
				}else {
					System.out.println("----------------------------------------- That Bai");
				}
			}
			/**/
			//List<Attendance>  attendances = attendanceService.getAttendanceByClub(DateUtils.getCurentMonth(),c.getIdClub());
			
		}
		
		return "404";
	}
}
