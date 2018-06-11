package com.vn.ivs.ctu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="join_club")
public class JoinClub {
	
	@EmbeddedId
	private JoinClubId joinClubId;
	
	@Column(name="DATE_JOIN")
	private Date dateJoin;
	
	@Column(name="DATE_UPDATE")
	private Date dateUpdate;

	public JoinClubId getJoinClubId() {
		return joinClubId;
	}

	public void setJoinClubId(JoinClubId joinClubId) {
		this.joinClubId = joinClubId;
	}

	public Date getDateJoin() {
		return dateJoin;
	}

	public void setDateJoin(Date dateJoin) {
		this.dateJoin = dateJoin;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}
	
}
