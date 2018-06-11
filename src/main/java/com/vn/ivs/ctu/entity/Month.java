package com.vn.ivs.ctu.entity;

import javax.persistence.*;

@Entity(name="month")
public class Month {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_MONTH")
	private int idMonth;
	
	@Column(name="NAME_MONTH", length=255)
	private String nameMonth;

	public int getIdMonth() {
		return idMonth;
	}

	public void setIdMonth(int idMonth) {
		this.idMonth = idMonth;
	}

	public String getNameMonth() {
		return nameMonth;
	}

	public void setNameMonth(String nameMonth) {
		this.nameMonth = nameMonth;
	}
	
	
}
