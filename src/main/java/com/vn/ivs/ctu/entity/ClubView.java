package com.vn.ivs.ctu.entity;

public class ClubView {

	private String nameClub;
	private int plus;
	private int deduct;
	
	public String getNameClub() {
		return nameClub;
	}
	public void setNameClub(String nameClub) {
		this.nameClub = nameClub;
	}
	public int getPlus() {
		return plus;
	}
	public void setPlus(int plus) {
		this.plus = plus;
	}
	public int getDeduct() {
		return deduct;
	}
	public void setDeduct(int deduct) {
		this.deduct = deduct;
	}
	public ClubView(String nameClub, int plus, int deduct) {
		super();
		this.nameClub = nameClub;
		this.plus = plus;
		this.deduct = deduct;
	}
		
}
