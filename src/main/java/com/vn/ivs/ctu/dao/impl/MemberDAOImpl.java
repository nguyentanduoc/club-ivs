
package com.vn.ivs.ctu.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.vn.ivs.ctu.dao.MemberDAO;
import com.vn.ivs.ctu.entity.Member;

@Repository()
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional()
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public boolean check(String name) {
		Query q = currentSession().createQuery("from member m where m.userNameMember =:userName");

		try {
			q.setParameter("userName", name);
			if (q.getSingleResult() != null) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}
	

	public int saveOrUpdate(Member member) {
		currentSession().saveOrUpdate(member);
		return member.getIdMember();
	}

	public Member findByUseName(String name) {

		try {
			List<Member> list  = currentSession().createQuery("from member where userNameMember = ?",Member.class).setParameter(0, name)
					.list();
			if(list.size()>0) {
				return list.get(0);
			}else return null;
		} catch (Exception e) {
			return null;
		}
	}

	public List<Member> findAll() {
		List<Member>  list = (List<Member>)currentSession().createQuery("from member", Member.class).list();		
		return list;
	}

}
