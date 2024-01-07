package com.fms.model;

import java.math.BigInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="flight")
public class Flight {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int flightNo;
	private String carrierName;
	private String flightModel;
	private int seatCapacity;
	
	/*
	 * @OneToOne(mappedBy = "flightObj", cascade = CascadeType.ALL) private
	 * ScheduledFlight sfObj;
	 */
}
