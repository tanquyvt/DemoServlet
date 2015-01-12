package com.java.model;

public final class Mobile extends Device {
	
	// Mobile Constructor definition
	public Mobile(String newName, String newCompanyID, String newColor, int newPrice) {
		
		// Input the values to Mobile attributes
		this.deviceName = newName;
		this.type = "Mobile";
		this.companyID = newCompanyID;
		this.color = newColor;
		this.price = newPrice;
	}
}
