package edu.sjsu.cmpe275.lab2.dao;

import java.util.List;

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

	/**
	 * @param number
	 * @param flightsAdded
	 * @param flightsRemoved
	 * @return Updated Reservation
	 */
	public Reservation updateReservation(String number, String flightsAdded, String flightsRemoved);
	
	/**
	 * @param passengerId
	 * @param from
	 * @param to
	 * @param flightNo
	 * @return A list of reservations with the provided attributes
	 */
	public List<Reservation> searchReservationByPassenger(String passengerId, String from, String to, String flightNo);

}
