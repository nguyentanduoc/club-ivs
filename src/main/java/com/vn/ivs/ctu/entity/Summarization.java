package com.vn.ivs.ctu.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="SUMMARIZATION")
public class Summarization {
	
	@EmbeddedId
	private SummarizationId summarizationId;
	
	@Column(name="SCORE")
	private Float score;
	
	@Column(name="CONTAIN")
	private String contain;

	public SummarizationId getSummarizationId() {
		return summarizationId;
	}

	public void setSummarizationId(SummarizationId summarizationId) {
		this.summarizationId = summarizationId;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public String getContain() {
		return contain;
	}

	public void setContain(String contain) {
		this.contain = contain;
	}
	
}
