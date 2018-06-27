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

	public List<Schedule> getAllAuto() {	
		try {
			return currentSession().createQuery("from schedule where autoSchedule=?",Schedule.class).setParameter(0, true).list();
		}catch (Exception e) {
			return null;
		}
	}
	
	@Transactional
	public List<Schedule> getAll() {	
		
		return currentSession().createQuery("from schedule",Schedule.class).list();

	}

	public boolean deleteSchedule(int id) {
		try {
			Schedule loadSchedule = currentSession().load(Schedule.class,id);
			currentSession().delete(loadSchedule);
			return true;
		}	catch(Exception ex) {
			System.out.println("deleteSchedule-"+ ex.toString());
			return false;
		}	
	}

	@Override
	public List<Schedule> getListScheduleAuto() {
		try {
			return currentSession().createQuery("from schedule where autoSchedule=?",Schedule.class).setParameter(0, true).list();
		} catch (Exception e) {
			return null;
		}
	}
}
