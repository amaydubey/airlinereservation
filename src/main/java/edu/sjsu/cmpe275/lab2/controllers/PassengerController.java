package edu.sjsu.cmpe275.lab2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
	@RequestMapping(method=RequestMethod.POST,produces={"application/json"})
	@ResponseBody
	public Passenger createPassenger(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String age, @RequestParam String gender, @RequestParam String phone, Model model){
		
		Passenger p = new Passenger();
		p.setId("12");
		p.setFirstname(firstname);
		p.setLastname(lastname);
		p.setAge(Integer.parseInt(age));
		p.setGender(gender);
		p.setPhone(phone);
		/*ApplicationContext appContext =
		    	  new ClassPathXmlApplicationContext("config/BeanLocations.xml");
		PassengerBo passBo = (PassengerBo)appContext.getBean("passengerBo");*/
		Passenger p1 = passDao.createPassenger(p);
		return p1;
	}

}
