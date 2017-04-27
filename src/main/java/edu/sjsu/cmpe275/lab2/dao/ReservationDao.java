package edu.sjsu.cmpe275.lab2.dao;

import java.util.List;

import edu.sjsu.cmpe275.lab2.models.Flight;
import edu.sjsu.cmpe275.lab2.models.Passenger;
import edu.sjsu.cmpe275.lab2.models.Reservation;

/**
 * @author amayd
 *
 */
public interface ReservationDao {
	
	/**
	 * @param passengerId
	 * @param flightList
	 * @return newly made reservation
	 */
	public Reservation makeReservation(String passengerId, String flightList);

	/**
	 * @param number
	 * @return Reservation with the given number
	 */
	public Reservation getReservation(String number);

}
