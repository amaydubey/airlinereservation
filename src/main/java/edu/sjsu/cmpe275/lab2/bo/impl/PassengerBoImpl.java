package edu.sjsu.cmpe275.lab2.bo.impl;

import org.springframework.stereotype.Service;

import edu.sjsu.cmpe275.lab2.bo.PassengerBo;
import edu.sjsu.cmpe275.lab2.models.Passenger;

/**
 * @author amayd
 *
 */
@Service
public class PassengerBoImpl implements PassengerBo {

	Passenger p;
	
	@Override
	public Passenger createPassenger(Passenger passenger) {
		this.p = passenger;
		return this.p;
	}

}
