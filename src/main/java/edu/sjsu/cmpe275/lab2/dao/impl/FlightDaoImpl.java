package edu.sjsu.cmpe275.lab2.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.cmpe275.lab2.dao.FlightDao;
import edu.sjsu.cmpe275.lab2.models.Flight;

@Repository
@Transactional
@Service
public class FlightDaoImpl implements FlightDao{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Flight createFlight(Flight flight){
		try {
			entityManager.persist(flight);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flight;
	}

	@Override
	public Flight getFlight(String flightNumber) {
		// TODO Auto-generated method stub
		Flight flight = null;
		try {
			flight = entityManager.find(Flight.class, flightNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flight;
	}

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


}
