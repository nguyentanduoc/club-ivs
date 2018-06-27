package com.vn.ivs.ctu.service;

import java.util.List;

import com.vn.ivs.ctu.entity.Club;

public interface ClubService {
	public int saveOrUpdate(Club club);
	public List<Club> getAll();
	public List<Club> getClubByBranch(int idBranch);
	public Club getLeaderClub(int idLeader);
}
