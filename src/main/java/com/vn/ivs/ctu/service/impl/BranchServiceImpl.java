package com.vn.ivs.ctu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import com.vn.ivs.ctu.dao.BranchDAO;
import com.vn.ivs.ctu.entity.Branch;
import com.vn.ivs.ctu.service.BranchService;

@Service
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class BranchServiceImpl implements BranchService{
	
	@Autowired
	BranchDAO branchDAO;

	public int saveOrUpdate(Branch branch) {		
		return branchDAO.saveOrUpdate(branch);
	}

	public Branch findById(int id) {		
		return branchDAO.findById(id);
	}

	public boolean delete(int id) {		
		return branchDAO.delete(id);
	}

	public List<Branch> getAll() {
		
		return branchDAO.getAll();
	}
	
	public Branch getBranchByMember(long idMember) {
		return branchDAO.getBranchByMember(idMember);
	}

	@Override
	public Branch getBranchById(int id) {
		return branchDAO.getBranchById(id);
	}
}
