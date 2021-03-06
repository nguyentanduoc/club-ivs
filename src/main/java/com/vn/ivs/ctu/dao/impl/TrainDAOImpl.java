package com.vn.ivs.ctu.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.vn.ivs.ctu.dao.TrainDAO;
import com.vn.ivs.ctu.entity.Train;
import com.vn.ivs.ctu.utils.DateUtils;

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
	
	public boolean deleteTrain(long idTrain) {		
		try {
			Train loadTrain = currentSession().load(Train.class,idTrain);
			currentSession().delete(loadTrain);
			return true;
		}	catch(Exception ex) {
			System.out.println("deleteTrain-"+ ex.toString());
			return false;
		}	
	}

	public List<Train> getAllTrainAuto(int idClub) {	
			try {
			return currentSession().createQuery("from train t where t.schedule.autoSchedule=:autoSchedule and t.schedule.club.idClub=:idClub",Train.class)
					.setParameter("autoSchedule", true).setParameter("idClub", idClub).list();
			}catch (Exception e) {
				System.out.println(e.toString());
				return null;
			}
	}
	public List<Train> getAllTrainManual(int idClub) {	
		try {
		return currentSession().createQuery("from train t where t.schedule.autoSchedule=? and t.schedule.club.idClub=?",Train.class)
				.setParameter(0, false).setParameter(1, idClub).list();
		}catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
}

	public List<Train> getAll() {
		try {
			return currentSession().createQuery("from train",Train.class).list();
			}catch (Exception e) {
				return null;
			}
	}

	@Override
	public List<Train> getListAllTrainOnWeek(int idClub) {
		try {
			return currentSession().createQuery("from train t where t.schedule.club.idClub =:idClub and t.weekend=:weekend",Train.class)
					.setParameter("idClub", idClub).setParameter("weekend", DateUtils.getCurrentWeekend()).list();
		}catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	@Override
	public List<Train> getListTrainByIdSchedule(long idSchedule) {
		
		try {
			return currentSession().createQuery("from train t where t.schedule.idSchedule=?",Train.class).setParameter(0, idSchedule).list();
			}catch (Exception e) {
				System.out.println(e.toString());
				return null;
			}
	}
	public int totalTrainInMonth(int month, int curentYear, int idClub) {

		try {
			return ((Number)currentSession().createQuery("select count(t) from train t where t.schedule.club.idClub = ? and year(t.dateTrain) =?  and month(t.dateTrain) = ?")
					.setParameter(0, idClub).setParameter(1, curentYear).setParameter(2, month)    
					.getSingleResult()
					).intValue();
		}catch(Exception ex) {
			System.out.println(ex.toString());
			return 0;
		}
	}

	@Override
	public List<Train> getAllTrainByClub(int month, int year, int idClub) {
		try {
			return currentSession().createQuery("select t from train t where t.schedule.club.idClub = ? and year(t.dateTrain) = ?  and month(t.dateTrain) = ?",Train.class)
					.setParameter(0, idClub).setParameter(1, year).setParameter(2, month).list();
		}catch(Exception ex) {
			System.out.println(ex.toString());
			return null;
		}
	}
	
	public Train getTrainById(long id) {
		try {
		return currentSession().load(Train.class,id);
		}catch (Exception ex) {
			return null;
		}
	}
	public List<Train> getTrainBySchedule(long idSchedule){
		try {
			return currentSession().createQuery("select t from train t where t.schedule.idSchedule = ?",Train.class)
					.setParameter(0, idSchedule).list();
		}catch(Exception ex) {
			System.out.println(ex.toString());
			return null;
		}
	}
	public List<Train> getAllTrainBranch(int idBranch){
		try {
			return currentSession().createQuery("SELECT t FROM train t JOIN t.schedule s JOIN s.club c  WHERE c.branch.idBranch =:idBranch and t.weekend=:weekend",Train.class)
					.setParameter("idBranch", idBranch).setParameter("weekend", DateUtils.getCurrentWeekend()).list();
		}catch(Exception ex) {
			System.out.println(ex.toString());
			return null;
		}
	}

}
