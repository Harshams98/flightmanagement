
package com.boot.jpa.entites;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ScheduledFlight {

	@OneToOne
	private Flight flight;
	@Id
	private int availableseats;
	
	private String schedule;

	
	public ScheduledFlight() {
		super();
	}

	public ScheduledFlight(Flight flight, int availableseats, String schedule) {
		super();
		this.flight = flight;
		this.availableseats = availableseats;
		this.schedule = schedule;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getAvailableseats() {
		return availableseats;
	}

	public void setAvailableseats(int availableseats) {
		this.availableseats = availableseats;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "ScheduledFlight [flight=" + flight + ", availableseats=" + availableseats + ", schedule=" + schedule
				+ "]";
	}
	
}