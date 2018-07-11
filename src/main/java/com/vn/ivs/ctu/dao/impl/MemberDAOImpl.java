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
	

	public long saveOrUpdate(Member member) {
		currentSession().saveOrUpdate(member);
		return member.getIdMember();
	}

	public Member findByUseName(String name) {
		try {
			List<Member> list  = currentSession().createQuery("from member where userNameMember =:userNameMember and status=:statusMember",Member.class).
					setParameter("userNameMember", name).setParameter("statusMember", true)
					.list();
			if(list.size()>0) {
				return list.get(0);
			}else return null;
		} catch (Exception e) {
			return null;
		}
	}

	public List<Member> findAll(int startPosition,int maxResult) {
		try {
			List<Member>  list = (List<Member>)currentSession().createQuery("from member", Member.class).setFirstResult(startPosition).setMaxResults(maxResult).list();		
			return list;
		}catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
		
	}

	public List<Member> getAllByBranch(int idBranch) {
		try {
			List<Member> members = currentSession().
					createQuery("SELECT m FROM member m JOIN m.branch b  WHERE b.idBranch = :idBranch",Member.class).
					setParameter("idBranch", idBranch).list();
			if (members != null) {
				return members;
			}
		}
		catch (Exception e) {
			return null;
		}
		return null;
	}
	public List<Member> getAllByBranch(int idBranch,int startPosition, int maxResult) {
		try {
			List<Member> members = currentSession().
					createQuery("SELECT m FROM member m JOIN m.branch b  WHERE b.idBranch =:idBranch",Member.class).setFirstResult(startPosition).setMaxResults(maxResult).
					setParameter("idBranch", idBranch).list();			
			if (members != null) {
				return members;
			}			
		}
		catch (Exception e) {
			return null;
		}
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
	public 	Member getMemberById(long idMember) {
		return currentSession().find(Member.class, idMember);
	}
	
	public List<Member> getAllLeaderClub(){
		try {
			return currentSession().createQuery("Select m from member m JOIN m.roles r  WHERE r.codeRole =:codeRole and m.status=:status",Member.class).
					setParameter("codeRole", "LEADER_CLUB").setParameter("status", true).list();
		}catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	@Override
	public long count() {
		try {
			return (long)currentSession().createQuery("from member", Member.class).list().size();
			
		}	catch (Exception e) {
			System.out.println(e.toString());
			return 0;
		}	
	}

	@Override
	public boolean delete(long idMember) {
		try {
			Member member = getMemberById(idMember);
			currentSession().delete(member);
			return true;
		}	catch(Exception ex) {
			System.out.println("deleteMember-"+ ex.toString());
			return false;
		}	
	}
	
	@Override
	public List<Member> getAllLeaderClubByBranch(int idBranch){
		try {
			return currentSession().createQuery("Select m from member m JOIN m.roles r  WHERE r.codeRole =:codeRole and m.branch.idBranch =:idBranch and m.status=:status",Member.class).setParameter("codeRole", "LEADER_CLUB").setParameter("idBranch", idBranch).setParameter("status", true).list();
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<Member> getAllLeader() {
		try {
			return currentSession().createQuery("Select m from member m JOIN m.roles r  WHERE r.codeRole =:codeRole and m.status=:status",Member.class).setParameter("codeRole", "LEADER").setParameter("status", true).list();
		}catch(Exception e) {
			return null;
		}
	}

}
