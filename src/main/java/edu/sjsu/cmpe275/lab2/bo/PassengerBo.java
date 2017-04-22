/**
 * 
 */
package edu.sjsu.cmpe275.lab2.bo;

import edu.sjsu.cmpe275.lab2.models.Passenger;

/**
 * @author amayd
 *
 */
public interface PassengerBo {
	
	/**
	 * @param passenger
	 * @return Newly created passenger
	 */
	Passenger createPassenger(Passenger passenger);

}
