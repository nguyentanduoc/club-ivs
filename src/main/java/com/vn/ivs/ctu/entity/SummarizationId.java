package com.vn.ivs.ctu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SummarizationId implements Serializable{
	
	@Column(name="ID_MONTH")
	private int idMonth;
	@Column(name="ID_MEMBER")
	private int idMember;
	@Column(name="ID_CLUB")
	private int idClub;
	public int getIdMonth() {
		return idMonth;
	}
	public void setIdMonth(int idMonth) {
		this.idMonth = idMonth;
	}
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
	
	
}

