package com.vn.ivs.ctu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.vn.ivs.ctu.dao.ClubDAO;
import com.vn.ivs.ctu.entity.Club;
import com.vn.ivs.ctu.entity.JoinClub;
import com.vn.ivs.ctu.service.ClubService;

@Service
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ClubServiceImpl implements ClubService{

	@Autowired ClubDAO clubDAO;
	@Autowired JoinClubServiceImpl joinClubServiceImpl;
	
	@Override
	public int saveOrUpdate(Club club) {
		return clubDAO.saveOrUpdate(club);	
	}

	@Override
	public List<Club> getAll() {
		return clubDAO.getAll();
	}
	
	@Override
	public List<Club> getClubByBranch(int idBranch){
		return clubDAO.getClubByBrach(idBranch);
	}

	@Override
	public Club getLeaderClub(long idLeader) {
		return clubDAO.getClubByLeader(idLeader);
	}		
	@Override
	public Club getClubById(int id) {
		return clubDAO.getClubById(id);
	}
	@Override
	public boolean deleteClub(int id) {
		List<JoinClub> jl = joinClubServiceImpl.getJoinClubByClub(id);
		if(jl!=null) {
			for(JoinClub j:jl) {
				joinClubServiceImpl.delete(j.getIdJoinClub());
			}
		}
		return clubDAO.deleteClub(id);
	}
}
