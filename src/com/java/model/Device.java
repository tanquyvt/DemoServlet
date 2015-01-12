package com.java.model;

public abstract class Device {
	
	// attributes of class Device
	public int deviceID;
	public String deviceName;
	public String type;
	public String companyID;
	public String color;
	public int price;
	
	public void viewInfo() {
		System.out.format("%-10d", deviceID);
		System.out.format("%-30s", deviceName);
		System.out.format("%-10s", type);
		System.out.format("%-10s", companyID);
		System.out.format("%-10s", color);
		System.out.format("%-10d", price);
		System.out.println("\n");
	}
}
