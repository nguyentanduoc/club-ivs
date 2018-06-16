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
import com.vn.ivs.ctu.entity.Role;
import com.vn.ivs.ctu.entity.Schedule;



@Repository("scheduleDAOImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ScheduleDAOImpl implements ScheduleDAO {

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public long create(Schedule schedule) {
		currentSession().saveOrUpdate(schedule);
		return schedule.getIdSchedule();
	}
	
	@Transactional
	public List<Schedule> getAll() {	
		
		return currentSession().createQuery("from schedule").list();
	}
	@Transactional
	public long delete(Schedule schedule) {
		currentSession().delete(schedule);
		return schedule.getIdSchedule();
	}
}
