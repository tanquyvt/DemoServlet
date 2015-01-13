package com.java.devicedao;

import java.sql.SQLException;
import java.util.List;

import com.java.bean.DeviceInfoBean;
import com.java.model.Device;

public interface Accessible {
	public List<Device> viewAllDevices()
			throws SQLException, ClassNotFoundException;
	public DeviceInfoBean viewDeviceDetails(int id)
			throws SQLException, ClassNotFoundException;
	public Device insertNewDevice(Device newDevice)
			throws SQLException, ClassNotFoundException;
	public Device updateDevice(int id, String updateField, String updateValue)
			throws SQLException, ClassNotFoundException ;
	public List<DeviceInfoBean> SearchDevice(String tableField, String stringToSearch)
			throws SQLException, ClassNotFoundException; 
	public List<DeviceInfoBean> SearchDeviceByPrice(int lowerPrice, int upperPrice)
			throws SQLException, ClassNotFoundException; 
	public void writeLog();
}