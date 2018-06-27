package com.vn.ivs.ctu.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.vn.ivs.ctu.dao.ClubDAO;
import com.vn.ivs.ctu.entity.Branch;
import com.vn.ivs.ctu.entity.Club;

@Repository("clubDAOImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ClubDAOImpl implements ClubDAO{

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public int saveOrUpdate(Club club) {
		currentSession().saveOrUpdate(club);
		return club.getIdClub();
	}

	@Override
	public List<Club> getAll() {
		 return (List<Club>)currentSession().createQuery("from club", Club.class).list();		
	}
	@Override
	public List<Club> getClubByBrach(int idBranch){
		try {
			return currentSession().createQuery("from club c where c.branch.idBranch = ?",Club.class).setParameter(0, idBranch).getResultList();
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public Club getClubByLeader(int idLeader) {
		try {
			return currentSession().createQuery("from club c where c.member.idMember = ?",Club.class).setParameter(0, idLeader).getSingleResult();
		}catch(Exception e) {
			return null;
		}
		
	}
	
}
