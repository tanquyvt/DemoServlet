package com.java.dbutil;

import java.sql.SQLException;

public class CloseTable {
	
	// Define CloseTable constructor
	public CloseTable() {
		
		try {
			
			// Close statement and connection
			OpenDatabase.statement.close();
			OpenDatabase.connection.close();
			
		} // End try
		
		// Detect problems interacting with database
		catch (SQLException sqlException) {
			OpenDatabase.results = sqlException.getMessage();
		}
	}
}
