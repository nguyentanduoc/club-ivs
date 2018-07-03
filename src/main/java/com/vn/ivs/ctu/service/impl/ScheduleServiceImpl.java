package com.vn.ivs.ctu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.vn.ivs.ctu.dao.ScheduleDAO;
import com.vn.ivs.ctu.entity.Schedule;
import com.vn.ivs.ctu.entity.Train;
import com.vn.ivs.ctu.service.ScheduleService;
import com.vn.ivs.ctu.service.TrainService;

@Service
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ScheduleServiceImpl implements ScheduleService{

	@Autowired
	ScheduleDAO scheduleDAO;
	@Autowired
	TrainService trainservice;
	@Autowired
	ScheduleService scheduleService;
	
	public long create(Schedule schedule) {
		return scheduleDAO.create(schedule);		
	}
	
	public boolean deleteSchedule(int id) {
		if(trainservice.deleteTrainByIdSchedule(id)) {
			return scheduleDAO.deleteSchedule(id);
		}
		return false;
	}
	public List<Schedule> getAll(int idClub) {
		return scheduleDAO.getAll(idClub);
	}

	@Override
	public List<Schedule> getListScheduleAuto(int idClub) {
		
		return scheduleDAO.getListScheduleAuto(idClub);
	}
	@Override
	public List<Schedule> getAllScheduleTotal() {
		return scheduleService.getAllScheduleTotal();
	}
	
	
}