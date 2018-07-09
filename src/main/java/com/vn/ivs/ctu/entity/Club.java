package com.vn.ivs.ctu.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Proxy;


@Entity(name="club")
@Proxy(lazy = false)
public class Club {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CLUB")
	private int idClub;
	
	@Column(name="NAME_CLUB", length=100)
	private String nameClub;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ID_BRANCH")
	private Branch branch;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ID_MEMBER")
	private Member member;
	
	public int getIdClub() {
		return idClub;
	}

	public void setIdClub(int idClub) {
		this.idClub = idClub;
	}

	public String getNameClub() {
		return nameClub;
	}

	public void setNameClub(String nameClub) {
		this.nameClub = nameClub;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
}
