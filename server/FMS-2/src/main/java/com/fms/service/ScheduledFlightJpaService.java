package com.fms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fms.model.Airport;
import com.fms.model.Flight;
import com.fms.model.ScheduledFlight;
import com.fms.repository.ScheduledFlightJpaRepository;
import com.fms.repository.ScheduledFlightRepository;
@Service
public class ScheduledFlightJpaService implements ScheduledFlightRepository {

	@Autowired
	private ScheduledFlightJpaRepository sJpaRepository;
	@Override
	public ArrayList<ScheduledFlight> getScheduledFlight() {
		List<ScheduledFlight> airportList=sJpaRepository.findAll();
		ArrayList<ScheduledFlight> admin=new ArrayList<>(airportList);
		return admin;
	}

	@Override
	public ScheduledFlight getScheduledFlightById(int scheduledflightId) {
		try
		{
		ScheduledFlight admin= sJpaRepository.findById( scheduledflightId).get();
		return admin;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	

	@Override
	public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledflight) {
		sJpaRepository.save(scheduledflight);
		 return scheduledflight;
	}

	@Override
	public ScheduledFlight updateScheduledFlight(int scheduledflightId, ScheduledFlight scheduledflight) {
		try
		{
		ScheduledFlight existingAdmin= sJpaRepository.findById( scheduledflightId).get();
		if(scheduledflight.getSchedule()!=null)
		{
			existingAdmin.setSchedule(scheduledflight.getSchedule());
		}
		 sJpaRepository.save(existingAdmin);
		return existingAdmin;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteScheduledFlight(int flightId) {
		try
		{
		ScheduledFlight admin= sJpaRepository.findById(flightId).get();
		if(admin!=null)
		{
			sJpaRepository.deleteById(flightId);
		}
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}

}
