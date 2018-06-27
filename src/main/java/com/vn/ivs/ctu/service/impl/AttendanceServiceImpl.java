package com.vn.ivs.ctu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.ivs.ctu.dao.AttendanceDAO;
import com.vn.ivs.ctu.entity.Attendance;
import com.vn.ivs.ctu.entity.AttendanceID;
import com.vn.ivs.ctu.entity.Train;
import com.vn.ivs.ctu.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService{

	@Autowired AttendanceDAO attendanceDAO;
	@Override
	public boolean createOrUpdate(Attendance attendance) {
		return attendanceDAO.createOrUpdate(attendance);
	}
//	@Override
//	public List<Attendance> getAllAttendance() {
//		return attendanceDAO.getAllAttendance();
//	}

}
