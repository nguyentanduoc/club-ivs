package com.vn.ivs.ctu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.vn.ivs.ctu.dao.ScheduleDAO;
import com.vn.ivs.ctu.entity.Schedule;
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
	
	public boolean deleteSchedule(long idSchedule) {
		if(trainservice.getTrainBySchedule(idSchedule).size()>0) {
			System.out.println(trainservice.getTrainBySchedule(idSchedule).size());
			if(trainservice.deleteTrainByIdSchedule(idSchedule)) {
				return scheduleDAO.deleteSchedule(idSchedule);
			}			
		}else {
			return scheduleDAO.deleteSchedule(idSchedule);
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
	public List<Schedule> getListScheduleAuto() {
		return scheduleDAO.getListScheduleAuto();
	}
	@Override
	public List<Schedule> getAllScheduleTotal() {
		return scheduleDAO.getAllScheduleTotal();
	}
	@Override
	public Schedule getScheduleById(long id) {
		return scheduleDAO.getScheduleById(id);
	}
}