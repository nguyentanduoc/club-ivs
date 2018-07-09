package com.vn.ivs.ctu.entity;

import java.util.Date;

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


@Entity(name="join_club")
@Table(name = "join_club")
@Proxy(lazy = false)
public class JoinClub {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_JOIN")
	private long idJoinClub;
	
	@Column(name="DATE_JOIN")
	private Date dateJoin;
	
	@Column(name="DATE_LEAVE")
	private Date dateLeave;
	
	@Column(name="STATUS_JOIN_CLUB")
	private boolean status;
	
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name="ID_MEMBER")
	private Member member;
	
		
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name="ID_CLUB")
	private Club club;
	
	public Date getDateJoin() {
		return dateJoin;
	}

	public void setDateJoin(Date dateJoin) {
		this.dateJoin = dateJoin;
	}

	public long getIdJoinClub() {
		return idJoinClub;
	}

	public void setIdJoinClub(long idJoinClub) {
		this.idJoinClub = idJoinClub;
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

	public Date getDateLeave() {
		return dateLeave;
	}

	public void setDateLeave(Date dateLeave) {
		this.dateLeave = dateLeave;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}	
	
}
