package com.java.model;

public class Tablet extends Device {
	
	// Tablet Constructor definition
	public Tablet(String newName, String newCompanyID, String newColor, int newPrice) {

		// Input the values to Tablet attributes
		this.deviceName = newName;
		this.type = "Tablet";
		this.companyID = newCompanyID;
		this.color = newColor;
		this.price = newPrice;
	}
}
