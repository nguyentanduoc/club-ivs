package com.vn.ivs.ctu.component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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

@Component
public class ToGradeComponent {
	
	Map<String, Object> map = new HashMap<>();
	
	@Autowired ScheduleService scheduleService;
	@Autowired TrainService trainService;
	@Autowired MemberService memberService;
	@Autowired JoinClubService joinClubService;
	@Autowired AttendanceService attendanceService;
	@Autowired ClubService clubService;
	@Autowired SumarizationService sumarizationService;
	@Autowired BranchService branchService;
	@Autowired SumarizationBranchService  sumarizationBranchService;
	
	@Scheduled(cron = "0 0 3 3 * *",zone="Asia/Saigon")
	public void toGradeClub() {
		List<Club> clubs = clubService.getAll();
		for(Club c:clubs) {			
			List<Train> trains = trainService.getAllTrainByClub(DateUtils.getCurentMonth()-1, DateUtils.getCurentYear(), c.getIdClub());
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
	}
	
	@Scheduled(cron = "0 0 4 5 * *",zone="Asia/Saigon")
	public void toGradeBranch() {
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
						total = (score + (c-1)*10)/c;
						SumarizationBranch sum =  new SumarizationBranch();
						sum.setScoreBranch(total*Float.parseFloat("0.8"));
						sum.setMember(member);
						sum.setBranch(b);
						
						sum.setRequireDonate(requireDonate);
						sum.setDonate(false);
						sum.setConfirm(false);
						sum.setMonth(month);
						sum.setYear(year);
						sum.setConfirmDonate(false);	
						sumarizationBranchService.saveOrUpdate(sum);
					}
				}catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		}
	}
}
