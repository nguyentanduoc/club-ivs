package com.vn.ivs.ctu.service;

import java.util.List;

import com.vn.ivs.ctu.entity.Member;

public interface MemberService {
	public boolean check(String name);
	public int saveOrUpdate(Member member);
	Member findByUseName(String name);
	public List<Member> findAll();
}
