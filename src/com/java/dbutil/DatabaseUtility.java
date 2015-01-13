package com.java.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.java.model.Device;

public class DatabaseUtility {

	// Initial statement and connection
	Statement statement;
	static Connection connection;

	// Initiate database connection method
	public void openDatabase() throws SQLException, ClassNotFoundException {

		// Declare JDBC driver name and database URL
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/fptshop";

		// Load database driver class
		Class.forName(JDBC_DRIVER);

		// establish connection to database
		connection = DriverManager.getConnection(DATABASE_URL, "root", "");
	}

	public ResultSet initiateViewAll() throws SQLException {

		// create Statement for querying database
		statement = connection.createStatement();

		// Define result set with statement
		ResultSet resultSet = statement.executeQuery(
				"SELECT `device_id`, `device_name`" +
				"FROM `device`" +
				"ORDER BY `device_id`");
		return resultSet;
	}
	
	public ResultSet initiateInsertTable(Device newDevice) throws SQLException {
		
		// create Statement for querying database
		statement = connection.createStatement();

		// Define result set with statement
		statement.executeUpdate(
				"INSERT INTO `device`(`device_name`, `type`, `company_id`, `color`, `price`) " +
				"VALUES ('" + newDevice.getDeviceName() + "', '" + newDevice.getType() +
				"', " + newDevice.getCompanyID() + ", '" + newDevice.getColor() +
				"', " + newDevice.getPrice() + ")");
		ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID()");
		
		// return the result set
		return resultSet;
	}
	
	public ResultSet initiateSearchTable(String tableField, String stringToSearch) throws SQLException {
		
		// create Statement for querying database
		statement = connection.createStatement();
		
		// Define result set with statement
		ResultSet resultSet = statement.executeQuery(
			"SELECT `device_id`, `device_name`, `type`, `company_name`, `country`, `color`, `price` " +
			"FROM `device`, `company` " +
			"WHERE `device`.`company_id=`company`.`company_id` " +
			"AND " + tableField + "='" + stringToSearch + "' " +
			"ORDER BY device_id");
		
		// return the result set
		return resultSet;
	}
	
	public ResultSet initiateSearchTable(int lowerPrice, int upperPrice) throws SQLException {
		
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

	public ResultSet initiateViewDetails(int id)
		throws SQLException {

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
	
	public ResultSet initiateUpdateTable(int id, String updateField, String updateString)
			throws SQLException {

			// create Statement for querying database
			statement = connection.createStatement();

			// Define result set with statement
			statement.executeUpdate(
				"UPDATE `device`" +
				"SET `" + updateField + "'='" + updateString + "'" +
				"WHERE `device_id`=" + id);
			ResultSet resultSet = statement.executeQuery("SELECT * FROM `device` WHERE `device_id`=" + id);

			// return the result set
			return resultSet;
		}
	
	// Close database connection method
	public void closeDatabase() throws SQLException {

		// Close statement and connection
		statement.close();
		connection.close();
	}

}
