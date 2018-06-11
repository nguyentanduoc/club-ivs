package com.vn.ivs.ctu.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.vn.ivs.ctu.dao.RoleDAO;
import com.vn.ivs.ctu.entity.Role;

@Repository("roleDAOImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public long create(Role role) {
		currentSession().save(role);
		return role.getIdRole();
	}
	
	@Transactional
	public List<Role> getAll() {		
		
		return currentSession().createQuery("from role").list();
	}

	@Transactional
	public boolean deleteRole(int id) {
		try {
			Role loadRole = currentSession().load(Role.class,id) ;
			currentSession().delete(loadRole);
			return true;
		}	catch(Exception ex) {
			System.out.println("deleteRole-"+ ex.toString());
			return false;
		}	
	}

}
