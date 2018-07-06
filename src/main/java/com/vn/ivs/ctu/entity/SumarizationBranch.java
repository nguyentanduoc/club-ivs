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

import org.hibernate.annotations.Proxy;

@Entity(name="sumarization_branch")
@Table(name="sumarization_branch")
@Proxy(lazy=false)
public class SumarizationBranch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_SUM_BRANCH")
	private int idSumBranch;
	
	@OneToOne(cascade  = CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="ID_MEMBER")
	private Member member;
	
	@OneToOne(cascade  = CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="ID_BRANCH")
	private Branch branch;
	
	@Column(name="Score_Branch")
	private float scoreBranch;
	
	@Column(name="MONTH")
	private int month;
	
	@Column(name="YEAR")
	private int year;
	
	@Column(name="DONATE")
	private boolean donate;
	
	@Column(name="CONTAIN_DONATE")
	private String containDonate;
	
	@Column(name="CONFIRM_DONATE")
	private boolean confirmDonate;
	
	@Column(name="COMFIRM")
	private boolean confirm;

	public int getIdSumBranch() {
		return idSumBranch;
	}

	public void setIdSumBranch(int idSumBranch) {
		this.idSumBranch = idSumBranch;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public float getScoreBranch() {
		return scoreBranch;
	}

	public void setScoreBranch(float scoreBranch) {
		this.scoreBranch = scoreBranch;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public boolean isDonate() {
		return donate;
	}

	public void setDonate(boolean donate) {
		this.donate = donate;
	}

	public String getContainDonate() {
		return containDonate;
	}

	public void setContainDonate(String containDonate) {
		this.containDonate = containDonate;
	}

	public boolean isConfirmDonate() {
		return confirmDonate;
	}

	public void setConfirmDonate(boolean confirmDonate) {
		this.confirmDonate = confirmDonate;
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}
	
	
}
