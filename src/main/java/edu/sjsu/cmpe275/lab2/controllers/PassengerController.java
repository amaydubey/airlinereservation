package edu.sjsu.cmpe275.lab2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Passenger> createPassenger(@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("age") String age,
			@RequestParam("gender") String gender, @RequestParam("phone") String phone) {

		Passenger p = new Passenger();
		p.setFirstname(firstname);
		p.setLastname(lastname);
		p.setAge(Integer.parseInt(age));
		p.setGender(gender);
		p.setPhone(phone);
		Passenger p1 = passDao.createPassenger(p);
		return ResponseEntity.ok(p1);
	}

	/**
	 * @param id
	 * @return Passenger which is requested
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, params = "json=true")
	public ResponseEntity<Passenger> getPassengerInJson(@PathVariable("id") String id) {
		Passenger p = passDao.getPassenger(id);
		return ResponseEntity.ok(p);
	}

	/**
	 * @param id
	 * @return Passenger which is requested
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE, params = "xml")
	public ResponseEntity<Passenger> getPassengerInXml(@PathVariable("id") String id) {
		Passenger p = passDao.getPassenger(id);
		return ResponseEntity.ok(p);
	}

	/**
	 * @param id
	 * @return 404 if no passenger found, 200 if passenger deleted
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<HttpStatus> deletePassenger(@PathVariable("id") String id) {
		if (passDao.deletePassenger(id))
			return ResponseEntity.ok(HttpStatus.OK);
		else
			return ResponseEntity.ok(HttpStatus.NOT_FOUND);
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
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Passenger> updatePassenger(@PathVariable("id") String id,
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
		Passenger p1 = passDao.updatePassenger(p);
		Passenger p2 = passDao.getPassenger(p1.getId());
		System.out.println("in controller, reservation="+p2.getReservations());
		return ResponseEntity.ok(p2);
	}

}
