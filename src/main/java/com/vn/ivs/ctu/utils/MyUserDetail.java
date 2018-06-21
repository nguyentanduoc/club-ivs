package com.vn.ivs.ctu.utils;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


public class MyUserDetail extends User {
	
	private static final long serialVersionUID = 88160345636855905L;

	public MyUserDetail(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
		
	private int idMember;
	private String nameMember;
	private Date birthDayMember;
	private boolean sexMember;
	private String phoneNumberMember;
	private String avartarMember;

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
	public String getAvartarMember() {
		return avartarMember;
	}
	public void setAvartarMember(String avartarMember) {
		this.avartarMember = avartarMember;
	}
	
}
