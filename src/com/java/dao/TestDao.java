package com.java.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.java.bean.DeviceInfoBean;
import com.java.dbutil.DBNameConstant;
import com.java.model.Device;

public class TestDao {
	
	public static void testViewAll() {
		try {
			InterfaceDeviceDao a = new DeviceDao();
			List<Device> list = new ArrayList<Device>();
			list.addAll(a.viewAllDevices());
			Iterator<Device> iCom = list.iterator();
			while (iCom.hasNext()) {
				Device dev = iCom.next();
				System.out.format("%-5d%-10s\n", dev.getDeviceID(),
						dev.getDeviceName());
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void testViewDetails() {
		try {
			InterfaceDeviceDao a = new DeviceDao();
			DeviceInfoBean device = new DeviceInfoBean();
			device = a.viewDeviceDetails(10);
			System.out.format("%-5d%-30s%-10s%-10s%-10s%-10s%-10d",
					device.getDeviceID(), device.getDeviceName(), device.getType(),
					device.getCompanyName(), device.getCountry(), device.getColor(),
					device.getPrice());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void testInsertDevice() {
		try {
			InterfaceDeviceDao a = new DeviceDao();
			Device device = new Device(
					1, "iPhone 4s 64GB", "Mobile", 1, "Silver", 8990000);
			Device result = new Device();
			result = a.insertNewDevice(device);
			System.out.format("%-5d%-30s%-10s%-5d%-10s%-10d",
					result.getDeviceID(), result.getDeviceName(), result.getType(),
					result.getCompanyID(), result.getColor(), result.getPrice());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void testUpdateDevice() {
		try {
			InterfaceDeviceDao a = new DeviceDao();
			Device device = new Device(
					0, "iPhone 4s 64GB", "Mobile", 1, "Silver", 8990000);
			DeviceInfoBean result = new DeviceInfoBean();
			result = a.updateDevice(1, device);
			System.out.format("%-5d%-30s%-10s%-10s%-10s%-10s%-10d",
					result.getDeviceID(), result.getDeviceName(), result.getType(),
					result.getCompanyName(), result.getCountry(), result.getColor(),
					result.getPrice());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void testDeleteDevice() {
		try {
			InterfaceDeviceDao a = new DeviceDao();
			a.deleteDevice(1);
			System.out.println("Delete successful!");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void testSearchByPrice() {
		try {
			InterfaceDeviceDao a = new DeviceDao();
			List<DeviceInfoBean> list = new ArrayList<DeviceInfoBean>();
			list.addAll(a.searchDeviceByPrice(0, 10000000));
			Iterator<DeviceInfoBean> iDev = list.iterator();
			while (iDev.hasNext()) {
				DeviceInfoBean result = iDev.next();
				System.out.format("%-5d%-35s%-10s%-10s%-10s%-10s%10d\n",
						result.getDeviceID(), result.getDeviceName(), result.getType(),
						result.getCompanyName(), result.getCountry(), result.getColor(),
						result.getPrice());
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void testSearchDevice() {
		try {
			InterfaceDeviceDao a = new DeviceDao();
			List<DeviceInfoBean> list = new ArrayList<DeviceInfoBean>();
			list.addAll(a.searchDevice(DBNameConstant.COLOR, "pink"));
			Iterator<DeviceInfoBean> iDev = list.iterator();
			while (iDev.hasNext()) {
				DeviceInfoBean result = iDev.next();
				System.out.format("%-5d%-35s%-10s%-10s%-10s%-10s%10d\n",
						result.getDeviceID(), result.getDeviceName(), result.getType(),
						result.getCompanyName(), result.getCountry(), result.getColor(),
						result.getPrice());
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		TestDao.testSearchDevice();
	}
}
