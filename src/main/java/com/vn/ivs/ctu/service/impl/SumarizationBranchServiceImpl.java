package com.vn.ivs.ctu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.vn.ivs.ctu.dao.SumarizationBrachDAO;
import com.vn.ivs.ctu.entity.SumarizationBranch;
import com.vn.ivs.ctu.service.SumarizationBranchService;

@Service
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SumarizationBranchServiceImpl implements SumarizationBranchService{

	@Autowired SumarizationBrachDAO sumarizationBrachDAO;
	
	@Override
	public long saveOrUpdate(SumarizationBranch sumBranch) {
		return sumarizationBrachDAO.saveOrUpdate(sumBranch);
	}

	@Override
	public SumarizationBranch getById(long id) {
		return sumarizationBrachDAO.getById(id);
	}

	@Override
	public List<SumarizationBranch> getSumByBranch(int idBranch, int month, int year) {
		return sumarizationBrachDAO.getSumByBranch(idBranch, month, year);
	}

}
