package com.fms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import com.fms.model.Booking;

import com.fms.repository.BookingJpaRepository;
import com.fms.repository.BookingRepository;
import com.fms2.exception.RecordAlreadyPresentException;
import com.fms2.exception.ResourceNotFoundException;
@Service
public class BookingJpaService implements BookingRepository {

	@Autowired
	public BookingJpaRepository bookJpaRepository;

	@Override
	public ResponseEntity<?> createBooking(Booking newBooking) {
		Optional<Booking> findBookingById = bookJpaRepository.findById(newBooking.getBookingId());
		try {
			if (!findBookingById.isPresent()) {
				bookJpaRepository.save(newBooking);
				return new ResponseEntity<Booking>(newBooking, HttpStatus.OK);
			} else
				throw new RecordAlreadyPresentException(
						"Booking with Booking Id: " + newBooking.getBookingId() + " already exists!!");
		} catch (RecordAlreadyPresentException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Booking updateBooking(Booking changedBooking) {
		Optional<Booking> findBookingById = bookJpaRepository.findById(changedBooking.getBookingId());
		if (findBookingById.isPresent()) {
			bookJpaRepository.save(changedBooking);
		} else
			throw new ResourceNotFoundException(
					"Booking with Booking Id: " + changedBooking.getBookingId() + " not exists!!");
		return changedBooking;
	}

	@Override
	public String deleteBooking(Integer bookingId) {
		Optional<Booking> findBookingById = bookJpaRepository.findById(bookingId);
		if (findBookingById.isPresent()) {
			bookJpaRepository.deleteById(bookingId);
			return "Booking Deleted!!";
		} else
			throw new ResourceNotFoundException("Booking not found for the entered BookingID");
	}
	

	@Override
	public Iterable<Booking> displayAllBooking() {
		return bookJpaRepository.findAll();
	}

	@Override
	public ResponseEntity<?> findBookingById(Integer bookingId) {
		Optional<Booking> findById = bookJpaRepository.findById(bookingId);
		try {
			if (findById.isPresent()) {
				Booking findBooking = findById.get();
				return new ResponseEntity<Booking>(findBooking, HttpStatus.OK);
			} else
				throw new ResourceNotFoundException("No record found with ID " + bookingId);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
	}
 }
}