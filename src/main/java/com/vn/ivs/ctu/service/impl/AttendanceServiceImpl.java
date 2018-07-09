package com.vn.ivs.ctu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.ivs.ctu.dao.AttendanceDAO;
import com.vn.ivs.ctu.entity.Attendance;
import com.vn.ivs.ctu.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService{

	@Autowired AttendanceDAO attendanceDAO;
	
	@Override
	public boolean createOrUpdate(Attendance attendance) {
		return attendanceDAO.createOrUpdate(attendance);
	}
	
	@Override
	public List<Attendance> getAttendanceByTrain(int id) {
		return attendanceDAO.getAttendanceByTrain(id);
	}
	
	@Override
	public boolean deleteAttendanceByTrain (int idTrain) {
		return attendanceDAO.deleteAttendanceByTrain(idTrain);
	}
	
	@Override
	public List<Attendance> getAttendanceByClub(int curentMonth,int idClub) {
		return attendanceDAO.getAttendanceByClub(curentMonth,idClub);
	}
	
	@Override
	public Attendance getAttendByIdMember(long idMember, int idTrain) {
		return attendanceDAO.getAttendByIdMember(idMember, idTrain);
	}
}
