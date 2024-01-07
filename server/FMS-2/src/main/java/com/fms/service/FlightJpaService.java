package com.fms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fms.model.Airport;
import com.fms.model.Flight;
import com.fms.repository.FlightJpaRepository;
import com.fms.repository.FlightRepository;

@Service
public class FlightJpaService implements FlightRepository {

	@Autowired
	public FlightJpaRepository flightJpaRepository;
	
	@Override
	public ArrayList<Flight> getFlight() {
		List<Flight> airportList=flightJpaRepository.findAll();
		ArrayList<Flight> admin=new ArrayList<>(airportList);
		return admin;
	}

	@Override
	public Flight getFlightById(int flightId) {
		try
		{
		Flight admin= flightJpaRepository.findById( flightId).get();
		return admin;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public Flight addFlight(Flight flight) {
		flightJpaRepository.save(flight);
		 return flight;
	}

	@Override
	public Flight updateFlight(int flightId, Flight flight) {
		try
		{
		Flight existingAdmin= flightJpaRepository.findById( flightId).get();
		if(flight.getCarrierName()!=null)
		{
			existingAdmin.setCarrierName(flight.getCarrierName());
		}
		 flightJpaRepository.save(existingAdmin);
		return existingAdmin;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteFlight(int flightId) {
		try
		{
		Flight admin= flightJpaRepository.findById(flightId).get();
		if(admin!=null)
		{
			flightJpaRepository.deleteById(flightId);
		}
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}

}
