package com.vn.ivs.ctu.service;

import java.util.List;

import com.vn.ivs.ctu.entity.JoinClub;

public interface JoinClubService {
	
	public List<JoinClub> getJoinClubByClub(int idClub);
	public long createOrUpdate(JoinClub joinClub);
	public List<JoinClub> getJoinClubByIdMember(long idMember);
	public JoinClub getJoinClub(long idJoinClub);
	public List<JoinClub> getListMemberActive(int idClub);
	public boolean delete(long idJoin);
}
