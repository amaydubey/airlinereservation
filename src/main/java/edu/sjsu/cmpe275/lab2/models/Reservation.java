package edu.sjsu.cmpe275.lab2.models;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author amayd
 *
 */
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property="orderNumber")
@Entity
@Table(name="reservation")
public class Reservation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "orderId", unique = true, nullable = false)
	private String orderNumber;

	@ManyToOne
	@JoinColumn(name="passengerId")
	@JsonBackReference
	private Passenger passenger;

	@Column(name = "price")
	private int price; // sum of each flight’s price.

	@ManyToMany
	@JoinTable(name="reservation_flight", joinColumns = {
            @JoinColumn(name = "reservationId", referencedColumnName = "orderId") }, inverseJoinColumns = {
            @JoinColumn(name = "flightId") })
	private List<Flight> flights;

	/**
	 * @return Order no of the reservation
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param orderNumber
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * @return Passenger on the reservation
	 */
	public Passenger getPassenger() {
		return passenger;
	}

	/**
	 * @param passenger
	 */
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	/**
	 * @return Price of the reservation
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
	 * @return List of flights in the reservation
	 */
	public List<Flight> getFlights() {
		return flights;
	}

	/**
	 * @param flights
	 */
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

}
