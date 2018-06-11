package com.vn.ivs.ctu.entity;

import javax.persistence.*;

@Entity(name="branch")
public class Branch {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_BRANCH")
	private int idBranch;
	
	@Column(name="NAME_BRANCH", length = 100)
	private String nameBranch;
	
	@Column(name="ADDRESS_BRANCH", length=300)
	private String addressBranch;
	
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="ID_MEMBER")
	private Member member;
	
	public String getAddressBranch() {
		return addressBranch;
	}

	public void setAddressBranch(String addressBranch) {
		this.addressBranch = addressBranch;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public int getIdBranch() {
		return idBranch;
	}	
	
	public void setIdBranch(int idBranch) {
		this.idBranch = idBranch;
	}

	public String getNameBranch() {
		return nameBranch;
	}

	public void setNameBranch(String nameBranch) {
		this.nameBranch = nameBranch;
	}
	
}
