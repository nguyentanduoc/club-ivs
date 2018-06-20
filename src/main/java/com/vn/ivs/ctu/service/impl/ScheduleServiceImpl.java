package com.vn.ivs.ctu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.vn.ivs.ctu.dao.impl.ScheduleDAOImpl;
import com.vn.ivs.ctu.entity.Schedule;

import com.vn.ivs.ctu.service.ScheduleService;

@Service
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ScheduleServiceImpl implements ScheduleService{

	@Autowired
	ScheduleDAOImpl scheduleDAOImpl;
	public long create(Schedule schedule) {
		return scheduleDAOImpl.create(schedule);		
	}
	
	public boolean deleteSchedule(int id) {
		return scheduleDAOImpl.deleteSchedule(id);
	}
	public List<Schedule> getAll() {
		return scheduleDAOImpl.getAll();
	}
	
	
}