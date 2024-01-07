package com.fms.repository;

import java.util.ArrayList;

import com.fms.model.Airport;


public interface AirportRepository {
	ArrayList<Airport> getAirport();
	Airport getAirportById(int airportId);
	Airport addAirport(Airport airport);
	Airport updateAirport(int airportId, Airport airport);
	void deleteAirport(int airportId);

}
