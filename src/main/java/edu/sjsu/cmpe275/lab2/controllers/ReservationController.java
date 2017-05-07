package edu.sjsu.cmpe275.lab2.controllers;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.sjsu.cmpe275.lab2.dao.ReservationDao;
import edu.sjsu.cmpe275.lab2.models.Reservation;

/**
 * @author amayd
 *
 */
@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	ReservationDao resDao;

	/**
	 * @param passengerId
	 * @param flightLists
	 * @return The newly made reservation
	 */
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public ResponseEntity<Reservation> makeReservation(@RequestParam("passengerId") String passengerId,
			@RequestParam("flightLists") String flightLists) {
		Reservation r = resDao.makeReservation(passengerId, flightLists);
		return ResponseEntity.ok(r);
	}

	/**
	 * @param number 
	 * @return The requested reservation
	 */
	@RequestMapping(value = "/{number}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> getReservation(@PathVariable("number") String number) {
		Reservation r = resDao.getReservation(number);
		HttpHeaders httpHeaders= new HttpHeaders();

		if(r!= null){		
		return ResponseEntity.ok(r);
		} else{
			Map<String, Object> message = new HashMap<String, Object>();
			Map<String, Object> response = new HashMap<String, Object>();
			message.put("code", "404");
			message.put("msg", "Sorry, the requested reservation number "+number+" does not exist");
			response.put("BadRequest", message);
			JSONObject json_test = new JSONObject(response);
			String json_resp = json_test.toString();
			
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity <String>(json_resp, httpHeaders, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * @param number
	 * @param flightsAdded
	 * @param flightsRemoved
	 * @return Updated Reservation
	 */
	@RequestMapping(value = "/{number}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Reservation> updateReservation(@PathVariable("number") String number,
			@RequestParam("flightsAdded") String flightsAdded, @RequestParam("flightsRemoved") String flightsRemoved) {
		Reservation r = resDao.updateReservation(number, flightsAdded, flightsRemoved);
		return ResponseEntity.ok(r);
	}

}
