package com.boot.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.boot.jpa.entites.Passenger;

public interface PassengerRepo extends CrudRepository<Passenger,String>{

}
