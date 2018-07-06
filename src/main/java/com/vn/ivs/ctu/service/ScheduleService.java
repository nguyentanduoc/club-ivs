package com.vn.ivs.ctu.service;

import java.util.List;

import com.vn.ivs.ctu.entity.Schedule;

public interface ScheduleService {
	public long create(Schedule schedule);
	public List<Schedule> getAll(int idClub);
	public boolean deleteSchedule(int idSchedule);
	public List<Schedule> getAllScheduleTotal();
	public List<Schedule> getListScheduleAuto(int idClub);
	public List<Schedule> getListScheduleAuto();
	public Schedule getScheduleById(int id);
}
