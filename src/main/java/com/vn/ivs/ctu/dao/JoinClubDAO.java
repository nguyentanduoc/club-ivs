package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.JoinClub;


public interface JoinClubDAO {
	
	public List<JoinClub> getJoinClubByClub(int idClub);
	public long createOrUpdate(JoinClub joinClub);
	public List<JoinClub> getJoinClubByIdMember(long idMember);
	public JoinClub getJoinClub(long idJoinClub);
	public List<JoinClub> getListMemberActive(int idClub);
}
