package com.vn.ivs.ctu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.vn.ivs.ctu.dao.impl.TrainDAOImpl;

import com.vn.ivs.ctu.entity.Train;

@Service
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class TrainServiceImpl {
	
	@Autowired
	TrainDAOImpl trainDAOImpl;
	public long create(Train train) {
		return trainDAOImpl.create(train);		
	}
	
//	public boolean deleteTrain(int id) {
//		return TrainDAOImpl.deleteTrain(id);
//	}
	public List<Train> getAll() {
		return trainDAOImpl.getAll();
	}
	
}
