package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.Role;

public interface RoleDAO {
	
	public long createOrUpdate(Role role);
	public List<Role> getAll();
	public boolean deleteRole(int id);
	public Role getRoleById(int id);
	public List<Role> getOfLeader();
	public Role getRoleByCode(String code);
}
