package com.boot.jpa.entites;


import javax.persistence.Entity;

import javax.persistence.Id;


@Entity
public class Airport {	
	private String airport;
	private String airportLocation;
	@Id
	private String airportCode;
	
	
	@Override
	public String toString() {
		return "Airport [airport=" + airport + ", airportLocation=" + airportLocation + ", airportCode=" + airportCode
				+ "]";
	}
	public String getAirport() {
		return airport;
	}
	public void setAirport(String airport) {
		this.airport = airport;
	}
	public String getAirportLocation() {
		return airportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	public Airport() {
		super();
	}
	public Airport(String airport, String airportLocation, String airportCode) {
		super();
		this.airport = airport;
		this.airportLocation = airportLocation;
		this.airportCode = airportCode;
	}

}