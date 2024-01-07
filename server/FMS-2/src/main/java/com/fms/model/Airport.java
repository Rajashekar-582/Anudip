package com.fms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="airport")
public class Airport {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String airportCode;
	private String airportLocation;
	private String airportName;
}
