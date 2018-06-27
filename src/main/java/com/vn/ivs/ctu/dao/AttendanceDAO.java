package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.Attendance;

public interface AttendanceDAO {
	
	public boolean createOrUpdate(Attendance attendance);

	//public List<Attendance> getAllAttendance();
}
