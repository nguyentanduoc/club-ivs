package com.vn.ivs.ctu.utils;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.vn.ivs.ctu.entity.Club;

public class MyUserDetail extends User {
	
	private static final long serialVersionUID = 88160345636855905L;

	public MyUserDetail(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
	private long idMember;
	private String nameMember;
	private Date birthDayMember;
	private boolean sexMember;
	private String phoneNumberMember;
	private String avartarMember;
	private Set<Club> clubs;
	
	public long getIdMember() {
		return idMember;
	}
	public void setIdMember(long idMember) {
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
	public Set<Club> getClubs() {
		return clubs;
	}
	public void setClubs(Set<Club> clubs) {
		this.clubs = clubs;
	}
	
}
