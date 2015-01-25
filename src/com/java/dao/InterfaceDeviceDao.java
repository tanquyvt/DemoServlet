package com.java.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.bean.DeviceInfoBean;
import com.java.bean.DeviceTypeBean;
import com.java.model.Device;

public interface InterfaceDeviceDao {
	
	/**
	 * View all devices method
	 * @return List<Device>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Device> viewAllDevices()
			throws SQLException, ClassNotFoundException;
	
	/**
	 * View device's details method
	 * @param id
	 * @return DeviceInfoBean
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public DeviceInfoBean viewDeviceDetails(int id)
			throws SQLException, ClassNotFoundException;
	
	/**
	 * View all device's types
	 * @return List<String>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<String> viewType() throws SQLException, ClassNotFoundException;
	
	/**
	 * Insert new device method
	 * @param newDevice
	 * @return Device
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public DeviceInfoBean insertNewDevice(Device newDevice)
			throws SQLException, ClassNotFoundException;
	
	/**
	 * Update device's information
	 * @param id
	 * @param updateField
	 * @param updateValue
	 * @return DeviceInfoBean
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public DeviceInfoBean updateDevice(int id, Device updateDevice)
			throws SQLException, ClassNotFoundException ;
	
	/**
	 * Search device(s)
	 * @param tableField
	 * @param stringToSearch
	 * @return List<DeviceInfoBean>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Device> searchDevice(String tableField, String stringToSearch)
			throws SQLException, ClassNotFoundException; 
	
	/**
	 * Search device(s) by price
	 * @param lowerPrice
	 * @param upperPrice
	 * @return List<DeviceInfoBean>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<DeviceInfoBean> searchDeviceByPrice(int lowerPrice, int upperPrice)
			throws SQLException, ClassNotFoundException; 
	
	
	/**
	 * Delete a device
	 * @param id
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void deleteDevice(int id) throws SQLException, ClassNotFoundException;

	/**
	 * View the companies of each device type
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<DeviceTypeBean> viewTypeInfo() throws SQLException, ClassNotFoundException ;
	
	/**
	 * 
	 */
	public void writeLog();
}