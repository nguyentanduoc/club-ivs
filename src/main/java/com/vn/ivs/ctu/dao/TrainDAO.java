package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.Train;

public interface TrainDAO {
	
	public long create(Train train);
	public List<Train> getAll();
	public boolean deleteTrain(int idTrain);
	public List<Train> getAllTrainAuto(int idClub);
	public List<Train> getAllTrainManual(int idClub);
	public List<Train> getAllTrain();
	public List<Train> getAllTrainAuto();
	public List<Train> getAllTrainOnWeek();
	public List<Train> getListAllTrainOnWeek(int idClub);
	public List<Train> getListTrainByIdSchedule(int idSchedule);
	public int totalTrainInMonth(int month,int curentYear, int idClub);
	public List<Train> getAllTrainByClub(int month, int year, int idClub);
}
