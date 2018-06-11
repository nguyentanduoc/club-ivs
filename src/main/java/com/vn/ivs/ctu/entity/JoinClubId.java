package com.vn.ivs.ctu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class JoinClubId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="ID_MEMBER")
	private int idMember;
	
	@Column(name="ID_CLUB")
	private int idClub;
	
	@Column(name="ID_STATUS")
	private int idStatus;

	public int getIdMember() {
		return idMember;
	}

	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}

	public int getIdClub() {
		return idClub;
	}

	public void setIdClub(int idClub) {
		this.idClub = idClub;
	}

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
