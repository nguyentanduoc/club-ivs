package com.vn.ivs.ctu.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.vn.ivs.ctu.dao.BranchDAO;
import com.vn.ivs.ctu.entity.Branch;

@Repository("branchDAOImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class BranchDAOImpl  implements BranchDAO{

	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public int saveOrUpdate(Branch branch) {		
		currentSession().saveOrUpdate(branch);
		return branch.getIdBranch();
	}

	public Branch findById(int id) {		
		return currentSession().load(Branch.class, id);
	}

	public boolean delete(int id) {
		try {
			Branch branch = findById(id) ;
			currentSession().delete(branch);
			return true;
		}	catch(Exception ex) {
			System.out.println("deleteRole-"+ ex.toString());
			return false;
		}	
	}

	public List<Branch> getAll() {
		return currentSession().createQuery("from branch",Branch.class).list();
	}
	
	public Branch getBranchByMember(int idMember) {
		
		try {
			return currentSession().createQuery("from branch b where b.member.idMember=?",Branch.class).
					setParameter(0, idMember).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}
