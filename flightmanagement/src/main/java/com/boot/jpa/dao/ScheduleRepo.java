package com.boot.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.boot.jpa.entites.Schedule;
import com.boot.jpa.entites.ScheduledFlight;

public interface ScheduleRepo extends CrudRepository<Schedule,String> {

}