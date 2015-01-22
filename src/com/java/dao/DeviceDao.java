package com.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.bean.DeviceInfoBean;
import com.java.dbutil.DBNameConstant;
import com.java.dbutil.DatabaseUtility;
import com.java.dbutil.ResultRecord;
import com.java.model.Device;
import com.java.preparedsql.DeviceTableSql;

public class DeviceDao implements InterfaceDeviceDao {

	/* (non-Javadoc)
	 * @see com.java.devicedao.Accessible#viewAllDevices()
	 */
	@Override
	public List<Device> viewAllDevices()
			throws SQLException, ClassNotFoundException {

		// Initiate result list of devices
		List<Device> devices = new ArrayList<Device>();
		
		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();
		
		try {

			// Open database
			newDBUtil.openDatabase();

			// Create Statement for querying database
			newDBUtil.statement = newDBUtil.connection.prepareStatement(
					DeviceTableSql.SQL_VIEW_ALL);

			// Define result set with statement
			ResultSet rs = newDBUtil.statement.executeQuery();

			// Store the information of devices to device list
			ResultRecord rr = new ResultRecord(rs);
			for (int i = 0; i < rr.getTotalCount(); i++) {
				Device device = new Device();
				device.setDeviceID(Integer.parseInt(rr.getString(i, "device_id")));
				device.setDeviceName(rr.getString(i, "device_name"));
				devices.add(device);
			}

			// Return the device list
			return devices;
		} // End try
		
		// Exception handling
		catch (Exception exception) {

			throw exception;
		}
		
		// Clean up the connnection
		finally {

			// Close database
			newDBUtil.closeDatabase();
		}
	}

	/* (non-Javadoc)
	 * @see com.java.devicedao.Accessible#viewDeviceDetails(int)
	 */
	@Override
	public DeviceInfoBean viewDeviceDetails(int id)
			throws SQLException, ClassNotFoundException {

		// Initiate a list containing all the infomation of device
		DeviceInfoBean deviceInfo = new DeviceInfoBean();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		try {
			
			// Open database
			newDBUtil.openDatabase();
		
			// Create Statement for querying database
			newDBUtil.statement = newDBUtil.connection.prepareStatement(
					DeviceTableSql.SQL_VIEW_DETAILS);
			newDBUtil.statement.setInt(1, id);

			// Define result set with statement
			ResultSet rs = newDBUtil.statement.executeQuery();

			// Get values of the specific device
			ResultRecord rr = new ResultRecord(rs);
			for (int i = 0; i < rr.getTotalCount(); i++) {
				deviceInfo.setDeviceID(Integer.parseInt(rr.getString(i, DBNameConstant.DEVICE_ID)));
				deviceInfo.setDeviceName(rr.getString(i, DBNameConstant.DEVICE_NAME));
				deviceInfo.setType(rr.getString(i, DBNameConstant.TYPE));
				deviceInfo.setCompanyName(rr.getString(i, DBNameConstant.COMPANY_NAME));
				deviceInfo.setCountry(rr.getString(i, DBNameConstant.COUNTRY));
				deviceInfo.setColor(rr.getString(i, DBNameConstant.COLOR));
				deviceInfo.setPrice(rr.getString(i, DBNameConstant.PRICE) == null ? 0 : 
					Integer.parseInt(rr.getString(i, DBNameConstant.PRICE)));
			}

			// Return device information
			return deviceInfo;
		} // End try
		
		// Exception handling
		catch (Exception exception) {
			
			throw exception;
		}
		
		// Clean up the connection
		finally {

			// Close database
			newDBUtil.closeDatabase();
		}
	}

