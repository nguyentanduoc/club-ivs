package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.Member;


public interface MemberDAO {	
	
	boolean check(String name);
	public int saveOrUpdate(Member member);
	public Member findByUseName(String name);
	public List<Member> findAll();
}
