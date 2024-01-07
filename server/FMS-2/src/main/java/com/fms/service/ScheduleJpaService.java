package com.fms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fms.model.Airport;
import com.fms.model.Schedule;
import com.fms.repository.ScheduleJpaRepository;
import com.fms.repository.ScheduleRepository;

@Service
public class ScheduleJpaService implements ScheduleRepository {

	@Autowired
	public ScheduleJpaRepository scheduleJpaRepository;
	@Override
	public ArrayList<Schedule> getSchedule() {
		List<Schedule> airportList=scheduleJpaRepository.findAll();
		ArrayList<Schedule> admin=new ArrayList<>(airportList);
		return admin;
	}

	@Override
	public Schedule getScheduleById(int scheduleId) {
		try
		{
		Schedule admin= scheduleJpaRepository.findById( scheduleId).get();
		return admin;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Schedule addSchedule(Schedule schedule) {
		scheduleJpaRepository.save(schedule);
		 return schedule;
	}

	@Override
	public Schedule updateSchedule(int scheduleId, Schedule schedule) {
		try
		{
		Schedule existingAdmin= scheduleJpaRepository.findById( scheduleId).get();
		if(schedule.getSrcAirport()!=null)
		{
			existingAdmin.setSrcAirport(schedule.getSrcAirport());
		}
		 scheduleJpaRepository.save(existingAdmin);
		return existingAdmin;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteSchedule(int scheduleId) {
		// TODO Auto-generated method stub
		try
		{
		Schedule admin= scheduleJpaRepository.findById(scheduleId).get();
		if(admin!=null)
		{
			scheduleJpaRepository.deleteById(scheduleId);
		}
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}

}
