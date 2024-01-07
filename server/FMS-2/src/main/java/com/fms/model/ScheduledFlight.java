package com.fms.model;
import java.math.BigInteger;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;
@Data
@Entity
@Table(name="scheduledflight")
public class ScheduledFlight {

	@Id
	
	@Column(name = "schedule_flight_id")
	private BigInteger scheduleFlightId;

	@OneToOne(fetch = FetchType.EAGER)
	@NonNull
	private Flight flight;

	@Column(name = "available_seats")
	@NonNull
	private Integer availableSeats;

	@NonNull
	@OneToOne(cascade = CascadeType.ALL)
	private Schedule schedule;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availableSeats == null) ? 0 : availableSeats.hashCode());
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		result = prime * result + ((schedule == null) ? 0 : schedule.hashCode());
		result = prime * result + ((scheduleFlightId == null) ? 0 : scheduleFlightId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScheduledFlight other = (ScheduledFlight) obj;
		if (availableSeats == null) {
			if (other.availableSeats != null)
				return false;
		} else if (!availableSeats.equals(other.availableSeats))
			return false;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		if (schedule == null) {
			if (other.schedule != null)
				return false;
		} else if (!schedule.equals(other.schedule))
			return false;
		if (scheduleFlightId == null) {
			if (other.scheduleFlightId != null)
				return false;
		} else if (!scheduleFlightId.equals(other.scheduleFlightId))
			return false;
		return true;
	}
}
