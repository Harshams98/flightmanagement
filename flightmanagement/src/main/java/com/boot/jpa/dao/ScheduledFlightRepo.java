package com.boot.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.boot.jpa.entites.ScheduledFlight;

public interface ScheduledFlightRepo extends CrudRepository<ScheduledFlight,Integer> {

}
