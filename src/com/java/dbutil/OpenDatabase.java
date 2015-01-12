package com.java.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OpenDatabase {

	// Declare JDBC driver name and database URL
	static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/fptshop";
	
	// Initial statement and connection
	static Statement statement;
	static Connection connection;
	
	// Output string
	public static String results;
	
	// Define OpenTable constructor
	public OpenDatabase() throws SQLException, ClassNotFoundException {
		
		// Initiate string results
		results = new String();
		
		try {
			
			// Load database driver class
			Class.forName(JDBC_DRIVER);
			
			// establish connection to database
			connection = DriverManager.getConnection(DATABASE_URL, "root", "");
			
		} // End try
		
		// Detect problems (interacting with database, loading database driver)
		catch (Exception exception) {
			results = (exception.getMessage());
		}
	} // End OpenTable constructor
}