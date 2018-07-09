package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.Attendance;

public interface AttendanceDAO {
	
	public boolean createOrUpdate(Attendance attendance);
	public List<Attendance> getAttendanceByTrain(long id);
	public boolean deleteAttendanceByTrain(long idTrain);
	public List<Attendance> getAttendanceByClub(int curentMonth, int idClub);
	public Attendance getAttendByIdMember(long idMember, long idTrain);

}
