package com.java.model;

public class Laptop extends Device {
	
	// Laptop Constructor definition
	public Laptop(String newName, String newCompanyID, String newColor, int newPrice) {
		
		// Input values to Laptop attributes
		this.deviceName = newName;
		this.type = "Laptop";
		this.companyID = newCompanyID;
		this.color = newColor;
		this.price = newPrice;
	}
}
