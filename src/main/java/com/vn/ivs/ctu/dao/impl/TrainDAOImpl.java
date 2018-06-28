package com.vn.ivs.ctu.dao.impl;

import java.time.Year;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.vn.ivs.ctu.dao.TrainDAO;
import com.vn.ivs.ctu.entity.Role;
import com.vn.ivs.ctu.entity.Schedule;
import com.vn.ivs.ctu.entity.Train;

@Repository("trainDAOImpl")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class TrainDAOImpl implements TrainDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	

	public long create(Train train) {
		currentSession().saveOrUpdate(train);
		return train.getIdTrain();
	}

	public List<Train> getAllTrainAuto() {	
			try {
			return currentSession().createQuery("from train t where t.schedule.autoSchedule=?",Train.class).setParameter(0, false).list();
			}catch (Exception e) {
				System.out.println(e.toString());
				return null;
			}
	}

	public boolean deleteTrain(int id) {
		try {
			Train loadTrain = currentSession().load(Train.class,id) ;
			currentSession().delete(loadTrain);
			return true;
		}	catch(Exception ex) {
			System.out.println("deleteTrain-"+ ex.toString());
			return false;
		}	
	}


	public List<Train> getAllTrain() {
		try {
			return currentSession().createQuery("from train t where t.schedule.autoSchedule=?",Train.class).setParameter(0, true).list();
			}catch (Exception e) {
				return null;
			}
	}
	public List<Train> getAllTrainOnWeek() {
		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.WEEK_OF_YEAR);
		try {
		return currentSession().createQuery("from train t where t.weekend=?",Train.class).setParameter(0, week).list();
		}catch (Exception e) {
			return null;
		}
}


	@Override
	public List<Train> getListAllTrainOnWeek(int idClub) {
		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.WEEK_OF_YEAR);
		try {
			return currentSession().createQuery("from train t where t.weekend=? and t.schedule.club.idClub = ?",Train.class)
					.setParameter(0, week).setParameter(1, idClub).list();
		}catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

}
