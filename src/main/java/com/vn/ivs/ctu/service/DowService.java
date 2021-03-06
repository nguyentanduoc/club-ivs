package com.vn.ivs.ctu.service;

import java.util.List;

import com.vn.ivs.ctu.entity.DateOfWeek;


public interface DowService {
	public long create(DateOfWeek dow);
	public List<DateOfWeek> getAll();
	public boolean delete(int id);
	public DateOfWeek getByVariable(int variableDow);
}
