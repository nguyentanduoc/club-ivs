package com.vn.ivs.ctu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.vn.ivs.ctu.dao.RoleDAO;
import com.vn.ivs.ctu.entity.Role;
import com.vn.ivs.ctu.service.RoleService;

@Service
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleDAO roleDAO;
	
	public long createOrUpdate(Role role) {
		return roleDAO.createOrUpdate(role);		
	}

	public List<Role> getAll() {
		return roleDAO.getAll();
	}
	public boolean deleteRole(int id) {
		return roleDAO.deleteRole(id);
	}

	public Role getRoleById(int id) {
		return roleDAO.getRoleById(id);
	}

	@Override
	public List<Role> getOfLeader() {
		return roleDAO.getOfLeader();
	}

	@Override
	public Role getRoleByCode(String code) {
		return roleDAO.getRoleByCode(code);
	}
	
}
