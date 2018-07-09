package com.vn.ivs.ctu.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.vn.ivs.ctu.dao.RoleDAO;
import com.vn.ivs.ctu.entity.Role;

@Repository("roleDAOImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public long createOrUpdate(Role role) {
		currentSession().saveOrUpdate(role);		
		return role.getIdRole();
	}
	
	public List<Role> getAll() {		
		return currentSession().createQuery("from role",Role.class).list();
	}

	public boolean deleteRole(int id) {
		try {
			Role loadRole = getRoleById(id) ;
			currentSession().delete(loadRole);
			return true;
		}	catch(Exception ex) {
			System.out.println("deleteRole-"+ ex.toString());
			return false;
		}	
	}

	public Role getRoleById(int id) {		
		Role role = currentSession().load(Role.class,id);
		return role;		
	}
	
	public List<Role> getOfLeader(){
		try {
			return currentSession().createQuery("select r from role r where r.codeRole not in('ADMIN','LEADER')",Role.class).list();
		}catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	@Override
	public Role getRoleByCode(String code) {
		try {
			return currentSession().createQuery("select r from role r where r.codeRole=:code",Role.class).setParameter("code", code).getSingleResult();
		}catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	} 
}
