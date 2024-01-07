package com.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.model.Booking;

public interface BookingJpaRepository extends JpaRepository<Booking,Integer>{

}
