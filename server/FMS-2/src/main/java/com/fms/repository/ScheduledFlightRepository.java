package com.fms.repository;

import java.util.ArrayList;


import com.fms.model.ScheduledFlight;

public interface ScheduledFlightRepository {

	ArrayList<ScheduledFlight> getScheduledFlight();
	ScheduledFlight getScheduledFlightById(int scheduledflightId);
	ScheduledFlight addScheduledFlight(ScheduledFlight scheduledflight );
	ScheduledFlight updateScheduledFlight(int scheduledflightId, ScheduledFlight scheduledflight);
	void deleteScheduledFlight(int flightId);
}
