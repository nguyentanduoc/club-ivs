package com.vn.ivs.ctu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="SUMMARIZATION")
public class Summarization {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "ID_SUM")
	private int idSum;
	
	@Column(name="MONTH_SUM")
	private String monthSum;
	@Column(name="SCORE_CLUB")
	private float scoreClub;
	@Column(name="SCORE")
	private float score;
	@Column(name="REQUIRE_DONATE")
	private boolean requireDonate;
	@Column(name="ACCESS_DONATE")
	private boolean accessDonate;
	@Column(name="CONTAIN_SUM")
	private String containSum;
	@Column(name="COMFIRM")
	private boolean comfirm;
	
	@OneToOne
	@JoinColumn(name="ID_MEMBER")
	private Member member;
	
	@OneToOne
	@JoinColumn(name="ID_CLUB")
	Club club;

	public int getIdSum() {
		return idSum;
	}

	public void setIdSum(int idSum) {
		this.idSum = idSum;
	}

	public String getMonthSum() {
		return monthSum;
	}

	public void setMonthSum(String monthSum) {
		this.monthSum = monthSum;
	}

	public float getScoreClub() {
		return scoreClub;
	}

	public void setScoreClub(float scoreClub) {
		this.scoreClub = scoreClub;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public boolean isRequireDonate() {
		return requireDonate;
	}

	public void setRequireDonate(boolean requireDonate) {
		this.requireDonate = requireDonate;
	}

	public boolean isAccessDonate() {
		return accessDonate;
	}

	public void setAccessDonate(boolean accessDonate) {
		this.accessDonate = accessDonate;
	}

	public String getContainSum() {
		return containSum;
	}

	public void setContainSum(String containSum) {
		this.containSum = containSum;
	}

	public boolean isComfirm() {
		return comfirm;
	}

	public void setComfirm(boolean comfirm) {
		this.comfirm = comfirm;
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
	
}
