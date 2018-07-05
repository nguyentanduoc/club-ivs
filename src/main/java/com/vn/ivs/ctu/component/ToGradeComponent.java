package com.vn.ivs.ctu.component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.vn.ivs.ctu.entity.Attendance;
import com.vn.ivs.ctu.entity.Club;
import com.vn.ivs.ctu.entity.JoinClub;
import com.vn.ivs.ctu.entity.Summarization;
import com.vn.ivs.ctu.entity.Train;
import com.vn.ivs.ctu.service.AttendanceService;
import com.vn.ivs.ctu.service.ClubService;
import com.vn.ivs.ctu.service.JoinClubService;
import com.vn.ivs.ctu.service.MemberService;
import com.vn.ivs.ctu.service.ScheduleService;
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
	
	@Scheduled(cron = "0 0 3 5 * *",zone="Asia/Saigon")
	public void toGradeClub() {
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
				sum.setMonthSum(DateUtils.getCurentMonth());
				sum.setYearSum(DateUtils.getCurentYear());
				sumarizationService.createOrUpdate(sum);				
			}
		}
	}
	
	@Scheduled(cron = "0 0 4 5 * *",zone="Asia/Saigon")
	public void toGradeBranch() {
		
	}
}
