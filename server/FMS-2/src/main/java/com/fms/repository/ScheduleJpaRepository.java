package com.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.model.Schedule;
public interface ScheduleJpaRepository extends JpaRepository<Schedule,Integer> {

}
