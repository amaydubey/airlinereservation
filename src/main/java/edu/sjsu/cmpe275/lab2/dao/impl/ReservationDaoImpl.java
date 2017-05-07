package edu.sjsu.cmpe275.lab2.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.cmpe275.lab2.dao.ReservationDao;
import edu.sjsu.cmpe275.lab2.models.Flight;
import edu.sjsu.cmpe275.lab2.models.Passenger;
import edu.sjsu.cmpe275.lab2.models.PassengerReservation;
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

		try {
			r = entityManager.find(Reservation.class, number);
			System.out.println("**********************Passenger:" + r.getPassenger().getId());
			System.out.println("**********************Passenger:" + r.getPassenger().getFirstname());
			System.out.println("**********************Passenger:" + r.getPassenger().getLastname());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public Reservation updateReservation(String number, String flightsAdded, String flightsRemoved) {

		Reservation r = getReservation(number);
		if (r != null) {
			int price = r.getPrice();
			String[] flightsAddedArray = flightsAdded.split(",");
			String[] flightsRemovedArray = flightsRemoved.split(",");
			Flight f = null;
			List<Flight> flightList = new ArrayList<Flight>();
			try {
				for (int i = 0; i < flightsAddedArray.length; i++) {
					f = entityManager.find(Flight.class, flightsAddedArray[i]);
					flightList.add(f);
					price += f.getPrice();
				}
				for (int i = 0; i < flightsRemovedArray.length; i++) {
					f = entityManager.find(Flight.class, flightsRemovedArray[i]);
					flightList.remove(f);
					price -= f.getPrice();
				}
				r.setFlights(flightList);
				r.setPrice(price);
				entityManager.persist(r);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return r;
		}
		return null;
	}

	@Override
	public List<Reservation> searchReservation(String passengerId, String from, String to, String flightNo) {
		List<Reservation> resList = new ArrayList<Reservation>();
		Reservation r;
		Query query = entityManager.createQuery("SELECT orderId FROM PassengerReservation pr WHERE pr.passengerId = :passengerId OR pr.source = :source OR pr.destination = :destination OR pr.flightNo = :flightNo");
		query.setParameter("passengerId", passengerId);
		query.setParameter("source", from);
		query.setParameter("destination", to);
		query.setParameter("flightNo", flightNo);
		List<?> prList = query.getResultList();
		System.out.println("PR: "+prList);
		for (Iterator<?> iterator = prList.iterator(); iterator.hasNext();) {
			String orderId = (String) iterator.next();
			r = getReservation(orderId);
			resList.add(r);
		}
		return resList;
	}

	@Override
	public boolean deleteReservation(String orderId) {
		Reservation r = getReservation(orderId);
		if(r!=null){
			entityManager.remove(r);
		} else {
			return false;
		}
		return true;
	}

}
