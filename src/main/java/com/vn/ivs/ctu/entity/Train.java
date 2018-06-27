package com.vn.ivs.ctu.entity;

import java.util.Date;

import javax.persistence.*;

@Entity(name="train")
public class Train {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TRAIN")
	private int idTrain;
	
	@Column(name = "DATE_TRAIN")
	private Date dateTrain;
	
	@Column(name = "WEEKEND")
	private int weekend;
	
	@Column(name = "YEAR")
	private int year;
	
	@OneToOne(cascade  = CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="ID_SCHEDULE")
	private Schedule schedule;

	public int getIdTrain() {
		return idTrain;
	}

	public void setIdTrain(int idTrain) {
		this.idTrain = idTrain;
	}

	public Date getDateTrain() {
		return dateTrain;
	}

	public void setDateTrain(Date dateTrain) {
		this.dateTrain = dateTrain;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public int getWeekend() {
		return weekend;
	}

	public void setWeekend(int weekend) {
		this.weekend = weekend;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	
	
}
