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

import com.fms.model.Airport;
import com.fms.service.AirportJpaService;
@CrossOrigin
@RestController

public class AirportController
{

	@Autowired
	public AirportJpaService airportJpaService;
	@GetMapping("/airport")
	public ArrayList<Airport> getAirport()
	{
		return airportJpaService.getAirport();
	}
	@GetMapping("/airport/{airportId}")
	public Airport getAirportById(@PathVariable int airportId)
	{
		return airportJpaService.getAirportById(airportId);
	}
	@PostMapping("/airport/addnewairport")
	public Airport addAirport(@RequestBody Airport airport)
	{
		return airportJpaService.addAirport(airport);
	}
	@PutMapping("/airport/{airportId}")
	public Airport updateAirport(@PathVariable int airportId, @RequestBody Airport airport)
	{
		return airportJpaService.updateAirport(airportId, airport);
	}
	@DeleteMapping("/airport/{airport}")
	void deleteAirport(@PathVariable int airportId)
	{
		airportJpaService.deleteAirport(airportId);
	}
	
	
}
