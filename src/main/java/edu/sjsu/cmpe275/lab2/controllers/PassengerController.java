package edu.sjsu.cmpe275.lab2.controllers;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.XML;

import java.util.Iterator;
import java.util.List;

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

import edu.sjsu.cmpe275.lab2.dao.PassengerDao;
import edu.sjsu.cmpe275.lab2.models.Passenger;

import edu.sjsu.cmpe275.lab2.models.Reservation;

/**
 * @author amayd
 *
 */
@RestController
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	PassengerDao passDao;

	/**
	 * @param firstname
	 * @param lastname
	 * @param age
	 * @param gender
	 * @param phone
	 * @param model
	 * @return Passenger which is created
	 */
	@SuppressWarnings("finally")
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> createPassenger(@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("age") String age,
			@RequestParam("gender") String gender, @RequestParam("phone") String phone) {

		Passenger p = new Passenger();
		p.setFirstname(firstname);
		p.setLastname(lastname);
		p.setAge(Integer.parseInt(age));
		p.setGender(gender);
		p.setPhone(phone);
		
		

		try{
			Passenger p1 = passDao.createPassenger(p);
			try{
				List<Reservation> l = p.getReservations();
			
			for (Iterator<Reservation> iterator = l.iterator(); iterator.hasNext();) {
				Reservation reservation = (Reservation) iterator.next();
				reservation.setPassenger(null);
			}
			} finally {
			return ResponseEntity.ok(p1);
			}
		}
		catch(Exception e){
			HttpHeaders httpHeaders= new HttpHeaders();
			Map<String, Object> message = new HashMap<String, Object>();
			Map<String, Object> response = new HashMap<String, Object>();
			message.put("code", "400");
			message.put("msg", "another passenger with the phone number "+ phone+" already exists.");
			response.put("BadRequest", message);
			JSONObject json_test = new JSONObject(response);
			String json_resp = json_test.toString();
			
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity <String>(json_resp, httpHeaders, HttpStatus.NOT_FOUND);
		}	

	}

	/**
	 * @param id
	 * @return Passenger which is requested
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE, params = "xml=true")
	public ResponseEntity<?> getPassengerInXml(@PathVariable("id") String id) {
		Passenger p = passDao.getPassenger(id);
		HttpHeaders httpHeaders= new HttpHeaders();
		
	

		if(p!= null){
			List<Reservation> l = p.getReservations();
			for (Iterator<Reservation> iterator = l.iterator(); iterator.hasNext();) {
				Reservation reservation = (Reservation) iterator.next();
				reservation.setPassenger(null);
			}
			return ResponseEntity.ok(p);

		}else{
			Map<String, Object> message = new HashMap<String, Object>();
			Map<String, Object> response = new HashMap<String, Object>();
			message.put("code", "404");
			message.put("msg", "Sorry, the requested passenger with id: "+id+" does not exist");
			response.put("BadRequest", message);
			JSONObject json_test = new JSONObject(response);
			String json_resp = json_test.toString();
			
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity <String>(json_resp, httpHeaders, HttpStatus.NOT_FOUND);
		}	}
	
	/**
	 * @param id
	 * @return Passenger which is requested
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPassengerInJson(@PathVariable("id") String id) {
		Passenger p = passDao.getPassenger(id);
		HttpHeaders httpHeaders= new HttpHeaders();

		if(p!= null){
			List<Reservation> l = p.getReservations();
			for (Iterator<Reservation> iterator = l.iterator(); iterator.hasNext();) {
				Reservation reservation = (Reservation) iterator.next();
				reservation.setPassenger(null);
			}
			return ResponseEntity.ok(p);
		}else{
			Map<String, Object> message = new HashMap<String, Object>();
			Map<String, Object> response = new HashMap<String, Object>();
			message.put("code", "404");
			message.put("msg", "Sorry, the requested passenger with id: "+id+" does not exist");
			response.put("BadRequest", message);
			JSONObject json_test = new JSONObject(response);
			String json_resp = json_test.toString();
			
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity <String>(json_resp, httpHeaders, HttpStatus.NOT_FOUND);
		}

	}

	

	/**
	 * @param id
	 * @return 404 if no passenger found, 200 if passenger deleted
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletePassenger(@PathVariable("id") String id) {
		
		Map<String, Object> message = new HashMap<String, Object>();
		Map<String, Object> response = new HashMap<String, Object>();
		HttpHeaders httpHeaders= new HttpHeaders();
		
		if (passDao.deletePassenger(id)){
			message.put("code", "200");
			message.put("msg", "Passenger with number "+id+" is deleted successfully");
			response.put("BadRequest", message);
			JSONObject json_test = new JSONObject(response);
			String xml_resp = XML.toString(json_test);
			httpHeaders.setContentType(MediaType.APPLICATION_XML);

			return new ResponseEntity<String>(xml_resp, httpHeaders, HttpStatus.OK);
		}
		else{
			message.put("code", "404");
			message.put("msg", "Sorry, the requested passenger with number "+id+" does not exist");
			response.put("BadRequest", message);
			JSONObject json_test = new JSONObject(response);
			String json_resp = json_test.toString();
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);

			return new ResponseEntity <String>(json_resp, httpHeaders, HttpStatus.NOT_FOUND);
		}
			
	}

	/**
	 * @param id 
	 * @param firstname
	 * @param lastname
	 * @param age
	 * @param gender
	 * @param phone
	 * @param model
	 * @return Passenger which is updated
	 */
	@SuppressWarnings("finally")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> updatePassenger(@PathVariable("id") String id,
			@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
			@RequestParam("age") String age, @RequestParam("gender") String gender,
			@RequestParam("phone") String phone) {

		Passenger p = new Passenger();
		p.setId(id);
		p.setFirstname(firstname);
		p.setLastname(lastname);
		p.setAge(Integer.parseInt(age));
		p.setGender(gender);
		p.setPhone(phone);
		
		Passenger pass = passDao.getPassenger(id);
		
		if(pass!=null){
		
		try{
			Passenger p1 = passDao.updatePassenger(p);
			try{
				List<Reservation> l = p.getReservations();
			
			for (Iterator<Reservation> iterator = l.iterator(); iterator.hasNext();) {
				Reservation reservation = (Reservation) iterator.next();
				reservation.setPassenger(null);
			}
			} finally{
			return ResponseEntity.ok(p1);
			}
		}
		catch(Exception e){
			HttpHeaders httpHeaders= new HttpHeaders();
			Map<String, Object> message = new HashMap<String, Object>();
			Map<String, Object> response = new HashMap<String, Object>();
			message.put("code", "400");
			message.put("msg", "another passenger with the phone number "+ phone+" already exists.");
			response.put("BadRequest", message);
			JSONObject json_test = new JSONObject(response);
			String json_resp = json_test.toString();
			
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity <String>(json_resp, httpHeaders, HttpStatus.NOT_FOUND);
		}	
		} else {
			Map<String, Object> message = new HashMap<String, Object>();
			Map<String, Object> response = new HashMap<String, Object>();
			HttpHeaders httpHeaders= new HttpHeaders();
			
			message.put("code", "404");
			message.put("msg", "Sorry, the requested passenger with number "+id+" does not exist");
			response.put("BadRequest", message);
			JSONObject json_test = new JSONObject(response);
			String json_resp = json_test.toString();
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);

			return new ResponseEntity <String>(json_resp, httpHeaders, HttpStatus.NOT_FOUND);
		}
	}

}
