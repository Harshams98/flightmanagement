package com.boot.jpa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;

import com.boot.jpa.dao.UsersRepo;
import com.boot.jpa.dao.AirportRepo;
import com.boot.jpa.dao.BookingRepo;
import com.boot.jpa.dao.FlightRepo;
import com.boot.jpa.dao.PassengerRepo;
import com.boot.jpa.dao.ScheduleRepo;
import com.boot.jpa.dao.ScheduledFlightRepo;
import com.boot.jpa.entites.Airport;
import com.boot.jpa.entites.Booking;
import com.boot.jpa.entites.Flight;
import com.boot.jpa.entites.Passenger;
import com.boot.jpa.entites.Schedule;
import com.boot.jpa.entites.ScheduledFlight;
import com.boot.jpa.entites.Users;

@SpringBootApplication
public class FlightmanagementApplication {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ApplicationContext context = SpringApplication.run(FlightmanagementApplication.class, args);

		UsersRepo usr = context.getBean(UsersRepo.class);

		FlightRepo flightrepo = context.getBean(FlightRepo.class);

		PassengerRepo passengerrepo = context.getBean(PassengerRepo.class);

		BookingRepo bookrepo = context.getBean(BookingRepo.class);

		Booking book = new Booking();

		ScheduledFlightRepo scheduledflightrepo = context.getBean(ScheduledFlightRepo.class);

		AirportRepo airportrepo = context.getBean(AirportRepo.class);

		ScheduleRepo schedulerepo = context.getBean(ScheduleRepo.class);
		
