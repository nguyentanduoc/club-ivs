package com.vn.ivs.ctu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.vn.ivs.ctu.dao.impl.RoleDAOImpl;
import com.vn.ivs.ctu.dao.impl.TrainDAOImpl;
import com.vn.ivs.ctu.entity.Role;
import com.vn.ivs.ctu.entity.Train;
import com.vn.ivs.ctu.service.TrainService;

@Service
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class TrainServiceImpl implements TrainService {
	
	@Autowired
	TrainDAOImpl trainDAOImpl;
	public long create(Train train) {
		return trainDAOImpl.create(train);		
	}

	public List<Train> getAllTrainAuto() {
		return trainDAOImpl.getAllTrainAuto();
	}
	public boolean deleteTrain(int id) {
		return trainDAOImpl.deleteTrain(id);
	}

	@Override
	public List<Train> getAllTrain() {
		return trainDAOImpl.getAllTrain();
	}

	@Override
	public List<Train> getListAllTrainOnWeek() {
		return trainDAOImpl.getAllTrainOnWeek();
	}

	

	
}
