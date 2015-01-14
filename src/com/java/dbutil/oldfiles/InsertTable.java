package com.java.dbutil;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.java.model.Device;

public class InsertTable {
	
	// Define InsertTable constructor
	public InsertTable(Device newDevice) {
		try {
			
			// Create statement for querying database
			OpenDatabase.statement = OpenDatabase.connection.createStatement(
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			// Define result set with statement
			OpenDatabase.statement.executeUpdate(
					"INSERT INTO `device`" +
					"VALUES (0, '" + newDevice.deviceName + "', '" + newDevice.type +
					"', '" + newDevice.companyID + "', '" + newDevice.color +
					"', " + newDevice.price + ")");
			
			// Inform the successful action
			OpenDatabase.results = "Insertion is successful.<br />";
			
		} // End try
		
		// Detect problems interacting with database
		catch (SQLException sqlException) {
			OpenDatabase.results = sqlException.getMessage();
		}
	}
}
