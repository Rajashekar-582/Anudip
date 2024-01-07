package com.fms.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.model.Schedule;
import com.fms.service.ScheduleJpaService;

@RestController
@RequestMapping("/api/admin")
public class ScheduleController {
	@Autowired
	private ScheduleJpaService scheduleJpaService;
	
	@GetMapping("/schedule")
	public ArrayList<Schedule> getSchedule()
	{
		return scheduleJpaService.getSchedule();
	}
	@GetMapping("/schedule/{scheduleId}")
	public Schedule getScheduleById(@PathVariable int scheduleId)
	{
		return scheduleJpaService.getScheduleById(scheduleId);
		
	}
	@PostMapping("/schedule/addnewschedule")
	public Schedule addSchedule(@RequestBody Schedule schedule)
	{
		return scheduleJpaService.addSchedule(schedule);
	}
	@PutMapping("/schedule/{scheduleId}")
	public Schedule updateSchedule(@PathVariable int scheduleId,@RequestBody Schedule schedule)
	{
		return scheduleJpaService.updateSchedule(scheduleId, schedule);
	}
	@DeleteMapping("/schedule/{scheduleId}")
	void deleteSchedule(@PathVariable int scheduleId)
	{
		scheduleJpaService.deleteSchedule(scheduleId);
	}

}
