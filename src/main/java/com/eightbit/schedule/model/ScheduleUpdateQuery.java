package com.eightbit.schedule.model;

import java.util.Date;

public class ScheduleUpdateQuery {
	
	private int scheduleId;
	private Date day;
	private Date time;
	private String meeting;
	private String meetingName;
	private String place;
	
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
	@Override
	public String toString() {
		return "ScheduleUpdateQuery [scheduleId=" + scheduleId + ", day=" + day + ", time=" + time + ", meeting="
				+ meeting + ", meetingName=" + meetingName + ", place=" + place + "]";
	}
	
		
}