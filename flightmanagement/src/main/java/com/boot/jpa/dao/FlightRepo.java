package com.boot.jpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.boot.jpa.entites.Flight;


public interface FlightRepo extends CrudRepository<Flight,Integer>{
	
	//public List<Flight> findByflightnumber(String flightnumber);

}