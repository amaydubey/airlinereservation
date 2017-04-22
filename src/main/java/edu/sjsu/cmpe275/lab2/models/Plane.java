package edu.sjsu.cmpe275.lab2.models;

/**
 * @author amayd
 *
 */
public class Plane {
	private int capacity;
    private String model; 
    private String manufacturer;
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
	}
}
