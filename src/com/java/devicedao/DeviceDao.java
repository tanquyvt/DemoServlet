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
	public List<Device> viewAllDevices() throws SQLException, ClassNotFoundException {
		
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
			newDevice.setDeviceName((String)rs.getObject(2));
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
	public void insertNewDevice(Device newDevice) throws SQLException, ClassNotFoundException{

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		// Open database
		newDBUtil.openDatabase();
		
		// Insert a new device
		newDBUtil.initiateInsertTable(newDevice);
		
		// Close database
		newDBUtil.closeDatabase();
	}

	@Override
	public Device updateDevice(Device deviceToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Device SearchDevice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeLog() {
		// TODO Auto-generated method stub

	}

}
