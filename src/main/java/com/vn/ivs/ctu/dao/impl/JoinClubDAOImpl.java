package com.vn.ivs.ctu.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.vn.ivs.ctu.dao.JoinClubDAO;
import com.vn.ivs.ctu.entity.JoinClub;

@Repository("joinClubDAOImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class JoinClubDAOImpl implements JoinClubDAO{

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<JoinClub> getJoinClubByClub(int idClub) {
		try {

			return currentSession().
					createQuery("FROM join_club j WHERE j.club.idClub =:idClub and j.status =:statuss",JoinClub.class).
					setParameter("idClub", idClub).setParameter("status", true).list();	
		}catch(Exception ex) {
			System.out.println(ex.toString());
			return null;
		}	
	}

	@Override
	public long createOrUpdate(JoinClub joinClub) {
		try {
			currentSession().saveOrUpdate(joinClub);
			return joinClub.getIdJoinClub();
		}catch(Exception ex) {
			System.out.println("joinClubDAO " + ex.toString());
			return 0;
		}
	}

	@Override
	public List<JoinClub> getJoinClubByIdMember(long idMember) {
		try {
			return currentSession().
					createQuery("FROM join_club j WHERE j.member.idMember =:idMember",JoinClub.class).
					setParameter("idMember", idMember).list();	
		}catch(Exception e) {
			System.out.println("Join Club DAO "+e.toString());
			return null;
		}
	}

	@Override
	public JoinClub getJoinClub(long idJoinClub) {
		try {
			return currentSession().load(JoinClub.class, idJoinClub);
		}catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	@Override
	public List<JoinClub> getListMemberActive(int idClub) {
		try {
			return currentSession().
					createQuery("FROM join_club j WHERE j.club.idClub =:idClub and j.status=:status",JoinClub.class).
					setParameter("idClub", idClub).setParameter("status", true).list();	
		}catch(Exception e) {
			System.out.println("Join Club DAO "+e.toString());
			return null;
		}
	}
	
}
