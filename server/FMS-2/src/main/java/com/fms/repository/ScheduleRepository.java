package com.fms.repository;

import java.util.ArrayList;

import com.fms.model.Schedule;



public interface ScheduleRepository {
	
	ArrayList<Schedule>getSchedule();
	Schedule getScheduleById(int scheduleId);
	Schedule addSchedule(Schedule schedule);
	Schedule updateSchedule(int scheduleId, Schedule schedule);
	void deleteSchedule(int scheduleId);

}
