package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.DateOfWeek;


public interface DowDAO {
	public long create(DateOfWeek dow);
	public List<DateOfWeek> getAll();
	public boolean delete(int id);
}
