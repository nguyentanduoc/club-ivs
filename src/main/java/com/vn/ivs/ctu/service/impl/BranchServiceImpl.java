package com.vn.ivs.ctu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.vn.ivs.ctu.dao.impl.BranchDAOImpl;
import com.vn.ivs.ctu.dao.impl.RoleDAOImpl;
import com.vn.ivs.ctu.entity.Branch;
import com.vn.ivs.ctu.service.BranchService;

@Service
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class BranchServiceImpl implements BranchService{
	
	@Autowired
	BranchDAOImpl branchDAOImpl;

	public int saveOrUpdate(Branch branch) {		
		return branchDAOImpl.saveOrUpdate(branch);
	}

	public Branch findById(int id) {		
		return branchDAOImpl.findById(id);
	}

	public boolean delete(int id) {		
		return branchDAOImpl.delete(id);
	}

	public List<Branch> getAll() {
		
		return branchDAOImpl.getAll();
	}
	
	public Branch getBranchByMember(int idMember) {
		return branchDAOImpl.getBranchByMember(idMember);
	}
}
