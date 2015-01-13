package com.java.devicedao;

import com.java.model.Device;

public class TestDao {
	public static void main(String args[]) {
		try {
			Accessible a = new DeviceDao();
			Device device = new Device();
			device.setDeviceName("Samsung Galaxy V");
			device.setType("Mobile");
			device.setCompanyID(3);
			device.setColor("White");
			device.setPrice(1990000);
			
			a.insertNewDevice(device);
			System.out.format("%-30s%-10s%-10s%-10s%-10d\n",
					device.getDeviceName(), device.getType(), device.getCompanyID(),
					device.getColor(), device.getPrice());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
