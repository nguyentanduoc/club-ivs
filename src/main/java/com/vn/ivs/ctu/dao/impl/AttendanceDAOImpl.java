package com.vn.ivs.ctu.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.vn.ivs.ctu.dao.AttendanceDAO;
import com.vn.ivs.ctu.entity.Attendance;

@Repository()
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class AttendanceDAOImpl implements AttendanceDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public boolean createOrUpdate(Attendance attendance) {
		try {			
			currentSession().saveOrUpdate(attendance);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
	@Override
	public boolean deleteAttendanceByTrain(long idTrain) {
		try {
			List<Attendance> ats = getAttendanceByTrain(idTrain);
			for (Attendance a : ats) {
				currentSession().delete(a);
				
			}
			return true;
		} catch (Exception ex) {
			System.out.println(ex.toString());
			return false;
		}
	}
	@Override
	public List<Attendance> getAttendanceByTrain(long id) {
		try {
			return currentSession().createQuery("from attendance a where a.attendanceID.idTrain=?", Attendance.class).setParameter(0, id).list();
		}
		catch (Exception ex)
		{
			System.out.println(ex.toString());
			return null;
		}
	}
	public List<Attendance> getAttendanceByClub(int curentMonth,int idClub) {
		try {
			//currentSession().createQuery("from attendance a where  a.train")
			return null;
			
		}catch(Exception ex) {
			System.out.println(ex.toString());
			return null;
		}
	}
	@Override
	public Attendance getAttendByIdMember(long idMember, long idTrain) {
		try {
			return currentSession().createQuery("from attendance a where a.train.idTrain=? and a.member.idMember=?", Attendance.class).setParameter(0, idTrain).setParameter(1, idMember).getSingleResult();
		
		}catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

}
