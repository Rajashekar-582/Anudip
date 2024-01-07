package com.fms.model;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "schedule")
public class Schedule {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "schedule_Id")
	private int scheduleId;

	@OneToOne(fetch = FetchType.EAGER)
	private Airport srcAirport;

	@OneToOne(fetch = FetchType.EAGER)
	private Airport dstnAirport;

	@Column(name = "departure_date")
	@JsonFormat(pattern = "mm-dd-yyyy HH:mm:ss")
	private String deptDateTime;

	@Column(name = "arrival_date")
	@JsonFormat(pattern = "mm-dd-yyyy HH:mm:ss")
	private String arrDateTime;

}
