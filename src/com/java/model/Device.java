package com.java.model;

public class Device {
	
	// attributes of class Device
	private int deviceID;
	private String deviceName;
	private String type;
	private int companyID;
	private String color;
	private int price;
	private String message;
	
	// Define Device constructor
	public Device() {}
	
	public Device(int newDeviceID, String newDeviceName, String newType, int newCompanyID,
		String newColor, int newPrice) {
		this.setDeviceID(deviceID);
		this.setDeviceName(deviceName);
		this.setType(type);
		this.setCompanyID(newCompanyID);
		this.setColor(newColor);
		this.setPrice(newPrice);
	}
	
	// Define getters and setters
	/**
	 * @return the deviceID
	 */
	public int getDeviceID() {
		return deviceID;
	}
	/**
	 * @param deviceID the deviceID to set
	 */
	public void setDeviceID(int deviceID) {
		this.deviceID = deviceID;
	}
	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}
	/**
	 * @param deviceName the deviceName to set
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the companyID
	 */
	public int getCompanyID() {
		return companyID;
	}
	/**
	 * @param companyID the companyID to set
	 */
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
