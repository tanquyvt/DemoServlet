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
	
	/**
	 * @throws SQLException
	 */
	public void closeDatabase() throws SQLException {

		// Close statement and connection
		statement.close();
		connection.close();
	}

}
