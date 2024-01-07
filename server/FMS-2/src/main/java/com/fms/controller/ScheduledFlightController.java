package com.fms.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.model.ScheduledFlight;
import com.fms.service.ScheduledFlightJpaService;

@RestController
@RequestMapping("/api/user")
public class ScheduledFlightController {
	
	@Autowired
	private ScheduledFlightJpaService s;
	
	@GetMapping("/scheduledflight")
	ArrayList<ScheduledFlight> getScheduledFlight()
	{
		return s.getScheduledFlight();
	}
	@GetMapping("/scheduledflight/{scheduledflightId}")
	ScheduledFlight getScheduledFlightById(int scheduledflightId)
	{
		return s.getScheduledFlightById(scheduledflightId);
	}
	@PostMapping("/scheduledflight/addnewone")
	ScheduledFlight addScheduledFlight(ScheduledFlight scheduledflight )
	{
		return s.addScheduledFlight(scheduledflight);
	}
	@PutMapping("/scheduledflight/{scheduledflightId}")
	ScheduledFlight updateScheduledFlight(int scheduledflightId, ScheduledFlight scheduledflight)
	{
		return s.updateScheduledFlight(scheduledflightId, scheduledflight);
	}
	@DeleteMapping("/scheduledflight/{scheduledflightId}")
	void deleteScheduledFlight(int flightId)
	{
		s.deleteScheduledFlight(flightId);
	}

}
