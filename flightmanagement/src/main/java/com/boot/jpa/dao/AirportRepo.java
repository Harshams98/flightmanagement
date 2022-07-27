package com.boot.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.boot.jpa.entites.Airport;


public interface AirportRepo extends CrudRepository<Airport,String> {

}