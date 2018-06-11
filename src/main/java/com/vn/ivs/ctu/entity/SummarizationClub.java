package com.vn.ivs.ctu.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="SUMMARIZATION_CLUB")
public class SummarizationClub {
	
	@EmbeddedId
	private SummarizationId summarizationId;
	
	@Column(name="SCORE_CLUB")
	private Float scoreClub;


	public Float getScoreClub() {
		return scoreClub;
	}

	public void setScoreClub(Float scoreClub) {
		this.scoreClub = scoreClub;
	}

	public SummarizationId getSummarizationId() {
		return summarizationId;
	}

	public void setSummarizationId(SummarizationId summarizationId) {
		this.summarizationId = summarizationId;
	}
		
	
}
