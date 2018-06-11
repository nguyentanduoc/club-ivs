package com.vn.ivs.ctu.entity;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity(name="schedule")
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_SCHEDULE")
	private long idSchedule;
	
	@Column(name="NAME_SCHEDULE",length=100)
	private String nameSchedule;
	
	@Column(name="TIME_SCHEDULE")
	private Timestamp timeSchedule;
	
	@Column(name="LOCATION_SCHEDULE")
	private String locationSchedule;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_DOW")
	private DateOfWeek dateOfWeek;
	
	
	public long getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(long idSchedule) {
		this.idSchedule = idSchedule;
	}

	public String getNameSchedule() {
		return nameSchedule;
	}

	public void setNameSchedule(String nameSchedule) {
		this.nameSchedule = nameSchedule;
	}

	public Timestamp getTimeSchedule() {
		return timeSchedule;
	}

	public void setTimeSchedule(Timestamp timeSchedule) {
		this.timeSchedule = timeSchedule;
	}

	public String getLocationSchedule() {
		return locationSchedule;
	}

	public void setLocationSchedule(String locationSchedule) {
		this.locationSchedule = locationSchedule;
	}

	public DateOfWeek getDateOfWeek() {
		return dateOfWeek;
	}

	public void setDateOfWeek(DateOfWeek dateOfWeek) {
		this.dateOfWeek = dateOfWeek;
	}
	
}
