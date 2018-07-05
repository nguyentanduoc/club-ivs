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
	public int saveOrUpdate(SumarizationBranch sumBranch) {
		try {
			currentSession().saveOrUpdate(sumBranch);
			return sumBranch.getIdSumBranch();
		}catch(Exception e) {
			System.out.println(e.toString());
			return 0;
		}
	}

	@Override
	public SumarizationBranch getById(int id) {
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
			return currentSession().createQuery("from sumarization_branch s where s.branch.idBranch=? and s.year=? and s.month=?",SumarizationBranch.class)
					.setParameter(0, idBranch).setParameter(1, year).setParameter(2, month).list();
		}catch(Exception e) {
			System.out.println(e.toString());
			return  null;
		}
	}

}
