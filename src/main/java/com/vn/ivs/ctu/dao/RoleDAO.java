package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.Role;

public interface RoleDAO {
	
	public long create(Role role);
	public List<Role> getAll();
	public boolean deleteRole(int id);
}
