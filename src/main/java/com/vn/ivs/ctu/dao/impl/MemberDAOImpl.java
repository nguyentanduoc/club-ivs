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
import com.vn.ivs.ctu.entity.JoinClub;
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

	@Override
	public List<Member> getAllRoleOTC() {
		try {
			List<Member> members = currentSession().
					createQuery("SELECT m FROM member m JOIN m.roles r  WHERE r.codeRole = ?",Member.class).
					setParameter(0, "LEADER").list();
			if (members != null) {
				return members;
			}
		}catch(Exception e) {
			return null;
		}
		return null;
	}

	public List<Member> getAllByBranch(int idBranch) {
		try {
			List<Member> members = currentSession().
					createQuery("SELECT m FROM member m JOIN m.branch b  WHERE b.idBranch = ?",Member.class).
					setParameter(0, idBranch).list();
			if (members != null) {
				return members;
			}
		}
		catch (Exception e) {
			return null;
		}
		return null;
	}
	public List<Member> getMemberNoClub(){
		/*try {
			List<Member> members = currentSession().
					createQuery("SELECT m FROM member m LEFT JOIN  = ?",Member.class).
					setParameter(0, idBranch).list();
			
		}catch(Exception e) {
			return null;
		}	*/
		 return null;
	}
	public boolean joinClub(JoinClub joinClub) {
		try {
			currentSession().saveOrUpdate(joinClub);
			return true;
		}catch(Exception e) {
			return false;
		}		
	}
	public 	Member getMemberById(int idMember) {
		return currentSession().find(Member.class, idMember);
	}
	
	public List<Member> getAllLeaderClub(){
		try {
			return currentSession().createQuery("Select m from member m JOIN m.roles r  WHERE r.codeRole = ?",Member.class).setParameter(0, "LEADER_CLUB").list();
		}catch(Exception e) {
			return null;
		}
	}
}
