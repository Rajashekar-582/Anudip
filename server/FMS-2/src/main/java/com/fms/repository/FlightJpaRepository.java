package com.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.model.Flight;

public interface FlightJpaRepository extends JpaRepository<Flight,Integer>{

}
