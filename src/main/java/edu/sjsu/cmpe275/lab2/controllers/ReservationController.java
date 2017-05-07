package edu.sjsu.cmpe275.lab2.controllers;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.sjsu.cmpe275.lab2.dao.ReservationDao;
import edu.sjsu.cmpe275.lab2.models.Reservation;

/**
 * @author amayd
 *
 */
@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	ReservationDao resDao;

	/**
	 * @param passengerId
	 * @param flightLists
	 * @return The newly made reservation
	 */
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public ResponseEntity<Reservation> makeReservation(@RequestParam("passengerId") String passengerId,
			@RequestParam("flightLists") String flightLists) {
		Reservation r = resDao.makeReservation(passengerId, flightLists);
		r.getPassenger().setReservations(null);
		return ResponseEntity.ok(r);
	}

	/**
	 * @param number 
	 * @return The requested reservation
	 */
	@RequestMapping(value = "/{number}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Reservation> getReservation(@PathVariable("number") String number) {
		Reservation r = resDao.getReservation(number);
		System.out.println("********Passenger in controller: " + r.getPassenger().getFirstname());
		r.getPassenger().setReservations(null);
		return ResponseEntity.ok(r);
	}

	/**
	 * @param number
	 * @param flightsAdded
	 * @param flightsRemoved
	 * @return Updated Reservation
	 */
	@RequestMapping(value = "/{number}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Reservation> updateReservation(@PathVariable("number") String number,
			@RequestParam("flightsAdded") String flightsAdded, @RequestParam("flightsRemoved") String flightsRemoved) {
		Reservation r = resDao.updateReservation(number, flightsAdded, flightsRemoved);
		r.getPassenger().setReservations(null);
		return ResponseEntity.ok(r);
	}
	
	/**
	 * @param passengerId
	 * @param from
	 * @param to
	 * @param flightNumber
	 * @return List of flights matching the criteria
	 */
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public ResponseEntity<List<Reservation>> searchReservation(@RequestParam("passengerId") String passengerId, @RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("flightNumber") String flightNumber) {
		List<Reservation> r = resDao.searchReservation(passengerId, from, to, flightNumber);
		return ResponseEntity.ok(r);
	}

}
