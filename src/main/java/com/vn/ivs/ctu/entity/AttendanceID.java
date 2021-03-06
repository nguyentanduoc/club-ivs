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
	private long idMember;
	
	@Column(name="ID_TRAIN")
	private long idTrain;
	
	public long getIdMember() {
		return idMember;
	}
	public void setIdMember(long idMember) {
		this.idMember = idMember;
	}
	public long getIdTrain() {
		return idTrain;
	}
	public void setIdTrain(long idTrain) {
		this.idTrain = idTrain;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idMember ^ (idMember >>> 32));
		result = prime * result + (int) (idTrain ^ (idTrain >>> 32));
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
