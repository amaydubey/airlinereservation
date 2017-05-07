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
	public Passenger createPassenger(Passenger p) throws Exception {
		try {
			entityManager.persist(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Passenger getPassenger(String id) {
		Passenger p = null;
		
			p = entityManager.find(Passenger.class, id);
		
		return p;
	}

	@Override
	public boolean deletePassenger(String id) {
		Passenger p = getPassenger(id);
		if(p!=null){
			entityManager.remove(p);
		} else {
			return false;
		}
		return true;
	}

	@Override
	public Passenger updatePassenger(Passenger p) {
		Passenger p1 = getPassenger(p.getId());
		p1.setAge(p.getAge());
		p1.setFirstname(p.getFirstname());
		p1.setLastname(p.getLastname());
		p1.setGender(p.getGender());
		p1.setPhone(p.getPhone());
		try {
			if(p1!=null){
				entityManager.merge(p1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p1;
	}

}
