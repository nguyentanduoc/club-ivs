package com.vn.ivs.ctu.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.vn.ivs.ctu.dao.ScheduleDAO;
import com.vn.ivs.ctu.entity.Schedule;



@Repository("scheduleDAOImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ScheduleDAOImpl implements ScheduleDAO {

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}	

	public long create(Schedule schedule) {
		currentSession().saveOrUpdate(schedule);
		return schedule.getIdSchedule();
	}

	public boolean deleteSchedule(int idSchedule) {
		try {
			Schedule loadSchedule = currentSession().load(Schedule.class,idSchedule);
			currentSession().delete(loadSchedule);
			return true;
		}	catch(Exception ex) {
			System.out.println("deleteSchedule-"+ ex.toString());
			return false;
		}	
	}
	
	@Transactional
	public List<Schedule> getAll(int idClub) {
		return currentSession().createQuery("from schedule s where s.club.idClub=?",Schedule.class).setParameter(0, idClub).list();
	}
	@Override
	public List<Schedule> getListScheduleAuto(int idClub) {
		try {
			return currentSession().createQuery("from schedule s where s.autoSchedule=? and s.club.idClub=?",Schedule.class).setParameter(0, true).setParameter(1, idClub).list();
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public List<Schedule> getListScheduleAuto() {
		try {
			return currentSession().createQuery("from schedule s where s.autoSchedule=?",Schedule.class).setParameter(0, true).list();
		} catch (Exception e) {
			return null;
		}
	}
	public List<Schedule> getAllScheduleTotal() {
//		Calendar cal = Calendar.getInstance();
//		int week = cal.get(Calendar.WEEK_OF_YEAR);
		try {
		return currentSession().createQuery("from schedule", Schedule.class).list();
		}catch (Exception e) {
			return null;
		}
	}
	public Schedule getScheduleById(int id) {
		try {
		return currentSession().load(Schedule.class,id);
		}catch (Exception ex) {
			return null;
		}
	}
}

