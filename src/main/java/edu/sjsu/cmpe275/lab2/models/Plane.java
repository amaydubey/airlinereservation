package edu.sjsu.cmpe275.lab2.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author ashay
 *
 */
@Embeddable
public class Plane {

	
	@Column(name = "capacity")
	private int capacity;
	
	@Column(name = "model")
    private String model; 
	
	@Column(name = "manufacturer")
    private String manufacturer;
	
	@Column(name = "yearOfManufacture")
    private int yearOfManufacture;
    
	/**
	 * @return Capacity of the plane
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
//		System.out.println(capacity);
	}
	/**
	 * @return Model of the plane
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model
	 */
	public void setModel(String model) {
		this.model = model;
//		System.out.println(model);
	}
	/**
	 * @return Manufacturer of the plane
	 */
	public String getManufacturer() {
		return manufacturer;
	}
	/**
	 * @param manufacturer
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
//		System.out.println(manufacturer);
	}
	/**
	 * @return Year of Mfg of the plane
	 */
	public int getYearOfManufacture() {
		return yearOfManufacture;
	}
	/**
	 * @param yearOfManufacture
	 */
	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
//		System.out.println(yearOfManufacture);
	}
}
