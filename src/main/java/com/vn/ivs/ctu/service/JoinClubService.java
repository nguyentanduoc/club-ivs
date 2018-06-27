package com.vn.ivs.ctu.service;

import java.util.List;

import com.vn.ivs.ctu.entity.JoinClub;

public interface JoinClubService {
	
	public List<JoinClub> getJoinClubByClub(int idClub);
	public int createOrUpdate(JoinClub joinClub);
	public List<JoinClub> getJoinClubByIdMember(int idMember);
}
