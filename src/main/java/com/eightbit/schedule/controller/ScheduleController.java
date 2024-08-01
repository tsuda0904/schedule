package com.eightbit.schedule.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eightbit.schedule.entity.Schedule;
import com.eightbit.schedule.model.ScheduleUpdateQuery;
import com.eightbit.schedule.service.ScheduleService;

@Controller
public class ScheduleController {
	
	private final ScheduleService scheduleService;
	
	@Autowired
	public ScheduleController(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}
	
	@GetMapping("/")
	public String routeToIndex(Model model) {
		List<Schedule> scheduleList = scheduleService.findAll();
		model.addAttribute("scheduleList", scheduleList);
		
		return "index";
	}
	
	@GetMapping("/schedule/search")
	public String searchSchedule(Model model, @RequestParam("meeting") String meeting) {
		List<String> meetingList = scheduleService.meetingList(meeting);
		List<Schedule> scheduleList = scheduleService.searchSchedule(meetingList);
		
		model.addAttribute("scheduleList", scheduleList);
		model.addAttribute("searchMeeting", meeting);
		System.out.println(model);
		return "index";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(path = "/schedule/index")
	public String routeToScheduleIndex(Model model) {
		List<Schedule> scheduleList = scheduleService.findAll();
		model.addAttribute("scheduleList", scheduleList);
		
		return "scheduleIndex";
	}
	
	@GetMapping("/schedule/update/{id}")
	public String editSchedule(Model model, @PathVariable(value="id") int scheduleId) {
	    Schedule schedule = scheduleService.searchScheduleById(scheduleId);
		model.addAttribute("Schedule", schedule);
		
		ScheduleUpdateQuery suq = scheduleService.getScheduleDto(schedule);
		model.addAttribute("scheduleUpdateQuery", suq);
	    
	    return "scheduleUpdate";
	}
	
	@PostMapping("/schedule/update")
	public String updateSchedule(@ModelAttribute ScheduleUpdateQuery scheduleUpdateQuery, Model model, @RequestParam("meetingday") String day, @RequestParam("meetingtime") String time) {
		scheduleService.updateSchedule(scheduleUpdateQuery, day, time);
		
		return "redirect:/schedule/index";
	}
	
	@PostMapping("/schedule/delete")
	public String deleteSchedule(@RequestParam("id") int scheduleId) {
		scheduleService.deleteScheduleData(scheduleId);
		return "redirect:/schedule/index";
	}
	
	@GetMapping(path = "/schedule/regist")
	public String scheduleRegist(Model model) {
		model.addAttribute("scheduleEntity", new Schedule());
		
		return "scheduleRegist";
	}
	
	@PostMapping("/schedule/registExecute")
	public String scheduleRegistExecute(@ModelAttribute Schedule schedule, @RequestParam("meetingday") String day, @RequestParam("meetingtime") String time) {
		scheduleService.scheduleRegist(schedule, day, time);
		
		return "redirect:/schedule/index";
	}
	
	
}