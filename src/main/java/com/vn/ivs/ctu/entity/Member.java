package com.vn.ivs.ctu.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="member")
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_MEMBER")
	private int idMember;
	
	@Column(name = "NAME_MEMBER", nullable = false, length = 100 )
	private String nameMember;
	
	@Column(name="BIRTH_DAY_MEMBER")
	private Date birthDayMember;
	
	@Column(name="SEX_MEMBER")
	private boolean sexMember;
	
	@Column(name="PHONE_NUMBER_MEMBER")
	private String phoneNumberMember;
	
	@Column(name="USER_NAME_MEMBER")
	private String userNameMember;
	
	@Column(name="PASSWORD_MEMBER")
	private String passWordMember;
	
	@Column(name="AVARTAR_MEMBER")
	private String avartarMember;
	
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="ID_ROLE")
	private Role role;

	public long getIdMember() {
		return idMember;
	}

	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}

	public String getNameMember() {
		return nameMember;
	}

	public void setNameMember(String nameMember) {
		this.nameMember = nameMember;
	}

	public Date getBirthDayMember() {
		return birthDayMember;
	}

	public void setBirthDayMember(Date birthDayMember) {
		this.birthDayMember = birthDayMember;
	}

	public boolean isSexMember() {
		return sexMember;
	}

	public void setSexMember(boolean sexMember) {
		this.sexMember = sexMember;
	}

	public String getPhoneNumberMember() {
		return phoneNumberMember;
	}

	public void setPhoneNumberMember(String phoneNumberMember) {
		this.phoneNumberMember = phoneNumberMember;
	}

	public String getUserNameMember() {
		return userNameMember;
	}

	public void setUserNameMember(String userNameMember) {
		this.userNameMember = userNameMember;
	}

	public String getPassWordMember() {
		return passWordMember;
	}

	public void setPassWordMember(String passWordMember) {
		this.passWordMember = passWordMember;
	}

	public String getAvartarMember() {
		return avartarMember;
	}

	public void setAvartarMember(String avartarMember) {
		this.avartarMember = avartarMember;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
