package edu.sjsu.cmpe275.lab2.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.cmpe275.lab2.dao.ReservationDao;
import edu.sjsu.cmpe275.lab2.models.Flight;
import edu.sjsu.cmpe275.lab2.models.Passenger;
import edu.sjsu.cmpe275.lab2.models.Reservation;

/**
 * @author amayd
 *
 */
@Repository
@Transactional
@Service
public class ReservationDaoImpl implements ReservationDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Reservation makeReservation(String passengerId, String flightLists) {
		Flight f = null;
		Passenger p = null;
		int price = 0;
		Reservation r = new Reservation();
		String[] flightArray = flightLists.split(",");
		List<Flight> flightList = new ArrayList<Flight>();
		try {
			for (int i = 0; i < flightArray.length; i++) {
				f = entityManager.find(Flight.class, flightArray[i]);
				flightList.add(f);
				price += f.getPrice();
			}
			p = entityManager.find(Passenger.class, passengerId);
			r.setFlights(flightList);
			r.setPrice(price);
			r.setPassenger(p);
			entityManager.persist(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public Reservation getReservation(String number) {
		Reservation r = null;
		
		try{
			r = entityManager.find(Reservation.class, number);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

}
