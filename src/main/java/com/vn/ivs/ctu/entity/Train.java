package com.vn.ivs.ctu.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

@Entity(name="train")
@Proxy(lazy=false)
public class Train {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TRAIN")
	private int idTrain;
	
	@Column(name = "DATE_TRAIN")
	private Date dateTrain;
	
	@Column(name = "WEEKEND")
	private int weekend;
		
	@OneToOne(cascade  = {CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
	@JoinColumn(name="ID_SCHEDULE")
	private Schedule schedule;
	
	@OneToMany(mappedBy="train", cascade = CascadeType.REMOVE)
	private Set<Attendance> attendances;
	
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
	
	public Set<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(Set<Attendance> attendances) {
		this.attendances = attendances;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTrain;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Train other = (Train) obj;
		if (idTrain != other.idTrain)
			return false;
		return true;
	}
	
}
