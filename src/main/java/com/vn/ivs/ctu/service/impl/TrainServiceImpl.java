package com.vn.ivs.ctu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.vn.ivs.ctu.dao.TrainDAO;
import com.vn.ivs.ctu.entity.Train;
import com.vn.ivs.ctu.service.AttendanceService;
import com.vn.ivs.ctu.service.TrainService;

@Service
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class TrainServiceImpl implements TrainService {
	
	@Autowired TrainDAO trainDAO;
	@Autowired AttendanceService attendanceService;
	
	public long create(Train train) {
		return trainDAO.create(train);		
	}

	public List<Train> getAllTrainAuto(int idClub) {
		return trainDAO.getAllTrainAuto(idClub);
	}
	
	public List<Train> getAllTrainManual(int idClub) {
		return trainDAO.getAllTrainManual(idClub);
	}
	
	public boolean deleteTrain(long idTrain) {
		if(attendanceService.deleteAttendanceByTrain(idTrain)) {
			return trainDAO.deleteTrain(idTrain);
		}
		return false;
	}

	@Override
	public List<Train> getAll() {
		return trainDAO.getAll();
	}

	@Override
	public List<Train> getListAllTrainOnWeek(int idClub) {
		return trainDAO.getListAllTrainOnWeek(idClub);
	}
	
	@Override
	public List<Train> getListTrainByIdSchedule(long idSchedule){
		return trainDAO.getListTrainByIdSchedule(idSchedule);
	}
	@Override
	public boolean deleteTrainByIdSchedule(long idShedule) {
		boolean rs=false;
		List<Train> trains = getListTrainByIdSchedule(idShedule);
		if(trains!=null) {
			for(Train t : trains) {
				if(deleteTrain(t.getIdTrain())) {
					rs=true;
				}
				else {
					rs=false;
				}
			}
		}
		return rs;
	}

	@Override
	public int totalTrainInMonth(int month,int curentYear, int idClub) {
		return trainDAO.totalTrainInMonth(month,curentYear,idClub);
	}

	@Override
	public List<Train> getAllTrainByClub(int month, int year, int idClub) {
		return trainDAO.getAllTrainByClub(month, year, idClub);
	}
	@Override
	public Train getTrainById(long id) {
		return trainDAO.getTrainById(id);
	}

	@Override
	public List<Train> getTrainBySchedule(long idSchedule) {
		return trainDAO.getTrainBySchedule(idSchedule);
	}

	@Override
	public List<Train> getAllTrainBranch(int idBranch) {
		return trainDAO.getAllTrainBranch(idBranch);
	}
}
