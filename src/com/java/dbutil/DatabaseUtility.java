package com.java.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUtility {

	// Initial statement and connection
	public PreparedStatement statement;
	public Connection connection;

	/**
	 * Open Database
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void openDatabase() throws SQLException, ClassNotFoundException {

		// Declare JDBC driver name and database URL
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/fptshop";

		// Load database driver class
		Class.forName(JDBC_DRIVER);

		// establish connection to database
		connection = DriverManager.getConnection(DATABASE_URL, "root", "");
	}

/*	*//**
	 * Preparation for viewing all devices
	 * @return resultSet
	 * @throws SQLException
	 *//*
	public ResultSet prepareViewAllDevices() throws SQLException {

		// create Statement for querying database
		statement = connection.createStatement();

		// Define result set with statement
		ResultSet resultSet = statement.executeQuery(
				"SELECT `device_id`, `device_name`" +
				"FROM `device`" +
				"ORDER BY `device_id`");
		return resultSet;
	}
	
	*//**
	 * Preparation for viewing all companies
	 * @return resultSet
	 * @throws SQLException
	 *//*
	public ResultSet prepareViewAllCompanies() throws SQLException {

		// create Statement for querying database
		statement = connection.createStatement();

		// Define result set with statement
		ResultSet resultSet = statement.executeQuery(
				"SELECT `company_id`, `company_name` " +
				"FROM `company` ORDER BY `company_id`");
		
		return resultSet;
	}
	
	*//**
	 * Preparation for inserting new device
	 * @param newDevice
	 * @return resultSet
	 * @throws SQLException
	 *//*
	public ResultSet prepareInsertDevice(Device newDevice) throws SQLException {
		
		// create Statement for querying database
		statement = connection.createStatement();

		// Define result set with statement
		statement.executeQuery("CREATE PROC sp_InsertDevice(" +
				"@deviceid int(5), @devicename varchar(30), @type varchar(10)," +
				"@companyid int(4), @color varchar(10), @price int(8)) " +
				"AS BEGIN " +
				"INSERT INTO `device`(`device_name`, `type`, `company_id`, `color`, `price`)" +
				"VALUES (@devicename, @type, @companyid, @color, @price) " +
				"END");
		statement.executeUpdate(
				"sp_InsertDevice '" + newDevice.getDeviceName() + "', '" + newDevice.getType() +
				"', '" + newDevice.getCompanyID() + "', '" + newDevice.getColor() +
				"', '" + newDevice.getPrice() + "'");
		ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID()");
		
		// return the result set
		return resultSet;
	}
	
	*//**
	 * Preparation for inserting new company
	 * @param newDevice
	 * @return resultSet
	 * @throws SQLException
	 *//*
	public ResultSet prepareInsertCompany(Company newCompany) throws SQLException {
		
		// create Statement for querying database
		statement = connection.createStatement();

		// Define result set with statement
		statement.executeUpdate(
				"INSERT INTO `company`" +
				"VALUES (" + newCompany.getCompanyID() + ", '" + newCompany.getCompanyName() + "', '" + newCompany.getCountry() + "')");
		ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID()");
		
		// return the result set
		return resultSet;
	}
	
	*//**
	 * Preparation for searching device(s)
	 * @param tableField
	 * @param stringToSearch
	 * @return resultSet
	 * @throws SQLException
	 *//*
	public ResultSet prepareSearchDevice(String tableField, String stringToSearch) throws SQLException {
		
		// create Statement for querying database
		statement = connection.createStatement();
		
		// Define result set with statement
		ResultSet resultSet = statement.executeQuery(
			"SELECT `device_id`, `device_name`, `type`, `company_name`, `country`, `color`, `price` " +
			"FROM `device`, `company` " +
			"WHERE `device`.`company_id`=`company`.`company_id` " +
			"AND `" + tableField + "` LIKE '%" + stringToSearch + "%' " +
			"ORDER BY `device_id`");
		
		// return the result set
		return resultSet;
	}
	
	*//**
	 * Preparation for searching company(s)
	 * @param tableField
	 * @param stringToSearch
	 * @return resultSet
	 * @throws SQLException
	 *//*
	public ResultSet prepareSearchCompany(String tableField, String stringToSearch) throws SQLException {
		
		// create Statement for querying database
		statement = connection.createStatement();
		
		// Define result set with statement
		ResultSet resultSet = statement.executeQuery(
			"SELECT * FROM `company` " +
			"WHERE `" + tableField + "` LIKE '%" + stringToSearch + "%' " +
			"ORDER BY `company_id`");
		
		// return the result set
		return resultSet;
	}
	
	*//**
	 * Prepapartion for searching device(s) by price
	 * @param lowerPrice
	 * @param upperPrice
	 * @return resultSet
	 * @throws SQLException
	 *//*
	public ResultSet prepareSearchDevice(int lowerPrice, int upperPrice) throws SQLException {
		
		// create Statement for querying database
		statement = connection.createStatement();
		
		// Define result set with statement
		ResultSet resultSet = statement.executeQuery(
			"SELECT `device_id`, `device_name`, `type`, `company_name`, `country`, `color`, `price` " +
			"FROM `device`, `company` " +
			"WHERE `device`.`company_id`=`company`.`company_id` " +
			"AND `price` BETWEEN " + lowerPrice + " AND " + upperPrice +
			"ORDER BY device_id");
		
		// return the result set
		return resultSet;
	}

	*//**
	 * Preparation for viewing device's details
	 * @param id
	 * @return resultSet
	 * @throws SQLException
	 *//*
	public ResultSet prepareViewDeviceDetails(int id) throws SQLException {

		// create Statement for querying database
		statement = connection.createStatement();

		// Define result set with statement
		ResultSet resultSet = statement.executeQuery(
			"SELECT `device_id`, `device_name`, `type`, `company_name`, `country`, `color`, `price` " +
			"FROM `device`, `company` " +
			"WHERE `device`.`company_id`=`company`.`company_id` " +
			"AND `device_id`=" + id);

		// return the result set
		return resultSet;
	}
	
	*//**
	 * Preparation for viewing company's details
	 * @param id
	 * @return resultSet
	 * @throws SQLException
	 *//*
	public ResultSet prepareViewCompanyDetails(int id) throws SQLException {

		// create Statement for querying database
		statement = connection.createStatement();

		// Define result set with statement
		ResultSet resultSet = statement.executeQuery(
			"SELECT * FROM `company` " +
			"WHERE `company_id`=" + id);

		// return the result set
		return resultSet;
	}
	
	*//**
	 * Preparation for updating an old device
	 * @param id
	 * @param updateValues
	 * @return resultSet
	 * @throws SQLException
	 *//*
	public ResultSet prepareUpdateDevice(int id, String[] updateValues) throws SQLException {

			// create Statement for querying database
			statement = connection.createStatement();

			// Define result set with statement
			statement.executeUpdate(
				"UPDATE `device`" +
				"SET `device_name`='" + updateValues[0] + "', " +
				"`type`='" + updateValues[1] + "', " +
				"`company_id`=" + Integer.parseInt(updateValues[2]) + ", " +
				"'color`=" + updateValues[3] + ", " +
				"`price`=" + Integer.parseInt(updateValues[4]) + " " +
				"WHERE `device_id`=" + id);
			ResultSet resultSet = statement.executeQuery("SELECT * FROM `device` WHERE `device_id`=" + id);

			// return the result set
			return resultSet;
	}
	
	*//**
	 * Preparation for updating an old company
	 * @param id
	 * @param updateValues
	 * @return resultSet
	 * @throws SQLException
	 *//*
	public ResultSet prepareUpdateCompany(int id, String[] updateValues) throws SQLException {

			// create Statement for querying database
			statement = connection.createStatement();

			// Define result set with statement
			statement.executeUpdate(
				"UPDATE `company`" +
				"SET `company_name`='" + updateValues[0] + "', " +
				"`country`='" + updateValues[1] + "' " +
				"WHERE `company_id`=" + id);
			ResultSet resultSet = statement.executeQuery("SELECT * FROM `company` WHERE `company_id`=" + id);

			// return the result set
			return resultSet;
	}
	
	*//**
	 * Delete a device
	 * @param id
	 * @throws SQLException
	 *//*
	public void deleteDevice(int id) throws SQLException{
		
		// create Statement for querying database
		statement = connection.createStatement();
					
		// Define result set with statement
		statement.executeUpdate("DELETE FROM `device` WHERE `device_id`=" + id);
	}
	
	*//**
	 * Delete a company
	 * @param id
	 * @throws SQLException
	 *//*
	public void deleteCompany(int id) throws SQLException{
		
		// create Statement for querying database
		statement = connection.createStatement();
					
		// Define result set with statement
		statement.executeUpdate("DELETE FROM `company` WHERE `company_id`=" + id);
	}*/
	
	/**
	 * @throws SQLException
	 */
	public void closeDatabase() throws SQLException {

		// Close statement and connection
		statement.close();
		connection.close();
	}

}
