package com.vn.ivs.ctu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.vn.ivs.ctu.dao.SumarizationDAO;
import com.vn.ivs.ctu.entity.Summarization;
import com.vn.ivs.ctu.service.SumarizationService;

@Service
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SumarizationServiceImpl implements SumarizationService{

	@Autowired SumarizationDAO sumarizationDAO;
	
	@Override
	public int createOrUpdate(Summarization sum) {
		return sumarizationDAO.createOrUpdate(sum);
	}

	@Override
	public List<Summarization> getSumByClubPreMonth(int idClub, int month,int year) {
		return sumarizationDAO.getSumByClubPreMonth(idClub, month,year);
	}

	@Override
	public List<Summarization> getSumByMemberPreMonth(int idMember, int month, int year) {
		return sumarizationDAO.getSumByMemberPreMonth(idMember, month, year);
	}

	@Override
	public Summarization getSumById(int id) {
		return sumarizationDAO.getSumById(id);
	}

	@Override
	public List<Summarization> getSumByMember(int idMember, int month, int year) {
		return sumarizationDAO.getSumByMember(idMember, month, year);
	}
	
	
}
