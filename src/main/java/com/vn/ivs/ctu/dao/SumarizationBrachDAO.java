package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.SumarizationBranch;

public interface SumarizationBrachDAO {
	
	public int saveOrUpdate(SumarizationBranch sumBranch);
	public SumarizationBranch getById(int id);
	public List<SumarizationBranch> getSumByBranch(int idBranch, int month, int year);
}
