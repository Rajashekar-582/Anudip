package com.fms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import com.fms.model.Airport;
import com.fms.repository.AirportJpaRepository;
import com.fms.repository.AirportRepository;

@Service
public class AirportJpaService  implements AirportRepository{
	@Autowired
	public AirportJpaRepository airportJpaRepository;

	@Override
	public ArrayList<Airport> getAirport() {
		List<Airport> airportList=airportJpaRepository.findAll();
		ArrayList<Airport> admin=new ArrayList<>(airportList);
		return admin;
	}

	@Override
	public Airport getAirportById(int airportId) {
		try
		{
		Airport admin= airportJpaRepository.findById( airportId).get();
		return admin;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public Airport addAirport(Airport airport) {
		airportJpaRepository.save(airport);
		 return airport;
	}

	@Override
	public Airport updateAirport(int airportId, Airport airport) {
		try
		{
		Airport existingAdmin= airportJpaRepository.findById( airportId).get();
		if(airport.getAirportName()!=null)
		{
			existingAdmin.setAirportName(airport.getAirportName());
		}
		 airportJpaRepository.save(existingAdmin);
		return existingAdmin;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public void deleteAirport(int airportId) {
		try
		{
		Airport admin= airportJpaRepository.findById(airportId).get();
		if(admin!=null)
		{
			airportJpaRepository.deleteById(airportId);
		}
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}

		
}
