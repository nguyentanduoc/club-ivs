package com.vn.ivs.ctu.entity;

import javax.persistence.*;

@Entity(name="status")
public class Status {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "ID_STATUS")
	private int idStatus;
	
	@Column(name="NAME_STATUS", nullable =false, length=50)
	private String nameStatus;

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public String getNameStatus() {
		return nameStatus;
	}

	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
	}
	
	
}
