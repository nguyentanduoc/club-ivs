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

@Entity(name="summarization_branch")
@Table(name="summarization_branch")
@Proxy(lazy=false)
public class SumarizationBranch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_SUM_SCORE")
	private long idSumBranch;
	
	@OneToOne(cascade  = CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="ID_MEMBER")
	private Member member;
	
	@OneToOne(cascade  = CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="ID_BRANCH")
	private Branch branch;
	
	@Column(name="SCORE_BRANCH")
	private float scoreBranch;	

	@Column(name="DONATE")
	private boolean donate;
	
	@Column(name="DONATE_CONTAIN")
	private String containDonate;
	
	@Column(name="COMFIRM_DONATE")
	private boolean confirmDonate;
	
	@Column(name="COMFIRM")
	private boolean confirm;
	
	@Column(name="MONTH_SUM_BRANCH")
	private int month;
	
	@Column(name="YEAR_SUM_BRANCH")
	private int year;
	
	@Column(name="REQUIRE_DONATE")
	private boolean requireDonate;
	
	public long getIdSumBranch() {
		return idSumBranch;
	}

	public void setIdSumBranch(long idSumBranch) {
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

	public boolean isRequireDonate() {
		return requireDonate;
	}

	public void setRequireDonate(boolean requireDonate) {
		this.requireDonate = requireDonate;
	}
		
}
