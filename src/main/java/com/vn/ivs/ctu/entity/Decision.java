package com.vn.ivs.ctu.entity;

import javax.persistence.*;

@Entity(name="decision")
public class Decision {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_DECISION")
	private long idDecision;
	
	@Column(name="NAME_DECISION",length=100)
	private String nameDecision;

	public long getIdDecision() {
		return idDecision;
	}

	public void setIdDecision(long idDecision) {
		this.idDecision = idDecision;
	}

	public String getNameDecision() {
		return nameDecision;
	}

	public void setNameDecision(String nameDecision) {
		this.nameDecision = nameDecision;
	}
	
}
