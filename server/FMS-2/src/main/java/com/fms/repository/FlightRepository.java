package com.fms.repository;

import java.util.ArrayList;

import com.fms.model.Flight;



public interface FlightRepository {
	ArrayList<Flight> getFlight();
	Flight getFlightById(int flightId);
	Flight addFlight(Flight flight );
	Flight updateFlight(int flightId, Flight flight);
	void deleteFlight(int flightId);

}
