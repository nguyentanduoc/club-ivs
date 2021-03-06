package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.Summarization;

public interface SumarizationDAO {
	
	public long createOrUpdate(Summarization sum);
	public List<Summarization> getSumByClubPreMonth(int idClub,int month,int year);
	public List<Summarization> getSumByMemberPreMonth(long idMember, int month,int year);
	public Summarization getSumById(long id);
	public List<Summarization> getSumByMember(long idMember, int month, int year);
}
