package edu.sjsu.cmpe275.lab2.dao;
import edu.sjsu.cmpe275.lab2.models.Flight;

public interface FlightDao {
	
	Flight createFlight(Flight flight);

	Flight getFlight(String flightNumber);
	
	boolean deleteFlight(String flightNumber);
}
