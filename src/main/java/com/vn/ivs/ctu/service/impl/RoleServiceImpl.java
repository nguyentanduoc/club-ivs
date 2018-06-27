package com.vn.ivs.ctu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.vn.ivs.ctu.dao.impl.RoleDAOImpl;
import com.vn.ivs.ctu.entity.Role;
import com.vn.ivs.ctu.service.RoleService;

@Service
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleDAOImpl roleDAOImpl;
	public long createOrUpdate(Role role) {
		return roleDAOImpl.createOrUpdate(role);		
	}

	public List<Role> getAll() {
		return roleDAOImpl.getAll();
	}
	public boolean deleteRole(int id) {
		return roleDAOImpl.deleteRole(id);
	}

	public Role getRoleById(int id) {
		return roleDAOImpl.getRoleById(id);
	}
	
}
