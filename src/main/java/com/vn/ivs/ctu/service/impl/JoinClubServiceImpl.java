package com.vn.ivs.ctu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.ivs.ctu.dao.JoinClubDAO;
import com.vn.ivs.ctu.entity.JoinClub;
import com.vn.ivs.ctu.service.JoinClubService;

@Service
public class JoinClubServiceImpl implements JoinClubService{

	@Autowired JoinClubDAO joinClubDAO;
	
	@Override
	public List<JoinClub> getJoinClubByClub(int idClub) {
		
		return joinClubDAO.getJoinClubByClub(idClub);
	}

}