		int userId = 0;
		boolean mainloop = true;
try {
		while (mainloop) {
			System.out.println("\n \t \t \t Welcome to Flight Management Application!!!!\n");

			System.out.println("Enter your Choice \n" + "1.Admin \t 2.Customer");

			int choice = Integer.parseInt(br.readLine());

			if (choice == 1) {

				System.out.println("--------------------------------------");
				// login----------
				System.out.println("enter email-id");
				String email = br.readLine();
				System.out.println("enter password");
				String password = br.readLine();
				Users user = new Users();
				boolean authentication = false;
				boolean authenticationadmin = false;
				Iterable<Users> itradmin = usr.findAll();
				Iterator<Users> iteratoradmin = itradmin.iterator();
				// ListIterator lit=(ListIterator) res.iterator();
				while (iteratoradmin.hasNext()) {
					if (iteratoradmin.next().getUsertype().equals("admin") == true) {
						authenticationadmin = true;
					}

				}

				Iterable<Users> itr = usr.findAll();
				Iterator<Users> iterator = itr.iterator();
				// ListIterator lit=(ListIterator) res.iterator();
				while (iterator.hasNext()) {
					if (iterator.next().getEmail().equals(email) == true) {
						authentication = true;
					}

				}
				boolean authentication2 = false;
				Iterable<Users> itr2 = usr.findAll();
				Iterator<Users> iterator2 = itr2.iterator();
				// ListIterator lit=(ListIterator) res.iterator();
				while (iterator2.hasNext()) {
					if (iterator2.next().getUserpassword().equals(password) == true) {
						authentication2 = true;
					}

				}

				if (authentication && authentication2 && authenticationadmin) {
					System.out.println("sucessful");

					boolean loop = true;
					while (loop) {
						System.out.println("Press 1 for Flight Management");
						System.out.println("Press 2 to Airport Management ");
						System.out.println("Press 3 to Schedule Management  ");// source destination
						System.out.println("Press 4 to Schedule flight Management ");// available seats
						System.out.println("Press 5 to  exit");
						System.out.println("-----------------------------------------");

						int adminchoose = Integer.parseInt(br.readLine());
						boolean flightloop = true;

						while (flightloop) {
							switch (adminchoose) {

							case 1: {

								System.out.println("Press 1 for View Flights");
								System.out.println("Press 2 to add Flights ");
								System.out.println("Press 3 to update Flight ");
								//Not able to delete due to forigen key reference
								System.out.println("Press 4 to delete Flight ");
								System.out.println("Press 5 to  exit");

								int flightchoose = Integer.parseInt(br.readLine());

								switch (flightchoose) {

								case 1: {

									Iterable<Flight> res = flightrepo.findAll();
									res.forEach(use -> System.out.println(use));
									break;
								}
								case 2: {
									System.out.println("Enter Flight's CarrierName");
									String carriername = br.readLine();
									System.out.println("Enter Flight's Model");
									String fmodel = br.readLine();
									System.out.println("Enter Flight's Seating Capacity");
									int fcapacity = Integer.parseInt(br.readLine());

									Flight flight = new Flight();
									flight.setCarriername(carriername);
									flight.setFlightmodel(fmodel);
									flight.setSeatcapacity(fcapacity);

									Flight flightsave = flightrepo.save(flight);
									System.out.println("New Flight Record Added successfully");
									System.out.println(flightsave);
									break;
								}

								case 3: {
									System.out.println("Enter Flight's Id to change Seating Capacity");
									int fid = Integer.parseInt(br.readLine());
									// update the record
									Optional<Flight> optional = flightrepo.findById(fid);
									Flight flight = optional.get();
									System.out.println("Enter Seating Capacity");
									int seats = Integer.parseInt(br.readLine());
									flight.setSeatcapacity(seats);
									Flight display = flightrepo.save(flight);
									System.out.println(display);
									break;
								}
								case 4: {
									System.out.println("Enter Flight's Id to Delete the Flight Record");
									int fiddelete = Integer.parseInt(br.readLine());
									// delete record
									flightrepo.deleteById(fiddelete);
									System.out.println("flight Id: " + fiddelete + " Record Deleted");
									break;
								}
								case 5: {
									System.out.println("Thankyou");
									flightloop = false;
									break;

								}
								default: {
									System.out.println("Wrong Entry Try Again");
								}

								}

								break;
							}
							case 2: {
								System.out.println("Press 1 for View Airport");
								System.out.println("Press 2 to add Airport ");
								System.out.println("Press 3 to update Airport Name and location ");
								//Not able to delete due to forigen key reference
								System.out.println("Press 4 to delete Airport ");
								System.out.println("Press 5 to  exit");
								int Airportchoose = Integer.parseInt(br.readLine());

								switch (Airportchoose) {
								case 1: {

									Iterable<Airport> res = airportrepo.findAll();
									res.forEach(use -> System.out.println(use));
									break;

								}
								case 2: {
									System.out.println("Enter Airport Name");
									String aname = br.readLine();
									System.out.println("Enter Airport Location");
									String airportloc = br.readLine();
									System.out.println("Enter Airport Location");
									String airportcode = br.readLine();

									Airport airport = new Airport();
									airport.setAirport(aname);
									airport.setAirportLocation(airportloc);
									airport.setAirportCode(airportcode);
									Airport airportsave = airportrepo.save(airport);
									System.out.println("New Airport Record Added successfully");
									System.out.println(airportsave);
									break;

								}
								case 3: {

									System.out.println("Enter Airport Code to change Airport Name and Location");
									String acode = br.readLine();
									// update the record
									Optional<Airport> optional = airportrepo.findById(acode);
									Airport airport = optional.get();
									System.out.println("Enter the new location of Airport");
									String location = br.readLine();
									System.out.println("Enter the new Name for Airport");
									String aname = br.readLine();
									airport.setAirport(aname);
									airport.setAirportLocation(location);
									Airport display = airportrepo.save(airport);
									System.out.println(display);
									break;
								}
								case 4: {
									System.out.println("Enter Airport's Code to Delete the Airport Record");
									String airrdelete = br.readLine();
									// delete record
									airportrepo.deleteById(airrdelete);
									System.out.println("Airport Code: " + airrdelete + " Record Deleted");
									break;

								}
								case 5: {
									System.out.println("Thankyou");
									flightloop = false;
									break;
								}
								default: {
									System.out.println("Wrong Try Again");

								}

								}
								break;
							}
							case 3: {
								System.out.println("Press 1 for View Schedule");
								System.out.println("Press 2 to Schedule Flights");
								System.out.println("Press 3 to delete Schedule Flights ");
								System.out.println("Press 4 to  exit");

								int schedulechoose = Integer.parseInt(br.readLine());

								switch (schedulechoose) {
								case 1: {

									Iterable<Schedule> res = schedulerepo.findAll();
									res.forEach(use -> System.out.println(use));
									break;
								}
								case 2: {
									System.out.println("Enter Arrival Time");
									String arrival = br.readLine();
									System.out.println("Enter departure Time");
									String departure = br.readLine();
									System.out.println("Enter  Source Airport code");
									String source = br.readLine();
									System.out.println("Enter  Destination Airport code");
									String destination = br.readLine();

									Schedule schedule = new Schedule();

									schedule.setArrivalTime(arrival);
									schedule.setDepartureTime(departure);
									Optional<Airport> optional = airportrepo.findById(source);
									schedule.setSourceAirport(optional.get());
									Optional<Airport> optionaltwo = airportrepo.findById(destination);
									schedule.setDestination(optionaltwo.get());

									Schedule Schedulesave = schedulerepo.save(schedule);
									System.out.println(Schedulesave.getSourceAirport().getAirportLocation());
									System.out.println(Schedulesave.getDestination().getAirportLocation());
									break;
								}
								case 3: {
									System.out.println("Enter schedule Id to delete the schedule");
									int schedule = Integer.parseInt(br.readLine());
									// delete record
									schedulerepo.deleteById(schedule);
									System.out.println("Schedule Code: " + schedule + " Record Deleted");
									break;
								}
								case 4: {
									System.out.println("Thankyou");
									flightloop = false;
									break;
								}
								default: {
									System.out.println("Wrong Try Again");

								}

								}

								break;

							}
							case 4: {

								System.out.println("Press 1 for View Scheduled Flights");
								System.out.println("Press 2 to Add Scheduled Flights");
								System.out.println("Press 3 to delete Schedule Flights ");
								System.out.println("Press 4 to  exit");

								int schedulefchoose = Integer.parseInt(br.readLine());

								switch (schedulefchoose) {
								case 1: {

									Iterable<ScheduledFlight> res = scheduledflightrepo.findAll();
									res.forEach(use -> System.out.println(use));
									break;

								}
								case 2: {

									System.out.println("Enter Flight Number");
									int fnumber = Integer.parseInt(br.readLine());

									System.out.println("Enter available seats of the Flight");
									int availableseats = Integer.parseInt(br.readLine());

									System.out.println("Enter scheduleId to set the schedule Time for flight");
									int schedule = Integer.parseInt(br.readLine());

									ScheduledFlight scheduledflight = new ScheduledFlight();

									scheduledflight.setAvailableseats(availableseats);

									Optional<Flight> optional = flightrepo.findById(fnumber);
									scheduledflight.setFlight(optional.get());
									Optional<Schedule> optionatwo = schedulerepo.findById(schedule);
									scheduledflight.setSchedule(optionatwo.get());

									ScheduledFlight Schedulesave = scheduledflightrepo.save(scheduledflight);
									System.out.println(Schedulesave);
									break;

								}
								case 3: {

									System.out.println("Enter schedule Id to delete the scheduledFlight");
									int schedule = Integer.parseInt(br.readLine());
									// delete record
									scheduledflightrepo.deleteById(schedule);
									System.out.println("Schedule Code: " + schedule + " Record Deleted");
									break;

								}
								case 4: {
									System.out.println("Thank You");
									flightloop = false;
									break;
								}
								default: {
									System.out.println("try again");
								}
								}

								break;
							}

							}

						}

					}

				} else {
					System.out.println("unsuccessful try again");

				}

			} else if (choice == 2) {
				boolean customerloop = false;
				System.out.println("Welcome to customer page");

				System.out.println("Are you a Existing User Y/N");
				char answer = (char) br.read();
				br.readLine();
				if (answer == 'y') {

					System.out.println("enter email-id");
					String email = br.readLine();
					System.out.println("enter password");
					String password = br.readLine();
					Users user = new Users();
					boolean cusauthentication = false;
					Iterable<Users> itr = usr.findAll();
					Iterator<Users> iterator = itr.iterator();
					// ListIterator lit=(ListIterator) res.iterator();
					while (iterator.hasNext()) {
						// if(user.getUsertype()=="admin")
						if (iterator.next().getEmail().equals(email) == true) {
							cusauthentication = true;
						}

					}
					
					boolean cusauthentication2 = false;
					Iterable<Users> itr2 = usr.findAll();
					Iterator<Users> iterator2 = itr2.iterator();
					// ListIterator lit=(ListIterator) res.iterator();
					while (iterator2.hasNext()) {
						if (iterator2.next().getUserpassword().equals(password) == true) {
							cusauthentication2 = true;
						}

					}
					if (cusauthentication && cusauthentication2) {
						customerloop = true;
						System.out.println("successful logged in ");
					} else {

						System.out.println("Please try again later");
					}

				} else if (answer == 'n') {
					System.out.println("Enter your Name ");
					String cusName = br.readLine();
					System.out.println("Enter your Phone Number");
					int cusPhone = Integer.parseInt(br.readLine());
					System.out.println("Enter your Email Id");
					String cusEmail = br.readLine();
					System.out.println("Enter your password");
					String cuspassword = br.readLine();
					Users user = new Users();
					user.setUsername(cusName);
					user.setUserphone(cusPhone);
					user.setEmail(cusEmail);
					user.setUserpassword(cuspassword);
					user.setUsertype("Customer");
					Users customersave = usr.save(user);

					// saving user id of the customer for storing in booking table
					userId = customersave.getUserid();
					System.out.println(customersave);
					customerloop = true;

				}

				while (customerloop) {

					System.out.println("Press 1 for Check Available flight ");
					System.out.println("Press 2 to Make Booking ");
					System.out.println("Press 3 to  View Booking ");
					System.out.println("Press 4 to Cancle Booking");
					System.out.println("Press 5 to Exit");
					System.out.println("-----------------------------------------");

					int customerchoose = Integer.parseInt(br.readLine());

					switch (customerchoose) {
					case 1: {

						/* Now we have to write here checck available flight */

						Iterable<Flight> res = flightrepo.findAll();
						res.forEach(use -> System.out.println(use));

						break;

					}

					case 2: {
						// Booking flight section
						System.out.println("Enter your FullName");
						String passName = br.readLine();
						System.out.println("Enter your Age");
						int passAge = Integer.parseInt(br.readLine());
						System.out.println("Enter your UIN");
						int passUIN = Integer.parseInt(br.readLine());
						System.out.println("Enter total Kgs");
						double passLagguage = Double.parseDouble(br.readLine());
						Passenger pass = new Passenger();
						pass.setPassengername(passName);
						pass.setPassengerage(passAge);
						pass.setPassengeruin(passUIN);
						pass.setLuggage(passLagguage);

						Passenger passSave = passengerrepo.save(pass);
						System.out.println(passSave);
						System.out.println();
						Booking bookclass = new Booking();
						
						System.out.println("Enter your user Id to confirm booking");
						userId=Integer.parseInt(br.readLine());
						Optional<Users> use = usr.findById(userId);

						bookclass.setUserid(use.get());
						System.out.println("Select the Flight");
						int flightNo = Integer.parseInt(br.readLine());
						Optional<Flight> flight = flightrepo.findById(flightNo);
						bookclass.setFlight(flight.get());
						System.out.println("Enter a date for booking");
						String bookingData = br.readLine();
						bookclass.setBookingdate(bookingData);


						bookclass.setPassengerlist(passSave);
						bookclass.setTicketcost(5000.0d);
						bookclass.setNoofpassengers(100);
						Booking bookSave = bookrepo.save(bookclass);
						System.out.println(bookSave);
						break;

					}

					case 3: {
						// viewing booking made by the customer
						System.out.println("Enter your Booking Id to view your flight booking details");
						int bookingId = Integer.parseInt(br.readLine());
						Optional<Booking> res = bookrepo.findById(bookingId);
						System.out.println("\nYour Booking Details\n" + "Booking Id : " + res.get().getBookingid()
								+ "Flight Takeoff Date" + res.get().getBookingdate() + "\n Name : "
								+ res.get().getPassengerlist().getPassengername() + "\nOnboarding Flight Model"
								+ res.get().getFlight().getFlightmodel());
						break;

					}
					case 4: {

						// cancel or deleting the booking made by the customer
						System.out.println("Enter Booking Id to Delete the Booking Record");
						int bookDeleting = Integer.parseInt(br.readLine());
						// delete record
						bookrepo.deleteById(bookDeleting);
						System.out.println("flight Id: " + bookDeleting + " Record Deleted");
						break;

					}
					case 5: {
						System.out.println("Thankyou");
						customerloop = false;
						break;
					}

					}
				}

			}

			else {
				System.out.println("Choose Correct option");
			}

		}
	}
	catch(Exception e) {
		System.out.println("Something went Worng");
		e.printStackTrace();
		System.out.println(e.getMessage());
	}

	}

}
