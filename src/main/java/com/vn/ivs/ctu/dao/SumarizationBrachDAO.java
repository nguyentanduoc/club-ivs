package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.SumarizationBranch;

public interface SumarizationBrachDAO {
	
	public long saveOrUpdate(SumarizationBranch sumBranch);
	public SumarizationBranch getById(long id);
	public List<SumarizationBranch> getSumByBranch(int idBranch, int month, int year);
	public List<SumarizationBranch> getComfirmDonate(int idBranch, int month, int year);
	public List<SumarizationBranch> getSumByMember(long idMember, int month, int year);
}
