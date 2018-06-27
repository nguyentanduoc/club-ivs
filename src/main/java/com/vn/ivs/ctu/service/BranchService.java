package com.vn.ivs.ctu.service;

import java.util.List;

import com.vn.ivs.ctu.entity.Branch;

public interface BranchService {
	public int saveOrUpdate(Branch branch);
	public Branch findById(int id);
	public boolean delete(int id);
	public List<Branch> getAll();
	public Branch getBranchByMember(int idMember);
	public Branch getBranchById(int id);

}
