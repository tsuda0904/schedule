package com.eightbit.schedule.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.eightbit.schedule.entity.Schedule;
import com.eightbit.schedule.model.ScheduleUpdateQuery;
import com.eightbit.schedule.repository.ScheduleRepository;

@Service
public class ScheduleService {
	
	@Autowired
	private ScheduleRepository scheduleRepo;
	
	public List<Schedule> findAll() {
		return scheduleRepo.findAll(
				Sort.by(Sort.Direction.ASC, "day")
				.and(Sort.by(Sort.Direction.ASC, "time")));
	}
	
	/**
	 * ★特定スケジュール検索
	 * @param scheduleId
	 * @return 特定スケジュールデータ
	 */
	public Schedule searchScheduleById(int scheduleId) {
		Schedule schedule = new Schedule();
		schedule = scheduleRepo.findById((long)scheduleId).get();
		
		return schedule;
	}
	
	/**
	 * ★会議名検索
	 * @param meetingList
	 * @return 特定スケジュールデータ(複数)
	 */
	public List<Schedule> searchSchedule(List<String> meetingList) {
		ArrayList<Schedule> scheduleList = new ArrayList<>();
		
		for(int i=0; i<meetingList.size(); i++) {
			scheduleList.addAll(scheduleRepo.findByMeetingContaining(meetingList.get(i)));
			System.out.println(meetingList.get(i));
		}
		
		return scheduleList;
	}
	
	/**
	 * ★会議リスト作成
	 * @param meeting
	 * @return 特定会議リスト
	 */
	public List<String> meetingList(String meeting) {
		String[] meetings = meeting.split(",");
		List<String> meetingList = new ArrayList<>();
		for(String meetingName: meetings) {
			meetingList.add(meetingName);
		}
		System.out.println(meetingList);
		return meetingList;
	}
	
	/**
	 * ★特定のスケジュールデータを削除する
	 * @param userId
	 */
	public void deleteScheduleData(int scheduleId) {
		scheduleRepo.deleteById((long)scheduleId);
	}
	
	/**
	 * ★特定のスケジュールデータを更新する
	 */
	public void updateSchedule(Schedule schedule) {
		scheduleRepo.save(schedule);
	}
	
	/**
	 * スケジュール登録情報変更時パラメータ受け取り用
	 * @param schedule
	 * @return パラメータ格納モデル
	 */
	public ScheduleUpdateQuery getScheduleDto(Schedule schedule) {
		ScheduleUpdateQuery suq = new ScheduleUpdateQuery();
		
		suq.setScheduleId(schedule.getScheduleId());
		suq.setDay(schedule.getDay());
		suq.setTime(schedule.getTime());
		suq.setMeeting(schedule.getMeeting());
		suq.setMeetingName(schedule.getMeetingName());
		suq.setPlace(schedule.getPlace());
//		System.out.println(suq);
		return suq;
	}
	
	/**
	 * ★特定スケジュールデータ情報更新
	 * @param suq
	 */
	public void updateSchedule(ScheduleUpdateQuery suq, String day, String time) {
		Schedule schedule = new Schedule();
		
		schedule = scheduleRepo.findByScheduleId(suq.getScheduleId());
		schedule.setScheduleId(suq.getScheduleId());
		schedule.setDay(ServiceUtility.parseDate(day));
		schedule.setTime(ServiceUtility.parseTime(time));
		schedule.setMeeting(suq.getMeeting());
		schedule.setMeetingName(suq.getMeetingName());
		schedule.setPlace(suq.getPlace());
		
		scheduleRepo.save(schedule);
	}
	
	/**
	 * ★スケジュール新規登録
	 * @param schedule
	 */
	public void scheduleRegist(Schedule schedule, String day, String time) {
		Date now = new Date();
		schedule.setDay(ServiceUtility.parseDate(day));
		schedule.setTime(ServiceUtility.parseTime(time));
		schedule.setScheduleRegistered(now);
		
		scheduleRepo.save(schedule);
	}
	
	
}