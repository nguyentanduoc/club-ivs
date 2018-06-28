package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.Summarization;

public interface SumarizationDAO {
	
	public int createOrUpdate(Summarization sum);
	public List<Summarization> getSumByClubPreMonth(int idClub,int month,int year);
}
