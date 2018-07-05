package com.vn.ivs.ctu.service;

import java.util.List;

import com.vn.ivs.ctu.entity.Train;

public interface TrainService {
	
	public long create(Train train);
	public List<Train> getAllTrainAuto(int idClub);
	public List<Train> getAllTrainManual(int idClub);
	public boolean deleteTrain(int idTrain);
	public List<Train> getAll();
	public List<Train> getListAllTrainOnWeek(int idClub);
	public boolean deleteTrainByIdSchedule(int idSchedule);
	public List<Train> getListTrainByIdSchedule(int idTrain);
	public int totalTrainInMonth(int month, int curentYear,int idClub);
	public List<Train> getAllTrainByClub(int month, int year, int idClub);
	public Train getTrainById(int id);
	public List<Train> getTrainBySchedule(int idSchedule);
}
