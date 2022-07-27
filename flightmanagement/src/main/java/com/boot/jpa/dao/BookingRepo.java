package com.boot.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.boot.jpa.entites.Booking;


public interface BookingRepo extends CrudRepository<Booking,Integer> {

}