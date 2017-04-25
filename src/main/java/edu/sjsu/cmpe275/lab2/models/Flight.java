package edu.sjsu.cmpe275.lab2.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author amayd
 *
 */
@Entity
@Table(name = "flight")
public class Flight {
	
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "flightId",unique=true, nullable = false)
//	private int flightId;
	
	@Id
    @Basic(optional = false)
	@Column(name = "flightNo",unique=true, nullable = false)
	private String number; // Each flight has a unique flight number.
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "source")
	private String from;
	
	@Column(name = "destination")
	private String to;

	/*
	 * Date format: yy-mm-dd-hh, do not include minutes and sceonds. Example:
	 * 2017-03-22-19 The system only needs to supports PST.You can ignore other
	 * time zones.
	 */
	@Column(name = "departureTime")
	private Date departureTime;
	
	@Column(name = "arrivalTime")
	private Date arrivalTime;
	
	@Column(name = "seatsLeft")
	private int seatsLeft;
	
	@Column(name = "description")
	private String description;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="planeId")
	private Plane plane; // Embedded
//	private List<Passenger> passengers;

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
//		System.out.println(number);
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
//		System.out.println(price);
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
//		System.out.println(from);
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
//		System.out.println(to);
	}

	/**
	 * @return Departure time of the flight
	 */
	public String getDepartureTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
		String departure = sdf.format(departureTime);
//		System.out.println(departure);
		return departure;
	}

	/**
	 * @param departureTime
	 * @throws ParseException 
	 */
	public void setDepartureTime(String departureTime) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
		Date departure = sdf.parse(departureTime);
		
		this.departureTime = departure;
//		System.out.println(departureTime);
	}

	/**
	 * @return Arrival Time of the flight
	 */
	public String getArrivalTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
		String arrival = sdf.format(arrivalTime);
//		System.out.println(arrival);
		return arrival;
	}

	/**
	 * @param arrivalTime
	 */
	public void setArrivalTime(String arrivalTime)throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
		Date arrival = sdf.parse(arrivalTime);
		this.arrivalTime = arrival;
//		System.out.println(arrivalTime);
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
//		System.out.println(seatsLeft);
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
//		System.out.println(description);
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
//		System.out.println(this.plane.getYearOfManufacture());
	}

	/**
	 * @return List of the passengers of the flight
	 */
//	public List<Passenger> getPassengers() {
//		return passengers;
//	}
//
//	/**
//	 * @param passengers
//	 */
//	public void setPassengers(List<Passenger> passengers) {
//		this.passengers = passengers;
//	}
}
