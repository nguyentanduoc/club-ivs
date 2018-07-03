package com.vn.ivs.ctu.service;

import java.util.List;

import com.vn.ivs.ctu.entity.Attendance;

public interface AttendanceService {
	
	public boolean createOrUpdate(Attendance attendance);
	public List<Attendance> getAttendanceByTrain(int id);
	public boolean deleteAttendanceByTrain (int idTrain);
	public List<Attendance> getAttendanceByClub(int curentMonth,int idClub);
	public Attendance getAttendByIdMember(int idMember, int idTrain);

}
