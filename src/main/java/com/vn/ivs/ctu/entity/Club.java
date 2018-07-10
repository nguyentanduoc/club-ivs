package com.vn.ivs.ctu.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.Scope;


@Entity(name="club")
@Proxy(lazy = false)
@Scope("session")
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
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "manage_club", joinColumns = { @JoinColumn(name = "ID_CLUB") }, inverseJoinColumns = {
			@JoinColumn(name = "ID_MEMBER") })
	Set<Member> members;
	
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

	public Set<Member> getMembers() {
		return members;
	}

	public void setMembers(Set<Member> members) {
		this.members = members;
	}	
}
