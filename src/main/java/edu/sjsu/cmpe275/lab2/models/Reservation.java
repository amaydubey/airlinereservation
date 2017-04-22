package edu.sjsu.cmpe275.lab2.models;


import java.util.List;

/**
 * @author amayd
 *
 */
public class Reservation {
	
	private String orderNumber;
    private Passenger passenger;
    private int price; // sum of each flight’s price.
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
