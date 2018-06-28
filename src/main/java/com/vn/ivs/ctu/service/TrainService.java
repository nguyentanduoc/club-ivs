package com.vn.ivs.ctu.service;

import java.util.List;

import com.vn.ivs.ctu.entity.Train;

public interface TrainService {
	
	public long create(Train train);
	public List<Train> getAllTrainAuto();
	public boolean deleteTrain(int id);
	public List<Train> getAllTrain();
	public List<Train> getListAllTrainOnWeek();
	public List<Train> getListAllTrainOnWeek(int idClub);
	public int totalTrainInMonth(int month, int curentYear,int idClub);
	public List<Train> getAllTrainByClub(int month, int year, int idClub);
}
