package edu.sjsu.cmpe275.lab2.dao.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.cmpe275.lab2.dao.FlightDao;
import edu.sjsu.cmpe275.lab2.models.Flight;
import edu.sjsu.cmpe275.lab2.models.Passenger;

/**
 * @author ashay
 *
 */
@Repository
@Transactional
@Service
public class FlightDaoImpl implements FlightDao{
	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.lab2.dao.FlightDao#createFlight(edu.sjsu.cmpe275.lab2.models.Flight)
	 */
	@Override
	public Flight createFlight(Flight flight){
		try {
			entityManager.persist(flight);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flight;
	}

	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.lab2.dao.FlightDao#getFlight(java.lang.String)
	 */
	@Override
	public Flight getFlight(String flightNumber) {
		Flight flight = null;
		Passenger p;
		try {
			flight = entityManager.find(Flight.class, flightNumber);
			List<Passenger> passengerList = new ArrayList<Passenger>();
			Query query = entityManager.createQuery("SELECT passengerId FROM PassengerReservation pr WHERE pr.flightNo = :flightNumber");
			query.setParameter("flightNumber", flightNumber);
			List<?> prList = query.getResultList();
			for (Iterator<?> iterator = prList.iterator(); iterator.hasNext();) {
				String passengerId = (String) iterator.next();
				p = entityManager.find(Passenger.class, passengerId);
				System.out.println("Passenger: " + p.getFirstname());
				p.setReservations(null);
				passengerList.add(p);
			}
			flight.setPassengers(passengerList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flight;
	}

	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.lab2.dao.FlightDao#deleteFlight(java.lang.String)
	 */
	@Override
	public boolean deleteFlight(String flightNumber) {
		// TODO Auto-generated method stub
		Flight flt = getFlight(flightNumber);
		if(flt!=null){
			entityManager.remove(flt);
		} else {
			return false;
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.lab2.dao.FlightDao#updateFlight(edu.sjsu.cmpe275.lab2.models.Flight)
	 */
	@Override
	public Flight updateFlight(Flight flight) throws ParseException {
		Flight flt = getFlight(flight.getNumber());
		flt.setPrice(flight.getPrice());
		flt.setFrom(flight.getFrom());
		flt.setTo(flight.getTo());
		flt.setDepartureTime(flight.getDepartureTime());
		flt.setArrivalTime(flight.getArrivalTime());
		flt.setDescription(flight.getDescription());
		flt.setSeatsLeft(flight.getSeatsLeft());
		try {
			if(flt!=null){
				entityManager.merge(flt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flt;
	}


}
