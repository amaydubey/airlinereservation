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
	
	/**
	 * @param id
	 * @return Requested Passenger
	 */
	Passenger getPassenger(String id);

	/**
	 * @param id
	 * @return True if passenger is deleted
	 */
	boolean deletePassenger(String id);

	/**
	 * @param p
	 * @return Updated passenger
	 */
	Passenger updatePassenger(Passenger p);

}
