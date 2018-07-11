package com.vn.ivs.ctu.service;

import java.util.List;

import com.vn.ivs.ctu.entity.JoinClub;
import com.vn.ivs.ctu.entity.Member;

public interface MemberService {
	public boolean check(String name);
	public long saveOrUpdate(Member member);
	public Member findByUseName(String name);
	public List<Member> findAll(int startPosition,int maxResult);
	public List<Member> getAllByBranch(int idBranch);
	public List<Member> getAllByBranch(int idBranch,int startPosition, int maxResult);
	public boolean joinClub(JoinClub joinClub);
	public Member getMemberById(long idMember);
	public List<Member> getAllLeaderClub();
	public long count();
	public boolean delete(long idMember);
	public List<Member> getAllLeaderClubByBranch(int idBranch);
	public List<Member> getAllLeader();
}
