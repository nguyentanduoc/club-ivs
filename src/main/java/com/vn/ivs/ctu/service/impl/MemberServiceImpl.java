package com.vn.ivs.ctu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.vn.ivs.ctu.dao.MemberDAO;
import com.vn.ivs.ctu.entity.JoinClub;
import com.vn.ivs.ctu.entity.Member;
import com.vn.ivs.ctu.service.BranchService;
import com.vn.ivs.ctu.service.MemberService;

@Service
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDAO memberDAO;	
	
	@Autowired BranchService branchService;
	
	public boolean check(String name) {
		return memberDAO.check(name);
	}
	@Override
	public int saveOrUpdate(Member member) {
		return memberDAO.saveOrUpdate(member);
	}
	
	public Member findByUseName(String name) {
		return memberDAO.findByUseName(name);
	}
	@Override
	public List<Member> findAll(int startPosition) {
		return memberDAO.findAll(startPosition);
	}
	@Override
	public List<Member> getAllRoleOTC(){
		return memberDAO.getAllRoleOTC();
	}
	@Override
	public List<Member> getAllByBranch(int idBranch){
		return memberDAO.getAllByBranch(idBranch);
	}
	@Override
	public List<Member> getAllByBranch(int idBranch,int startPosition){
		return memberDAO.getAllByBranch(idBranch,startPosition);
	}
	@Override
	public List<Member> getMemberNoClub() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean joinClub(JoinClub joinClub) {
		return memberDAO.joinClub(joinClub);
	}
	public 	Member getMemberById(int idMember) {
		return memberDAO.getMemberById(idMember);
	}
	public List<Member> getAllLeaderClub(){
		return  memberDAO.getAllLeaderClub();		
	}
	@Override
	public long count() {
		return memberDAO.count();
	}
	@Override
	public boolean delete(int idMember) {
		return memberDAO.delete(idMember);
	}
}
