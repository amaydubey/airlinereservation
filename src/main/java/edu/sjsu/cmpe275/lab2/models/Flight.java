package edu.sjsu.cmpe275.lab2.models;

import java.util.Date;
import java.util.List;

/**
 * @author amayd
 *
 */
public class Flight {
	private String number; // Each flight has a unique flight number.
	private int price;
	private String from;
	private String to;

	/*
	 * Date format: yy-mm-dd-hh, do not include minutes and sceonds. Example:
	 * 2017-03-22-19 The system only needs to supports PST.You can ignore other
	 * time zones.
	 */
	private Date departureTime;
	private Date arrivalTime;
	private int seatsLeft;
	private String description;
	private Plane plane; // Embedded
	private List<Passenger> passengers;

	/**
	 * @return No of the flight
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return Price of the flight
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return Source of the flight
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return Destination of the flight
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return Departure time of the flight
	 */
	public Date getDepartureTime() {
		return departureTime;
	}

	/**
	 * @param departureTime
	 */
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	/**
	 * @return Arrival Time of the flight
	 */
	public Date getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @param arrivalTime
	 */
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * @return No of seats left on the flight
	 */
	public int getSeatsLeft() {
		return seatsLeft;
	}

	/**
	 * @param seatsLeft
	 */
	public void setSeatsLeft(int seatsLeft) {
		this.seatsLeft = seatsLeft;
	}

	/**
	 * @return Description of the flight
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return Plane of the flight
	 */
	public Plane getPlane() {
		return plane;
	}

	/**
	 * @param plane
	 */
	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	/**
	 * @return List of the passengers of the flight
	 */
	public List<Passenger> getPassengers() {
		return passengers;
	}

	/**
	 * @param passengers
	 */
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
}
