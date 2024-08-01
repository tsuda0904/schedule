package com.eightbit.schedule.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eightbit.schedule.entity.Meeting;
import com.eightbit.schedule.entity.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
	
	List<Schedule> findByMeetingContaining(String meeting);
	
	Schedule findByScheduleId(int scheduleId);
	
}