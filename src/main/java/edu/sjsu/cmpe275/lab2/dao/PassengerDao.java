/**
 * 
 */
package edu.sjsu.cmpe275.lab2.dao;

import edu.sjsu.cmpe275.lab2.models.Passenger;

/**
 * @author amayd
 *
 */
public interface PassengerDao {
	
	/**
	 * @param passenger
	 * @return Newly created passenger
	 */
	Passenger createPassenger(Passenger passenger);

}
