package com.java.devicedao;

import com.java.model.Device;

public class TestDao {
	public static void main(String args[]) {
		try {
			Accessible a = new DeviceDao();
			Device device = new Device();
			device.setDeviceName("Samsung Galaxy V");
			device.setType("Mobile");
			device.setCompanyID(0003);
			device.setColor("White");
			device.setPrice(1990000);
			Device result = new Device();
			
			result = a.insertNewDevice(device);
			System.out.format("%-5d%-30s%-10s%-10s%-10s%-10d\n",
					result.getDeviceID(), result.getDeviceName(), result.getType(),
					result.getCompanyID(), result.getColor(), result.getPrice());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