	/* (non-Javadoc)
	 * @see com.java.devicedao.Accessible#insertNewDevice(com.java.model.Device)
	 */
	@Override
	public Device insertNewDevice(Device newDevice)
			throws SQLException, ClassNotFoundException {

		// Initiate result device
		Device insertedDevice = new Device();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		try {
			// Open database
			newDBUtil.openDatabase();

			// Create Statement for querying database
			newDBUtil.statement = newDBUtil.connection.prepareStatement(
					DeviceTableSql.SQL_INSERT_DEVICE);

			// Add arguments to the query
			newDBUtil.statement.setString(1, newDevice.getDeviceName());
			newDBUtil.statement.setString(2, newDevice.getType());
			newDBUtil.statement.setInt(3, newDevice.getCompanyID());
			newDBUtil.statement.setString(4, newDevice.getColor());
			newDBUtil.statement.setInt(5, newDevice.getPrice());
			newDBUtil.statement.setString(6, newDevice.getDeviceName());
			newDBUtil.statement.setString(7, newDevice.getColor());

			// Execute the statement
			newDBUtil.statement.executeUpdate();

			// create another statement to get the new ID
			newDBUtil.statement = newDBUtil.connection.prepareStatement(
					DeviceTableSql.SQL_LAST_ID);

			// Define result set with the statement
			ResultSet rs = newDBUtil.statement.executeQuery();

			// Get the values of the inserted device
			ResultRecord rr = new ResultRecord(rs);
			for (int i = 0; i < rr.getTotalCount(); i++) {
				if (Integer.parseInt(rr.getString(i, DBNameConstant.LAST_ID)) == 0) {
					break;
				}
				insertedDevice.setDeviceID(
						Integer.parseInt(rr.getString(i, DBNameConstant.LAST_ID)));
				insertedDevice.setDeviceName(newDevice.getDeviceName());
				insertedDevice.setType(newDevice.getType());
				insertedDevice.setCompanyID(newDevice.getCompanyID());
				insertedDevice.setColor(newDevice.getColor());
				insertedDevice.setPrice(newDevice.getPrice());
			}

			// Return the inserted device's information
			return insertedDevice;
		} // End try

		// Exception handling
		catch (Exception exception) {
			
			throw exception;
		}
		
		// Clean up the connection
		finally {

			// Close database
			newDBUtil.closeDatabase();
		}
	}

	/* (non-Javadoc)
	 * @see com.java.devicedao.Accessible#updateDevice(int, java.lang.String[])
	 */
	@Override
	public DeviceInfoBean updateDevice(int id, Device updateDevice) 
			throws SQLException, ClassNotFoundException {

		// Initiate update device
		DeviceInfoBean device = new DeviceInfoBean();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		try {
			
			// Open database
			newDBUtil.openDatabase();

			// Create statement for querying database
			newDBUtil.statement = newDBUtil.connection.prepareStatement(
					DeviceTableSql.SQL_UPDATE_DEVICE);
			newDBUtil.statement.setString(1, updateDevice.getDeviceName());
			newDBUtil.statement.setString(2, updateDevice.getType());
			newDBUtil.statement.setInt(3, updateDevice.getCompanyID());
			newDBUtil.statement.setString(4, updateDevice.getColor());
			newDBUtil.statement.setInt(5, updateDevice.getPrice());
			newDBUtil.statement.setInt(6, id);
			
			
			// Execute the statement
			newDBUtil.statement.executeUpdate();
			
			// Create another statement to view the updated information
			newDBUtil.statement = newDBUtil.connection.prepareStatement(
					DeviceTableSql.SQL_VIEW_DETAILS);
			newDBUtil.statement.setInt(1, id);
			
			// Define result set with statement
			ResultSet rs = newDBUtil.statement.executeQuery();

			// Get the values of the updated device
			ResultRecord rr = new ResultRecord(rs);
			for (int i = 0; i < rr.getTotalCount(); i++) {
				device.setDeviceID(
					Integer.parseInt(rr.getString(i, DBNameConstant.DEVICE_ID)));
				device.setDeviceName(rr.getString(i, DBNameConstant.DEVICE_NAME));
				device.setType(rr.getString(i, DBNameConstant.TYPE));
				device.setCompanyName(rr.getString(i, DBNameConstant.COMPANY_NAME));
				device.setCountry(rr.getString(i, DBNameConstant.COUNTRY));
				device.setColor(rr.getString(i, DBNameConstant.COLOR));
				device.setPrice(rr.getString(i, DBNameConstant.PRICE) == null ? 0 : 
					Integer.parseInt(rr.getString(i, DBNameConstant.PRICE)));
			}

			// Return the updated device's information
			return device;
		}
		
		catch (Exception exception) {
			
			throw exception;
		}
		
		finally {
			
			// Close database
			newDBUtil.closeDatabase();
		}
	}

