package edu.sjsu.cmpe275.lab2.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author amayd
 *
 */
@Entity
@Table(name = "passenger_reservation")
public class PassengerReservation {

	@Id
	@Column(name = "passengerId", unique=false, nullable = false)
	private String passengerId;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "orderId")
	private String orderId;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "flightNo")
	private String flightNo;
	
	@Column(name = "flight_price")
	private String flight_price;
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "destination")
	private String destination;
	
	@Column(name = "departureTime")
	private Date departureTime;
	
	@Column(name = "arrivalTime")
	private Date arrivalTime;
	
	@Column(name = "seatsLeft")
	private int seatsLeft;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "capacity")
	private int capacity;
	
	@Column(name = "manufacturer")
	private String manufacturer;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "yearOfManufacture")
	private String yearOfManufacture;

	/**
	 * @return passengerId
	 */
	public String getPassengerId() {
		return passengerId;
	}

	/**
	 * @param passengerId
	 */
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getFlight_price() {
		return flight_price;
	}

	public void setFlight_price(String flight_price) {
		this.flight_price = flight_price;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getSeatsLeft() {
		return seatsLeft;
	}

	public void setSeatsLeft(int seatsLeft) {
		this.seatsLeft = seatsLeft;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(String yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}
}
