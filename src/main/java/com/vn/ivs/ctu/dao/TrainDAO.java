package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.Train;



public interface TrainDAO {
	
	public long create(Train train);
	public List<Train> getAllTrain();
	public boolean deleteTrain(int id);
	public List<Train> getAllTrainAuto();
	public List<Train> getAllTrainOnWeek();
	public List<Train> getListAllTrainOnWeek(int idClub);
}
