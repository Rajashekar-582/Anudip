package com.fms.repository;
import com.fms.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportJpaRepository extends JpaRepository<Airport,Integer> {

}
