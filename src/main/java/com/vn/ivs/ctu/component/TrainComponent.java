package com.vn.ivs.ctu.component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.vn.ivs.ctu.entity.Attendance;
import com.vn.ivs.ctu.entity.AttendanceID;
import com.vn.ivs.ctu.entity.JoinClub;
import com.vn.ivs.ctu.entity.Member;
import com.vn.ivs.ctu.entity.Schedule;
import com.vn.ivs.ctu.entity.Train;
import com.vn.ivs.ctu.service.JoinClubService;
import com.vn.ivs.ctu.service.MemberService;
import com.vn.ivs.ctu.service.ScheduleService;
import com.vn.ivs.ctu.service.TrainService;
import com.vn.ivs.ctu.service.AttendanceService;

@Component
public class TrainComponent {
	@Autowired ScheduleService scheduleService;
	@Autowired TrainService trainService;
	@Autowired MemberService memberService;
	@Autowired JoinClubService joinClubService;
	@Autowired AttendanceService attendanceService;
	
	@Scheduled(cron = "0 23 16 * * WED")
	public void showCalendar() {
		List<Schedule> schedules = scheduleService.getListScheduleAuto();
		for (Schedule schedule: schedules) {
			Date myDate = new Date();
			Calendar cal = Calendar.getInstance();
	        cal.setTime(myDate);
			int week = cal.get(Calendar.WEEK_OF_YEAR);
	        int year = cal.getWeekYear();
	        cal.add(Calendar.DATE, schedule.getDateOfWeek().getVariableDow());
	        Train train = new Train();
	        train.setDateTrain(cal.getTime());
	        train.setSchedule(schedule);
	        train.setWeekend(week);
			train.setYear(year);
	        trainService.create(train);
	        List<JoinClub> joinClubs = joinClubService.getJoinClubByClub(schedule.getClub().getIdClub());
	        if(joinClubs!=null) {
	        	for(JoinClub joinClub:joinClubs) {
	        		AttendanceID attendanceID = new AttendanceID();
	        		attendanceID.setIdMember(joinClub.getMember().getIdMember());
	        		attendanceID.setIdTrain(train.getIdTrain());
	        		Attendance attendance = new Attendance();
	        		attendance.setAttendance(true);
	        		attendance.setAttendanceID(attendanceID);
	        		System.out.println(attendanceService.createOrUpdate(attendance));
	        	}
	        }
		}
	}
}
