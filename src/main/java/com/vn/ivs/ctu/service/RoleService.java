package com.vn.ivs.ctu.service;

import java.util.List;

import com.vn.ivs.ctu.entity.Role;

public interface RoleService {
	public long create(Role role);
	public List<Role> getAll();
	public boolean deleteRole(int id);
}
