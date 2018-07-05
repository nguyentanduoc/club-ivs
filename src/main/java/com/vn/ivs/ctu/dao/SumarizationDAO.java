package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.Summarization;

public interface SumarizationDAO {
	
	public int createOrUpdate(Summarization sum);
	public List<Summarization> getSumByClubPreMonth(int idClub,int month,int year);
	public List<Summarization> getSumByMemberPreMonth(int idMember, int month,int year);
	public Summarization getSumById(int id);
	public List<Summarization> getSumByMember(int idMember, int month, int year);
}
