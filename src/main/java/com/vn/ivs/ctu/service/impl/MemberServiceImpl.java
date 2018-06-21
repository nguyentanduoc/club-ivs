package com.vn.ivs.ctu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.vn.ivs.ctu.dao.impl.MemberDAOImpl;
import com.vn.ivs.ctu.entity.Member;
import com.vn.ivs.ctu.service.MemberService;

@Service
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDAOImpl memberDAOImpl;	
	
	public boolean check(String name) {
		return memberDAOImpl.check(name);
	}
	@Override
	public int saveOrUpdate(Member member) {
		return memberDAOImpl.saveOrUpdate(member);
	}
	
	public Member findByUseName(String name) {
		return memberDAOImpl.findByUseName(name);
	}
	@Override
	public List<Member> findAll() {
		return memberDAOImpl.findAll();
	}
}
