package com.vn.ivs.ctu.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Proxy;

@Entity(name="schedule")
@Proxy(lazy=false)
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_SCHEDULE")
	private long idSchedule;
	
	@Column(name="NAME_SCHEDULE",length=100)
	private String nameSchedule;
	
	@Column(name="TIME_SCHEDULE")
	private String timeSchedule;
	
	@Column(name="LOCATION_SCHEDULE")
	private String locationSchedule;
	
	@Column(name="AUTO_GENERATED")
	private boolean autoSchedule;
	
	@OneToOne(cascade =CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinColumn(name="ID_DOW",referencedColumnName="ID_DOW")
	private DateOfWeek dateOfWeek;
	
	@OneToOne(cascade =CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinColumn(name="ID_CLUB",referencedColumnName="ID_CLUB")
	private Club club;
	
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

	public String getTimeSchedule() {
		return timeSchedule;
	}

	public void setTimeSchedule(String timeSchedule) {
		this.timeSchedule = timeSchedule;
	}

	public String getLocationSchedule() {
		return locationSchedule;
	}

	public void setLocationSchedule(String locationSchedule) {
		this.locationSchedule = locationSchedule;
	}
	
	public boolean getAutoSchedule() {
		return autoSchedule;
	}

	public void setAutoSchedule(boolean autoSchedule) {
		this.autoSchedule = autoSchedule;
	}

	public DateOfWeek getDateOfWeek() {
		return dateOfWeek;
	}

	public void setDateOfWeek(DateOfWeek dateOfWeek) {
		this.dateOfWeek = dateOfWeek;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}
	
}
