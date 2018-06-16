package com.vn.ivs.ctu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.vn.ivs.ctu.dao.impl.DowDAOImpl;

import com.vn.ivs.ctu.entity.DateOfWeek;

import com.vn.ivs.ctu.service.DowService;

@Service
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class DowServiceImpl implements DowService{

	@Autowired
	DowDAOImpl dowDAOImpl;
	public long create(DateOfWeek dow) {
		return dowDAOImpl.create(dow);		
	}

	public List<DateOfWeek> getAll() {
		return dowDAOImpl.getAll();
	}
	public boolean deleteDow(int id) {
		return dowDAOImpl.deleteDow(id);
	}

}
