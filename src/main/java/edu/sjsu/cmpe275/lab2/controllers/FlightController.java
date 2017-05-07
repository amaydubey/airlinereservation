package edu.sjsu.cmpe275.lab2.controllers;

import java.text.*;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.XML;
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
	@RequestMapping(value = "/{flightNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE, params = "xml=true")
	public ResponseEntity<?> getFlightInXml(@PathVariable("flightNumber") String flightNumber) {
		Flight flt = fltDao.getFlight(flightNumber);
		HttpHeaders httpHeaders= new HttpHeaders();
		
		if(flt!= null){
			return ResponseEntity.ok(flt);
			} else{
				Map<String, Object> message = new HashMap<String, Object>();
				Map<String, Object> response = new HashMap<String, Object>();
				message.put("code", "404");
				message.put("msg", "Sorry, the requested flight with number "+flightNumber+" does not exist");
				response.put("BadRequest", message);
				JSONObject json_test = new JSONObject(response);
				String json_resp = json_test.toString();
				
				httpHeaders.setContentType(MediaType.APPLICATION_JSON);
				return new ResponseEntity <String>(json_resp, httpHeaders, HttpStatus.NOT_FOUND);
			}
	}
	
	
	/**
	 * @param flightNumber
	 * @return get flight with planes and passengers in JSON 
	 */
	@RequestMapping(value = "/{flightNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getFlightInJson(@PathVariable("flightNumber") String flightNumber) {
		Flight flt = fltDao.getFlight(flightNumber);
		HttpHeaders httpHeaders= new HttpHeaders();
		
		if(flt!= null){
			return ResponseEntity.ok(flt);
			} else{
				Map<String, Object> message = new HashMap<String, Object>();
				Map<String, Object> response = new HashMap<String, Object>();
				message.put("code", "404");
				message.put("msg", "Sorry, the requested flight with number "+flightNumber+" does not exist");
				response.put("BadRequest", message);
				JSONObject json_test = new JSONObject(response);
				String json_resp = json_test.toString();
				
				httpHeaders.setContentType(MediaType.APPLICATION_JSON);
				return new ResponseEntity <String>(json_resp, httpHeaders, HttpStatus.NOT_FOUND);
			}
	}
	
	/**
	 * @param flightNumber
	 * @return delete confirmation
	 */
	@RequestMapping(value = "/{flightNumber}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletePassenger(@PathVariable("flightNumber") String flightNumber) {
		
		HttpHeaders httpHeaders= new HttpHeaders();
		Map<String, Object> message = new HashMap<String, Object>();
		Map<String, Object> response = new HashMap<String, Object>();
		
		if (fltDao.deleteFlight(flightNumber)){
			message.put("code", "200");
			message.put("msg", "Passenger with number "+flightNumber+" is deleted successfully");
			response.put("BadRequest", message);
			JSONObject json_test = new JSONObject(response);
			String xml_resp = XML.toString(json_test);
			httpHeaders.setContentType(MediaType.APPLICATION_XML);

			return new ResponseEntity<String>(xml_resp, httpHeaders, HttpStatus.OK);
			
			
		}
		else{
			message.put("code", "404");
			message.put("msg", "Sorry, the requested flight with number "+flightNumber+" does not exist");
			response.put("BadRequest", message);
			JSONObject json_test = new JSONObject(response);
			String json_resp = json_test.toString();
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);

			return new ResponseEntity <String>(json_resp, httpHeaders, HttpStatus.NOT_FOUND);
			
		}
	}

		


}
