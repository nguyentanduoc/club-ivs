package com.vn.ivs.ctu.component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.vn.ivs.ctu.service.AttendanceService;
import com.vn.ivs.ctu.service.ClubService;
import com.vn.ivs.ctu.entity.Attendance;
import com.vn.ivs.ctu.utils.DateUtils;
import com.vn.ivs.ctu.entity.Club;

@Component
public class ToGradeComponent {
	
	Map<String, Object> map = new HashMap<>();
	
	@Autowired ClubService clubService;
	@Autowired AttendanceService attendanceService;
	
	@Scheduled(cron = "0 0 0 5 * ?",zone="Asia/Saigon")
	public void toGrade() {
		List<Club> clubs = clubService.getAll();
		for(Club c:clubs) {
			
			List<Attendance>  attendances = attendanceService.getAttendanceByClub(DateUtils.getCurentMonth(),c.getIdClub());
			
		}
	}
}
