package com.boot.jpa;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.boot.jpa.dao.UsersRepo;
import com.boot.jpa.dao.BookingRepo;
import com.boot.jpa.dao.FlightRepo;
import com.boot.jpa.dao.PassengerRepo;
import com.boot.jpa.dao.ScheduledFlightRepo;
import com.boot.jpa.entites.Booking;
import com.boot.jpa.entites.Flight;
import com.boot.jpa.entites.Passenger;
import com.boot.jpa.entites.Users;

@SpringBootApplication
public class FlightmanagementApplication {

	public static void main(String[] args) {
		
		ApplicationContext context=SpringApplication.run(FlightmanagementApplication.class, args);
		
		UsersRepo usr=context.getBean(UsersRepo.class);
		
//		Users user=new Users();
//		user.setUsername("harsha");
//		user.setUsertype("Admin");
//		user.setUserpassword("harsha@123");
//		user.setEmail("harsha@gmail.com");
//		user.setUserphone(701962077);
//		
//		
//		Users save=usr.save(user);
//		System.out.println(save);
		
		
	FlightRepo flightrepo=context.getBean(FlightRepo.class);
		
//		Flight flight=new Flight();
//		flight.setCarriername("demo");
//		flight.setFlightmodel("demo");
//		flight.setSeatcapacity(76);
//		
//		Flight fsave = flightrepo.save(flight);
//		System.out.println(fsave.getFlightnumber());
		
		
		PassengerRepo passengerrepo=context.getBean(PassengerRepo.class);
//		Passenger passenger=new Passenger();
//		passenger.setLuggage(8.9);
//		passenger.setPassengerage(23);
//		passenger.setPassengername("harsha");
//		passenger.setPassengeruin(1232);
		
//		Passenger psave=passengerrepo.save(passenger);
//		System.out.println(psave);
//		
//		
//	System.out.println("--------------------------------------");
//		
//		
//		Iterable<Users>res=usr.findAll();
//		res.forEach(use ->System.out.println(use.getUsername()));
//		
//		System.out.println("-----------------------------------------");
		
		
		
		BookingRepo bookrepo=context.getBean(BookingRepo.class);
		
		Booking book = new Booking();
		
//		book.setUserid(user);
//		book.setNoofpassengers(236);
//		book.setBookingdate("12-08-2022");
//		book.setFlight(flight);
//		
//		book.setPassengerlist(passenger);
//		book.setTicketcost(200000.999);
		
//
//		Booking booksave = bookrepo.save(book);
//		System.out.println(booksave);
//		System.out.println((booksave.getUserid().getUserid()+500));
//		
	
		ScheduledFlightRepo scheduledflightrepo = context.getBean(ScheduledFlightRepo.class);
		
		
	
		
	}

}
