package com.vn.ivs.ctu.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="attendance")
public class Attendance {
	@EmbeddedId
	private AttendanceID attendanceID;
	
	@Column(name="IS_ATTENDANCE")
	private boolean attendance;

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

}
