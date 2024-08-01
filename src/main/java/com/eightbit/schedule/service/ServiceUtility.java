package com.eightbit.schedule.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceUtility {
	
	public static Date parseDate(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date parseDate = null;
		try {
			parseDate = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parseDate;
	}
	
	public static Date parseTime(String time) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date parseTime = null;
		try {
			parseTime = dateFormat.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parseTime;
	}
}