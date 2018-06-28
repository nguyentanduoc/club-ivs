package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.Train;

public interface TrainDAO {
	
	public int create(Train train);
	public List<Train> getAllTrain();
	public boolean deleteTrain(int id);
	public List<Train> getAllTrainAuto();
	public List<Train> getAllTrainOnWeek();
	public List<Train> getListAllTrainOnWeek(int idClub);
	public int totalTrainInMonth(int month,int curentYear, int idClub);
	public List<Train> getAllTrainByClub(int month, int year, int idClub);
}
