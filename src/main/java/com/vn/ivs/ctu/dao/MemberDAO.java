package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.JoinClub;
import com.vn.ivs.ctu.entity.Member;


public interface MemberDAO {	
	
	public 	boolean			check(String name);
	public 	int 			saveOrUpdate(Member member);
	public 	Member			findByUseName(String name);
	public 	List<Member> 	findAll(int startPosition);
	public 	List<Member> 	getAllRoleOTC();
	public	List<Member> 	getAllByBranch(int idBranch);
	public	List<Member> 	getAllByBranch(int idBranch,int startPosition);
	public 	List<Member> 	getMemberNoClub();
	public 	boolean 		joinClub(JoinClub joinClub);
	public 	Member			getMemberById(int idMember);	
	public 	List<Member>	getAllLeaderClub();
	public long count();
	public boolean delete(int idMember);
}
