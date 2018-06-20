package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.Train;



public interface TrainDAO {
	
	public long create(Train train);
	public List<Train> getAll();
	//public boolean deleteTrain(int id);

}
