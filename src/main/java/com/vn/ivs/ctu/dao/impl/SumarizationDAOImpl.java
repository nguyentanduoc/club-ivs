package com.vn.ivs.ctu.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.vn.ivs.ctu.dao.SumarizationDAO;
import com.vn.ivs.ctu.entity.Summarization;

@Repository("sumarizationDAOImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class SumarizationDAOImpl implements SumarizationDAO{

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}	
	
	@Override
	public int createOrUpdate(Summarization sum) {
		try {
			currentSession().saveOrUpdate(sum);
			return sum.getIdSum();
		}catch (Exception e) {
			System.out.println(e.toString());
			return 0;
		}
		
	}

	@Override
	public List<Summarization> getSumByClubPreMonth(int idClub, int month,int year) {
		try {
			return currentSession().createQuery("from sumarization s where s.monthSum = ? and s.club.idClub =? and s.yearSum=?",Summarization.class).setParameter(0, month).setParameter(1, idClub).setParameter(2, year).list();
		}catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	@Override
	public List<Summarization> getSumByMemberPreMonth(int idMember, int month,int year){
		try {
			return currentSession().createQuery("from sumarization s where s.monthSum = ? and s.member.idMember =? and s.yearSum=?",Summarization.class).setParameter(0, month).setParameter(1, idMember).setParameter(2, year).list();
		}catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	@Override
	public Summarization getSumById(int id) {
		try {
			return currentSession().load(Summarization.class, id);
		}catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Summarization> getSumByMember(int idMember, int month, int year) {
		try {
			return currentSession().createQuery("from sumarization s where s.monthSum = ? and s.member.idMember =? and s.yearSum=?",Summarization.class).setParameter(0, month).setParameter(1, idMember).setParameter(2, year).list();
		}catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	
}
