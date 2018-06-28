package com.vn.ivs.ctu.service;

import java.util.List;

import com.vn.ivs.ctu.entity.Summarization;

public interface SumarizationService {
	
	public int createOrUpdate(Summarization sum);
	public List<Summarization> getSumByClubPreMonth(int idClub, int month,int year);
}
