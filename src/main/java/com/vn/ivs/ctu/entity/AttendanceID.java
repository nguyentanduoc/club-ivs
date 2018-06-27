package com.vn.ivs.ctu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AttendanceID implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="ID_MEMBER")
	private int idMember;
	
	@Column(name="ID_TRAIN")
	private int idTrain;
	
	public int getIdMember() {
		return idMember;
	}
	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}
	public int getIdTrain() {
		return idTrain;
	}
	public void setIdTrain(int idTrain) {
		this.idTrain = idTrain;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMember;
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
		AttendanceID other = (AttendanceID) obj;
		if (idMember != other.idMember)
			return false;
		if (idTrain != other.idTrain)
			return false;
		return true;
	}
	
}
