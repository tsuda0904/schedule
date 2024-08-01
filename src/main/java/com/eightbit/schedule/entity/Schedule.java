package com.eightbit.schedule.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {
	
	@Id
	@Column(name = "id")
	private int scheduleId;
	@Column(name = "day")
	private Date day;
	@Column(name = "time")
	private Date time;
	@Column(name = "meeting")
	private String meeting;
	@Column(name = "meeting_name")
	private String meetingName;
	@Column(name = "place")
	private String place;
	@Column(name = "schedule_registered")
	private Date scheduleRegistered;
	
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getMeeting() {
		return meeting;
	}
	public void setMeeting(String meeting) {
		this.meeting = meeting;
	}
	public String getMeetingName() {
		return meetingName;
	}
	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Date getScheduleRegistered() {
		return scheduleRegistered;
	}
	public void setScheduleRegistered(Date scheduleRegistered) {
		this.scheduleRegistered = scheduleRegistered;
	}
	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", day=" + day + ", time=" + time + ", meeting=" + meeting
				+ ", meetingName=" + meetingName + ", place=" + place + ", scheduleRegistered=" + scheduleRegistered
				+ "]";
	}
	
	
}