package com.vn.ivs.ctu.entity;

import javax.persistence.*;

@Entity(name = "date_of_week")
public class DateOfWeek {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_DOW")
	private int idDow;
	
	@Column(name="NAME_DOW",length=20)
	private String nameDow;
	
	@Column(name="VARIABLE_DOW")
	private int variableDow;

	public int getIdDow() {
		return idDow;
	}

	public void setIdDow(int idDow) {
		this.idDow = idDow;
	}

	public String getNameDow() {
		return nameDow;
	}

	public void setNameDow(String nameDow) {
		this.nameDow = nameDow;
	}

	public int getVariableDow() {
		return variableDow;
	}

	public void setVariableDow(int variableDow) {
		this.variableDow = variableDow;
	}
	
	
}
