package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.JoinClub;


public interface JoinClubDAO {
	
	public List<JoinClub> getJoinClubByClub(int idClub);
	public int createOrUpdate(JoinClub joinClub);
	public List<JoinClub> getJoinClubByIdMember(int idMember);

}
