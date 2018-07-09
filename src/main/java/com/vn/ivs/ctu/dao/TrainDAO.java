package com.vn.ivs.ctu.dao;

import java.util.List;

import com.vn.ivs.ctu.entity.Train;

public interface TrainDAO {
	
	public long create(Train train);
	public List<Train> getAll();
	public boolean deleteTrain(long idTrain);
	public List<Train> getAllTrainAuto(int idClub);
	public List<Train> getAllTrainManual(int idClub);
	public List<Train> getListAllTrainOnWeek(int idClub);
	public List<Train> getListTrainByIdSchedule(long idSchedule);
	public int totalTrainInMonth(int month,int curentYear, int idClub);
	public List<Train> getAllTrainByClub(int month, int year, int idClub);
	public Train getTrainById(long id);
	public List<Train> getTrainBySchedule(long idSchedule);
}
