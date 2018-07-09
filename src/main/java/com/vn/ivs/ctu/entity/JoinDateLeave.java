package com.vn.ivs.ctu.entity;

import java.util.Date;

public class JoinDateLeave {


	private Date dateSort;
	private String nameClub;
	private boolean status;
	
	public JoinDateLeave(Date dateSort, String nameClub, boolean status) {
		super();
		this.dateSort = dateSort;
		this.nameClub = nameClub;
		this.status = status;
	}

	public String getNameClub() {
		return nameClub;
	}

	public void setNameClub(String nameClub) {
		this.nameClub = nameClub;
	}

	public Date getDateSort() {
		return dateSort;
	}

	public void setDateSort(Date dateSort) {
		this.dateSort = dateSort;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
