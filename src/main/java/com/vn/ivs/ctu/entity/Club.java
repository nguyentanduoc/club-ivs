package com.vn.ivs.ctu.entity;

import java.util.Set;

import javax.persistence.*;


@Entity(name="club")
public class Club {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CLUB")
	private int idClub;
	
	@Column(name="NAME_CLUB", length=100)
	private String nameClub;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_BRANCH")
	private Branch branch;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_MEMBER")
	private Member member;
	
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="SCHEDULE_CLUB", 
			joinColumns= {@JoinColumn(name="ID_CLUB",referencedColumnName="ID_CLUB")},
			inverseJoinColumns = {@JoinColumn(name="ID_SCHEDULE",referencedColumnName="ID_SCHEDULE")})
	Set<Schedule> schedules;
	
	public Set<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(Set<Schedule> schedules) {
		this.schedules = schedules;
	}
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