	/* (non-Javadoc)
	 * @see com.java.devicedao.Accessible#SearchDevice(java.lang.String, java.lang.String)
	 */
	@Override
	public List<DeviceInfoBean> searchDevice(String tableField, String stringToSearch)
			throws SQLException, ClassNotFoundException {
		
		// Initiate search device
		List<DeviceInfoBean> devices = new ArrayList<DeviceInfoBean>();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		try {

			// Open database
			newDBUtil.openDatabase();
			
			// Set column name
			DBNameConstant.COLUMN_NAME = tableField;

			// Create statement for querying database
			newDBUtil.statement = newDBUtil.connection.prepareStatement(
					DeviceTableSql.SQL_SEARCH_DEVICE);
			newDBUtil.statement.setString(1, "%" + stringToSearch + "%");

			// Define result set with statement
			ResultSet rs = newDBUtil.statement.executeQuery();

			// Get the values of the searched device(s)
			ResultRecord rr = new ResultRecord(rs);
			for (int i = 0; i < rr.getTotalCount(); i++) {
				DeviceInfoBean device = new DeviceInfoBean();
				device.setDeviceID(
						Integer.parseInt(rr.getString(i, DBNameConstant.DEVICE_ID)));
				device.setDeviceName(rr.getString(i, DBNameConstant.DEVICE_NAME));
				device.setType(rr.getString(i, DBNameConstant.TYPE));
				device.setCompanyName(rr.getString(i,DBNameConstant.COMPANY_NAME));
				device.setCountry(rr.getString(i, DBNameConstant.COUNTRY));
				device.setColor(rr.getString(i, DBNameConstant.COLOR));
				device.setPrice(rr.getString(i, DBNameConstant.PRICE) == null ? 0 :
						Integer.parseInt(rr.getString(i, DBNameConstant.PRICE)));
				devices.add(device);
			}

			// Return the device's information after searching
			return devices;
		}

		catch (Exception exception) {

			throw exception;
		}

		finally {

			// Close database
			newDBUtil.closeDatabase();
		}
	}

	/* (non-Javadoc)
	 * @see com.java.devicedao.Accessible#SearchDeviceByPrice(int, int)
	 */
	@Override
	public List<DeviceInfoBean> searchDeviceByPrice(int lowerPrice, int upperPrice)
			throws SQLException, ClassNotFoundException {
		
		// Initiate result list of devices
		List<DeviceInfoBean> devices = new ArrayList<DeviceInfoBean>();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		try {

			// Open database
			newDBUtil.openDatabase();

			// Create statement for querying database
			newDBUtil.statement = newDBUtil.connection
					.prepareStatement(DeviceTableSql.SQL_SEARCH_PRICE);
			newDBUtil.statement.setInt(1, lowerPrice);
			newDBUtil.statement.setInt(2, upperPrice);

			// Initiate the result set for viewing all the devices
			ResultSet rs = newDBUtil.statement.executeQuery();

			// Get the results into the device list
			ResultRecord rr = new ResultRecord(rs);
			for (int i = 0; i < rr.getTotalCount(); i++) {
				DeviceInfoBean device = new DeviceInfoBean();
				device.setDeviceID(
						Integer.parseInt(rr.getString(i, DBNameConstant.DEVICE_ID)));
				device.setDeviceName(rr.getString(i, DBNameConstant.DEVICE_NAME));
				device.setType(rr.getString(i, DBNameConstant.TYPE));
				device.setCompanyName(rr.getString(i, DBNameConstant.COMPANY_NAME));
				device.setCountry(rr.getString(i, DBNameConstant.COUNTRY));
				device.setColor(rr.getString(i, DBNameConstant.COLOR));
				device.setPrice(rr.getString(i, DBNameConstant.PRICE) == null ? 0 :
						Integer.parseInt(rr.getString(i, DBNameConstant.PRICE)));
				devices.add(device);
			}
			
			// Return the device list
			return devices;
		} // End try
		
		// Exception handling
		catch (Exception exception) {
			
			throw exception;
		}
		
		// Clean up the connection
		finally {
			
			// Close database
			newDBUtil.closeDatabase();
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.java.devicedao.Accessible#deleteDevice(int)
	 */
	public void deleteDevice(int id) throws SQLException, ClassNotFoundException {
		
		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		// Open database
		newDBUtil.openDatabase();

		// Create statement for querying database
		newDBUtil.statement = newDBUtil.connection.prepareStatement(
				DeviceTableSql.SQL_DELETE_DEVICE);
		newDBUtil.statement.setInt(1, id);

		// Execute the statement
		newDBUtil.statement.executeUpdate();

		// Close database
		newDBUtil.closeDatabase();
	}

	/* (non-Javadoc)
	 * @see com.java.devicedao.Accessible#writeLog()
	 */
	@Override
	public void writeLog() {
		// TODO Auto-generated method stub

	}

}
