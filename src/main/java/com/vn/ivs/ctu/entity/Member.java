package com.vn.ivs.ctu.entity;

import java.util.Date;
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
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity(name = "member")
@Table(name = "member")
@Proxy(lazy = false)
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "idMember")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MEMBER")
	private int idMember;

	@Column(name = "NAME_MEMBER", nullable = false, length = 100)
	private String nameMember;

	@Column(name = "BIRTH_DAY_MEMBER")
	private Date birthDayMember;

	@Column(name = "SEX_MEMBER")
	private boolean sexMember;

	@Column(name = "PHONE_NUM_MEMBER")
	private String phoneNumberMember;

	@Column(name = "USER_NAME_MEMBER")
	private String userNameMember;

	@Column(name = "PASSWORD_MEMBER")
	private String passWordMember;

	@Column(name = "AVARTAR_MEMBER")
	private String avartarMember;

	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_BRANCH", referencedColumnName = "ID_BRANCH")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Branch branch;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "member_role", joinColumns = { @JoinColumn(name = "ID_MEMBER") }, inverseJoinColumns = {
			@JoinColumn(name = "ID_ROLE") })
	private Set<Role> roles ;

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Branch getBranch() {	
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public int getIdMember() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMember;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (idMember != other.idMember)
			return false;
		return true;
	}

}
