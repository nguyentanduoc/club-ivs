package com.vn.ivs.ctu.entity;

public class MemberView {
	
	private int idMember;
	private String nameMember;

	public MemberView(int idMember, String nameMember) {
		this.idMember = idMember;
		this.nameMember = nameMember;
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

	

}
