package com.vn.ivs.ctu.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Proxy;

@Entity(name="attendance")
@Proxy(lazy=false)
public class Attendance {
	
	@EmbeddedId
	private AttendanceID attendanceID;
	
	@Column(name="IS_ATTENDANCE")
	private boolean attendance;
	
	@Column(name="REASON")
	private String reason;

	@OneToOne(cascade  = {CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
	@JoinColumn(name="ID_TRAIN", insertable=false, updatable=false)
	private Train train;
	
	@OneToOne(cascade  = CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="ID_MEMBER", insertable=false, updatable=false)
	private Member member;
	
	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public AttendanceID getAttendanceID() {
		return attendanceID;
	}

	public void setAttendanceID(AttendanceID attendanceID) {
		this.attendanceID = attendanceID;
	}

	public boolean isAttendance() {
		return attendance;
	}

	public void setAttendance(boolean attendance) {
		this.attendance = attendance;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
