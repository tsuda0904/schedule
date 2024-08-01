package com.eightbit.schedule.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "meeting")
public class Meeting {
	
	@Id
	@Column(name = "id")
	private int meetingId;
	@Column(name = "meeting")
	private String meeting;
	
	
	public int getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}
	public String getMeeting() {
		return meeting;
	}
	public void setMeeting(String meeting) {
		this.meeting = meeting;
	}
	
	@Override
	public String toString() {
		return "Meeting [meetingId=" + meetingId + ", meeting=" + meeting + "]";
	}
	
}