package com.java.devicedao;

import java.sql.SQLException;
import java.util.List;

import com.java.bean.DeviceInfoBean;
import com.java.model.Device;

public interface Accessible {
	public List<Device> viewAllDevices() throws SQLException, ClassNotFoundException;
	public DeviceInfoBean viewDeviceDetails(int id) throws SQLException, ClassNotFoundException;
	public void insertNewDevice(Device newDevice) throws SQLException, ClassNotFoundException;
	public Device updateDevice(Device deviceToUpdate) throws SQLException, ClassNotFoundException ;
	public Device SearchDevice() throws SQLException, ClassNotFoundException; 
	public void writeLog();
	
}