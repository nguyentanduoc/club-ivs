package com.vn.ivs.ctu.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.vn.ivs.ctu.dao.DowDAO;
import com.vn.ivs.ctu.entity.DateOfWeek;



@Repository("dowDAOImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DowDAOImpl implements DowDAO {

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public long create(DateOfWeek dow) {
		currentSession().save(dow);
		return dow.getIdDow();
	}
	
	@Transactional
	public List<DateOfWeek> getAll() {		
		
		return currentSession().createQuery("from date_of_week").list();
	}

	@Transactional
	public boolean deleteDow(int id) {
		try {
			DateOfWeek loadDow = currentSession().load(DateOfWeek.class,id) ;
			currentSession().delete(loadDow);
			return true;
		}	catch(Exception ex) {
			System.out.println("deleteDow-"+ ex.toString());
			return false;
		}	
	}

}
