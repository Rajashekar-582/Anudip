package com.fms.model;

import java.math.BigInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
///import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToOne;
@Data
@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookingId;
	private String bookingDate;
	private String source;
	private String destination;
	private int noOfPassengers;
	public Integer getBookingId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
