package com.vn.ivs.ctu.service;

import java.util.List;

import com.vn.ivs.ctu.entity.JoinClub;
import com.vn.ivs.ctu.entity.Member;

public interface MemberService {
	public boolean check(String name);
	public int saveOrUpdate(Member member);
	public Member findByUseName(String name);
	public List<Member> findAll();
	public List<Member> getAllRoleOTC();
	public List<Member> getAllByBranch(int idBranch);
	public List<Member> getMemberNoClub();
	public boolean joinClub(JoinClub joinClub);
	public 	Member getMemberById(int idMember);
}
