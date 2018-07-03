package com.vn.ivs.ctu.service;

import java.util.List;

import com.vn.ivs.ctu.entity.Schedule;
import com.vn.ivs.ctu.entity.Train;

public interface ScheduleService {
	public long create(Schedule schedule);
	public List<Schedule> getAll(int idClub);
	public boolean deleteSchedule(int id);
	public List<Schedule> getAllScheduleTotal();
	public List<Schedule> getListScheduleAuto(int idClub);
}
