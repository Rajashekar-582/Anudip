package com.fms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fms.model.Booking;
import com.fms.service.BookingJpaService;
import com.fms2.exception.RecordAlreadyPresentException;
import com.fms2.exception.*;

@RestController
@CrossOrigin
public class BookingController {
	
	@Autowired
	public BookingJpaService bookingService;
	@PostMapping("/booking/addnewbooking")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public void addBooking(@RequestBody Booking newBooking) {

		bookingService.createBooking(newBooking);
	}

	@GetMapping("/booking")
	public Iterable<Booking> readAllBookings() {

		return bookingService.displayAllBooking();
	}

	@PutMapping("/updateBooking")
	@ExceptionHandler(ResourceNotFoundException.class)
	public void modifyBooking(@RequestBody Booking updateBooking) {
		bookingService.updateBooking(updateBooking);
	}


	@GetMapping("/booking/{id}")
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> searchBookingByID(@PathVariable("id") Integer bookingId) {
		return bookingService.findBookingById(bookingId);
	}

	@DeleteMapping("/booking/{id}")
	@ExceptionHandler(ResourceNotFoundException.class)
	public void deleteBookingByID(@PathVariable("id") Integer bookingId) {
		bookingService.deleteBooking(bookingId);
	}
}