package com.java.devicedao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.bean.DeviceInfoBean;
import com.java.dbutil.DatabaseUtility;
import com.java.model.Device;

public class DeviceDao implements Accessible {

	@Override
	public List<Device> viewAllDevices() throws SQLException,
			ClassNotFoundException {

		// Initiate result list of devices
		List<Device> devices = new ArrayList<Device>();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		// Open database
		newDBUtil.openDatabase();

		// Initiate the result set for viewing all the devices
		ResultSet rs = newDBUtil.initiateViewAll();

		// Store the information of devices to device list
		while (rs.next()) {
			Device newDevice = new Device();
			newDevice.setDeviceID(Integer.parseInt(rs.getObject(1).toString()));
			newDevice.setDeviceName((String) rs.getObject(2));
			devices.add(newDevice);
		}

		// Close database
		newDBUtil.closeDatabase();

		// return the device list
		return devices;
	}

	@Override
	public DeviceInfoBean viewDeviceDetails(int id) throws SQLException, ClassNotFoundException {

		// Initiate a list containing all the infomation of device
		DeviceInfoBean deviceInfo = new DeviceInfoBean();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		// Open database
		newDBUtil.openDatabase();

		// Initiate the result set for
		// viewing details of a specific device
		ResultSet rs = newDBUtil.initiateViewDetails(id);

		// Get values of the specific device
		rs.next();
		deviceInfo.setDeviceID(Integer.parseInt(rs.getObject(1).toString()));
		deviceInfo.setDeviceName(rs.getObject(2).toString());
		deviceInfo.setType(rs.getObject(3).toString());
		deviceInfo.setCompanyName(rs.getObject(4).toString());
		deviceInfo.setCountry(rs.getObject(5).toString());
		deviceInfo.setColor(rs.getObject(6).toString());
		deviceInfo.setPrice(Integer.parseInt(rs.getObject(7).toString()));

		// Close database
		newDBUtil.closeDatabase();

		return deviceInfo;
	}

	@Override
	public Device insertNewDevice(Device newDevice) throws SQLException,
			ClassNotFoundException {

		// Initiate result device
		Device insertedDevice = new Device();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		// Open database
		newDBUtil.openDatabase();

		// Create the result set for
		// inserting a new device
		ResultSet rs = newDBUtil.initiateInsertTable(newDevice);

		rs.next();
		insertedDevice.setDeviceID(Integer.parseInt(rs.getObject(1).toString()));
		insertedDevice.setDeviceName(newDevice.getDeviceName());
		insertedDevice.setType(newDevice.getType());
		insertedDevice.setCompanyID(newDevice.getCompanyID());
		insertedDevice.setColor(newDevice.getColor());
		insertedDevice.setPrice(newDevice.getPrice());

		// Close database
		newDBUtil.closeDatabase();

		return insertedDevice;
	}

	@Override
	public Device updateDevice(int id, String updateField, String updateValue) 
			throws SQLException, ClassNotFoundException {

		// Initiate update device
		Device device = new Device();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		// Open database
		newDBUtil.openDatabase();
		
		// Create result set for
		// updating the old device
		ResultSet rs = newDBUtil.initiateUpdateTable(id, updateField, updateValue);
		
		// Get the updated device
		rs.next();
		device.setDeviceID(Integer.parseInt(rs.getObject(1).toString()));
		device.setDeviceName(rs.getObject(2).toString());
		device.setType(rs.getObject(3).toString());
		device.setCompanyID(Integer.parseInt(rs.getObject(4).toString()));
		device.setColor(rs.getObject(5).toString());
		device.setPrice(Integer.parseInt(rs.getObject(6).toString()));

		// Close database
		newDBUtil.closeDatabase();

		return device;
	}

	@Override
	public List<DeviceInfoBean> SearchDevice(String tableField, String stringToSearch)
			throws SQLException, ClassNotFoundException {
		// Initiate result list of devices
		List<DeviceInfoBean> devices = new ArrayList<DeviceInfoBean>();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		// Open database
		newDBUtil.openDatabase();

		// Initiate the result set for viewing all the devices
		ResultSet rs = newDBUtil
				.initiateSearchTable(tableField, stringToSearch);

		while (rs.next()) {
			DeviceInfoBean deviceInfo = new DeviceInfoBean();
			deviceInfo.setDeviceID(Integer.parseInt(rs.getObject(1).toString()));
			deviceInfo.setDeviceName(rs.getObject(2).toString());
			deviceInfo.setType(rs.getObject(3).toString());
			deviceInfo.setCompanyName(rs.getObject(4).toString());
			deviceInfo.setCountry(rs.getObject(5).toString());
			deviceInfo.setColor(rs.getObject(6).toString());
			deviceInfo.setPrice(Integer.parseInt(rs.getObject(7).toString()));
			devices.add(deviceInfo);
		}

		return devices;
	}

	@Override
	public List<DeviceInfoBean> SearchDeviceByPrice(int lowerPrice, int upperPrice)
			throws SQLException, ClassNotFoundException {
		// Initiate result list of devices
		List<DeviceInfoBean> devices = new ArrayList<DeviceInfoBean>();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		// Open database
		newDBUtil.openDatabase();

		// Initiate the result set for viewing all the devices
		ResultSet rs = newDBUtil.initiateSearchTable(lowerPrice, upperPrice);

		while (rs.next()) {
			DeviceInfoBean deviceInfo = new DeviceInfoBean();
			deviceInfo.setDeviceID(Integer.parseInt(rs.getObject(1).toString()));
			deviceInfo.setDeviceName(rs.getObject(2).toString());
			deviceInfo.setType(rs.getObject(3).toString());
			deviceInfo.setCompanyName(rs.getObject(4).toString());
			deviceInfo.setCountry(rs.getObject(5).toString());
			deviceInfo.setColor(rs.getObject(6).toString());
			deviceInfo.setPrice(Integer.parseInt(rs.getObject(7).toString()));
			devices.add(deviceInfo);
		}

		return devices;
	}

	@Override
	public void writeLog() {
		// TODO Auto-generated method stub

	}

}
