package com.vn.ivs.ctu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="join_club")
@Table(name = "join_club")
public class JoinClub {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_JOIN_CLUB")
	private int idJoinClub;
	
	@Column(name="DATE_JOIN")
	private Date dateJoin;
	
	@OneToOne
	@JoinColumn(name="ID_MEMBER")
	private Member member;
	
	@OneToOne
	@JoinColumn(name="ID_STATUS")
	private Status status;
	
	@OneToOne
	@JoinColumn(name="ID_CLUB")
	private Club club;
	
	public Date getDateJoin() {
		return dateJoin;
	}

	public void setDateJoin(Date dateJoin) {
		this.dateJoin = dateJoin;
	}

	public int getIdJoinClub() {
		return idJoinClub;
	}

	public void setIdJoinClub(int idJoinClub) {
		this.idJoinClub = idJoinClub;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}	
	
}
