package com.java.dao;

import java.sql.SQLException;
import java.util.List;
import com.java.bean.DeviceInfoBean;
import com.java.model.Device;

public interface InterfaceDeviceDao {
	/**
	 * View all devices method
	 * @return List<Device>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * 
	 * Test Successful!
	 */
	public List<Device> viewAllDevices()
			throws SQLException, ClassNotFoundException;
	
	/**
	 * View device's details method
	 * @param id
	 * @return DeviceInfoBean
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * 
	 * Test Successful!
	 */
	public DeviceInfoBean viewDeviceDetails(int id)
			throws SQLException, ClassNotFoundException;
	
	/**
	 * Insert new device method
	 * @param newDevice
	 * @return Device
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * 
	 * Test Successful!
	 */
	public Device insertNewDevice(Device newDevice)
			throws SQLException, ClassNotFoundException;
	
	/**
	 * @param id
	 * @param updateField
	 * @param updateValue
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * 
	 * Test Successful!
	 */
	public DeviceInfoBean updateDevice(int id, Device updateDevice)
			throws SQLException, ClassNotFoundException ;
	
	/**
	 * @param tableField
	 * @param stringToSearch
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * 
	 * Test Successful!
	 */
	public List<DeviceInfoBean> searchDevice(String tableField, String stringToSearch)
			throws SQLException, ClassNotFoundException; 
	
	/**
	 * SearchDeviceByPrice
	 * 
	 * @param lowerPrice
	 * @param upperPrice
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * 
	 * Test Successful!
	 */
//	public List<DeviceInfoBean> searchDeviceByPrice(int lowerPrice, int upperPrice)
//			throws SQLException, ClassNotFoundException; 
	
	
	public void deleteDevice(int id) throws SQLException, ClassNotFoundException;
	
	/**
	 * 
	 */
	public void writeLog();
}