package edu.sjsu.cmpe275.lab2.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.cmpe275.lab2.dao.PassengerDao;
import edu.sjsu.cmpe275.lab2.models.Passenger;

/**
 * @author amayd
 *
 */
@Repository
@Transactional
@Service
public class PassengerDaoImpl implements PassengerDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Passenger createPassenger(Passenger passenger) {
		entityManager.persist(passenger);
		return passenger;
	}

}
