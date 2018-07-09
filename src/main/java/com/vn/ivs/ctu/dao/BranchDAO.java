package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.Branch;

public interface BranchDAO {
	
	public int saveOrUpdate(Branch branch);
	public Branch findById(int id);
	public boolean delete(int id);
	public List<Branch> getAll();
	public Branch getBranchByMember(long idMember);
	public Branch getBranchById(int id);
}
