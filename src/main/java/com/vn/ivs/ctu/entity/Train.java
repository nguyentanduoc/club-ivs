package com.vn.ivs.ctu.entity;

import java.util.Date;

import javax.persistence.*;

@Entity(name="train")
public class Train {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TRAIN")
	private long idTrain;
	
	@Column(name = "DATE_TRAIN")
	private Date dateTrain;
	
	@OneToOne(cascade  = CascadeType.ALL)
	@JoinColumn(name="ID_SCHEDULE")
	private Schedule schedule;
	
	@OneToOne(cascade  = CascadeType.ALL)
	@JoinColumn(name="ID_CLUB")
	private Club club;

	public long getIdTrain() {
		return idTrain;
	}

	public void setIdTrain(long idTrain) {
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

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}
	
	
}
