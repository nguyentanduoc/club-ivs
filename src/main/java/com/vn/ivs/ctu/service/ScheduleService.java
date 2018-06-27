package com.vn.ivs.ctu.service;

import java.util.List;

import com.vn.ivs.ctu.entity.Schedule;

public interface ScheduleService {
	public long create(Schedule schedule);
	public List<Schedule> getAll();
	public boolean deleteSchedule(int id);
	public List<Schedule> getListScheduleAuto();
}
