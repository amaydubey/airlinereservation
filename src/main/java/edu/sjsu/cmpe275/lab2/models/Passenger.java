package edu.sjsu.cmpe275.lab2.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author amayd
 *
 */
@Entity
@Table(name = "passenger")
public class Passenger {

	@Id
	@Column(name = "passengerId")
	private String id;
	@Column(name = "firstName")
	private String firstname;
	@Column(name = "lastName")
	private String lastname;
	@Column(name = "age")
	private int age;
	@Column(name = "gender")
	private String gender;
	@Column(name = "phone")
	private String phone; // Phone numbers must be unique

	/**
	 * @return Id of the passenger
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return first name of the passenger
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 * 
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return last name of the passenger
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 * 
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return age of the passenger
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 * 
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return gender of the passenger
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 * 
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return phone of the passenger
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
