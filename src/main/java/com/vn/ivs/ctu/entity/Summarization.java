package com.vn.ivs.ctu.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.engine.spi.CascadeStyle;
import org.hibernate.engine.spi.CascadeStyles;

@Entity(name="sumarization")
@Table(name="sumarization")
public class Summarization {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "ID_SUM")
	private int idSum;
	
	@Column(name="MONTH_SUM")
	private int monthSum;
	
	@Column(name="SCORE_CLUB")
	private float scoreClub;
	
	@Column(name="REQUIRE_DONATE")
	private boolean requireDonate;
	
	@Column(name="SEE_DONATE")
	private boolean seeDonate;
	
	@Column(name="YEAR_SUM")
	private int yearSum;
	
	@OneToOne(cascade  = CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="ID_MEMBER")
	private Member member;
	
	@OneToOne(cascade  = CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="ID_CLUB")
	Club club;

	public int getIdSum() {
		return idSum;
	}

	public void setIdSum(int idSum) {
		this.idSum = idSum;
	}

	public int getMonthSum() {
		return monthSum;
	}

	public void setMonthSum(int monthSum) {
		this.monthSum = monthSum;
	}

	public float getScoreClub() {
		return scoreClub;
	}

	public void setScoreClub(float scoreClub) {
		this.scoreClub = scoreClub;
	}

	public boolean isRequireDonate() {
		return requireDonate;
	}

	public void setRequireDonate(boolean requireDonate) {
		this.requireDonate = requireDonate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public boolean isSeeDonate() {
		return seeDonate;
	}

	public void setSeeDonate(boolean seeDonate) {
		this.seeDonate = seeDonate;
	}

	public int isYearSum() {
		return yearSum;
	}

	public void setYearSum(int yearSum) {
		this.yearSum = yearSum;
	}
	
}
