package com.fms.repository;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import com.fms.model.Booking;

public interface BookingRepository {

	public ResponseEntity<?> createBooking(Booking newBooking);

	public Booking updateBooking(Booking newBooking);

	public String deleteBooking(Integer bookingId);

	public Iterable<Booking> displayAllBooking();

	public ResponseEntity<?> findBookingById(Integer bookingId);
}
