package edu.sjsu.cmpe275.lab2.dao;
import edu.sjsu.cmpe275.lab2.models.Flight;

public interface FlightDao {
	
	/**
	 * @param flight
	 * @return
	 */
	Flight createFlight(Flight flight);

	/**
	 * @param flightNumber
	 * @return
	 */
	Flight getFlight(String flightNumber);
	
	/**
	 * @param flightNumber
	 * @return
	 */
	boolean deleteFlight(String flightNumber);
}
