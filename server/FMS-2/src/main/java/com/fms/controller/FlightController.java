package com.fms.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.model.Flight;
import com.fms.service.FlightJpaService;

@RestController
@CrossOrigin
public class FlightController {
	@Autowired
	public FlightJpaService flightJpaService;
	
	@GetMapping("/flight")
	public ArrayList<Flight> getFlight()
	{
		return flightJpaService.getFlight();
		
	}
	@GetMapping("/flight/{fightId}")
	public Flight getFlightById(@PathVariable int flightId)
	{
		return flightJpaService.getFlightById(flightId);
	}
	@PostMapping("/flight/addnewflight")
	public Flight addFlight(@RequestBody Flight flight )
	{
		return flightJpaService.addFlight(flight);
	}
	@PutMapping("/flight/{flightId}")
	public Flight updateFlight(@PathVariable int flightId, @RequestBody Flight flight)
	{
		return flightJpaService.updateFlight(flightId, flight);
	}
	@DeleteMapping("/flight/{flightId}")
	void deleteFlight(@PathVariable int flightId)
	{
		flightJpaService.deleteFlight(flightId);
	}

}
