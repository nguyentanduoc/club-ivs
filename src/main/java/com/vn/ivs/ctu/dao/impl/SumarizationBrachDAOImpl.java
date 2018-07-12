package com.vn.ivs.ctu.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.vn.ivs.ctu.dao.SumarizationBrachDAO;
import com.vn.ivs.ctu.entity.SumarizationBranch;

@Repository("sumarizationBranchDAOImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class SumarizationBrachDAOImpl implements SumarizationBrachDAO{

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}	
	
	@Override
	public long saveOrUpdate(SumarizationBranch sumBranch) {
		try {
			currentSession().saveOrUpdate(sumBranch);
			return sumBranch.getIdSumBranch();
		}catch(Exception e) {
			System.out.println(e.toString());
			return 0;
		}
	}

	@Override
	public SumarizationBranch getById(long id) {
		try {
			return currentSession().load(SumarizationBranch.class, id);
		}catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	@Override
	public List<SumarizationBranch> getSumByBranch(int idBranch, int month, int year) {
		try {
			return currentSession().createQuery("from summarization_branch s where s.branch.idBranch=:idBranch and s.year=:year and s.month=:month",SumarizationBranch.class)
					.setParameter("idBranch", idBranch).setParameter("year", year).setParameter("month", month).list();
		}catch(Exception e) {
			System.out.println(e.toString());
			return  null;
		}
	}

	@Override
	public List<SumarizationBranch> getComfirmDonate(int idBranch, int month, int year) {
		try {
			return currentSession().createQuery("from summarization_branch s where s.branch.idBranch=:idBranch and s.year=:year and s.month=:month and s.donate=:donate",SumarizationBranch.class)
					.setParameter("idBranch", idBranch).setParameter("year", year).setParameter("month", month).setParameter("donate", true).list();
		}catch(Exception e) {
			System.out.println(e.toString());
			return  null;
		}
	}
	@Override
	public List<SumarizationBranch> getSumByMember(long idMember, int month, int year){
		try {
			return currentSession().createQuery("from summarization_branch s where s.member.idMember=:idMember and s.year=:year and s.month=:month and s.donate=:donate",SumarizationBranch.class)
					.setParameter("idMember", idMember).setParameter("year", year).setParameter("month", month).setParameter("donate", true).list();
		}catch(Exception e) {
			System.out.println(e.toString());
			return  null;
		}
	}

}
