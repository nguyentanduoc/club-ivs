package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.Schedule;

public interface ScheduleDAO {
	public long create(Schedule schedule);
	public List<Schedule> getAll(int idClub);
	public boolean deleteSchedule(long idSchedule);
	public List<Schedule> getListScheduleAuto(int idClub);
	public List<Schedule> getListScheduleAuto();
	public List<Schedule> getAllScheduleTotal();
	public Schedule getScheduleById(long id);
}
