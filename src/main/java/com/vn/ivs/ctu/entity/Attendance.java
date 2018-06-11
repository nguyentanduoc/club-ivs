package com.vn.ivs.ctu.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="attendance")
public class Attendance {
	@EmbeddedId
	private AttendanceID attendanceID;
	
	@Column(name="reason", length=500)
	private String reason;

	public AttendanceID getAttendanceID() {
		return attendanceID;
	}

	public void setAttendanceID(AttendanceID attendanceID) {
		this.attendanceID = attendanceID;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
