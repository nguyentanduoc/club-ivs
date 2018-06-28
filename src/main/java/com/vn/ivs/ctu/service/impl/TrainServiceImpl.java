package com.vn.ivs.ctu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.vn.ivs.ctu.dao.TrainDAO;
import com.vn.ivs.ctu.entity.Train;
import com.vn.ivs.ctu.service.TrainService;

@Service
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class TrainServiceImpl implements TrainService {
	
	@Autowired TrainDAO trainDAO;
	
	public long create(Train train) {
		return trainDAO.create(train);		
	}

	public List<Train> getAllTrainAuto() {
		return trainDAO.getAllTrainAuto();
	}
	public boolean deleteTrain(int id) {
		return trainDAO.deleteTrain(id);
	}

	@Override
	public List<Train> getAllTrain() {
		return trainDAO.getAllTrain();
	}

	@Override
	public List<Train> getListAllTrainOnWeek() {
		return trainDAO.getAllTrainOnWeek();
	}

	@Override
	public List<Train> getListAllTrainOnWeek(int idClub) {
		return trainDAO.getListAllTrainOnWeek(idClub);
	}

	@Override
	public int totalTrainInMonth(int month,int curentYear, int idClub) {
		return trainDAO.totalTrainInMonth(month,curentYear,idClub);
	}

	@Override
	public List<Train> getAllTrainByClub(int month, int year, int idClub) {
		return trainDAO.getAllTrainByClub(month, year, idClub);
	}	
}
