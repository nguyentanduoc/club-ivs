package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.Club;

public interface ClubDAO {
	
	public int saveOrUpdate(Club club);
	public List<Club> getAll();
	public List<Club> getClubByBrach(int idBranch);
	public Club getClubByLeader(long idMember);
	public Club getClubById(int id);
	public boolean deleteClub(int id);

}
