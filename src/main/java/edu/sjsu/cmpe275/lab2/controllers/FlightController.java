package edu.sjsu.cmpe275.lab2.controllers;

import java.text.*;


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

import edu.sjsu.cmpe275.lab2.dao.FlightDao;
import edu.sjsu.cmpe275.lab2.models.Flight;
import edu.sjsu.cmpe275.lab2.models.Plane;

@RestController
@RequestMapping("/flight")
public class FlightController {
	@Autowired
	FlightDao fltDao;
	
	
	
	/**
	 * @param flightNumber
	 * @param price
	 * @param from
	 * @param to
	 * @param departureTime
	 * @param arrivalTime
	 * @param description
	 * @param capacity
	 * @param model
	 * @param manufacturer
	 * @param yearOfManufacture
	 * @return flight object
	 * @throws ParseException
	 */
	@RequestMapping(value = "/{flightNumber}", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public ResponseEntity<Flight> createFlight(
			@PathVariable String flightNumber,
			@RequestParam("price") int price,
			@RequestParam("from") String from, 
			@RequestParam("to") String to,
			@RequestParam("departureTime") String departureTime, 
			@RequestParam("arrivalTime") String arrivalTime,
			@RequestParam("description") String description, 
			@RequestParam("capacity") int capacity,
			@RequestParam("model") String model, 
			@RequestParam("manufacturer") String manufacturer,
			@RequestParam("yearOfManufacture") int yearOfManufacture) throws ParseException {

		
		
		Flight f = new Flight();
		Plane p = new Plane();
		
		f.setNumber(flightNumber);
		f.setPrice(price);
		f.setFrom(from);
		f.setTo(to);
		f.setDepartureTime(departureTime);
		f.setArrivalTime(arrivalTime);
		f.setDescription(description);
		f.setSeatsLeft(10);
		
		
		p.setCapacity(capacity);
		p.setModel(model);
		p.setManufacturer(manufacturer);
		p.setYearOfManufacture(yearOfManufacture);
		
		f.setPlane(p);
		
		Flight flight = fltDao.getFlight(flightNumber);
		if(flight == null){
			Flight flt = fltDao.createFlight(f);
			return ResponseEntity.ok(flt);
		} else{
			Flight flt = fltDao.updateFlight(f);
			return ResponseEntity.ok(flt);
		}
		
		
	}	

	/**
	 * @param flightNumber
	 * @return get flight with planes and passengers in XML
	 */
	@RequestMapping(value = "/{flightNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE, params = "xml")
	public ResponseEntity<Flight> getFlightInXml(@PathVariable("flightNumber") String flightNumber) {
		Flight flt = fltDao.getFlight(flightNumber);
		return ResponseEntity.ok(flt);
		
	}
	
	
	/**
	 * @param flightNumber
	 * @return get flight with planes and passengers in JSON 
	 */
	@RequestMapping(value = "/{flightNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, params = "json")
	public ResponseEntity<Flight> getFlightInJson(@PathVariable("flightNumber") String flightNumber) {
		Flight flt = fltDao.getFlight(flightNumber);
		return ResponseEntity.ok(flt);
		
	}
	
	/**
	 * @param flightNumber
	 * @return delete confirmation
	 */
	@RequestMapping(value = "/{flightNumber}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletePassenger(@PathVariable("flightNumber") String flightNumber) {
		HttpHeaders httpHeaders= new HttpHeaders();
		if (fltDao.deleteFlight(flightNumber)){
			httpHeaders.setContentType(MediaType.APPLICATION_XML);
			String resp = "<Response> <code> 200 </code> <msg> Flight with number "+flightNumber+" is deleted successfully  </msg> </Response>";
			return new ResponseEntity<String>(resp, httpHeaders, HttpStatus.OK);
			
			
			

		}
		else{
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);

			String response = "{\"BadRequest\": {\"code\": \"404\" , \"msg\" : \"Flight number not found\" } }";
			return new ResponseEntity<String>(response, httpHeaders, HttpStatus.NOT_FOUND);

		}
	}

		


}
