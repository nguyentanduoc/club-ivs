package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.Schedule;

public interface ScheduleDAO {
	public long create(Schedule schedule);
	public List<Schedule> getAll();
	public boolean deleteSchedule(int id);
}
