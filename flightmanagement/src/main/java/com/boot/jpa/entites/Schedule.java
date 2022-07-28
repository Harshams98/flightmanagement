package com.boot.jpa.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Schedule {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int scheduleId;
	@OneToOne
	private Airport sourceAirport;
	@OneToOne
	private Airport destination;
	private String arrivalTime;
	private String departureTime;
	public Schedule() {
		super();
	}
	public Schedule(Airport sourceAirport, Airport destination, String arrivalTime, String departureTime) {
		super();
		this.sourceAirport = sourceAirport;
		this.destination = destination;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	public Airport getSourceAirport() {
		return sourceAirport;
	}
	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}
	public Airport getDestination() {
		return destination;
	}
	public void setDestination(Airport destination) {
		this.destination = destination;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", sourceAirport=" + sourceAirport + ", destination="
				+ destination + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + "]";
	}
	
	
	
}
