package com.java.devicedao;

import java.sql.SQLException;
import com.java.dbutil.CloseTable;
import com.java.dbutil.OpenDatabase;
import com.java.dbutil.SearchTable;

public class SearchDevice {
	// Define InsertNewDevice constructor
		public SearchDevice(String str) throws SQLException, ClassNotFoundException {
			try {
				
				// Insert new device to the table
				new OpenDatabase();
				new SearchTable(str);
				new CloseTable();
				
			} // End try
			
			// Detect problems interacting with database
			catch (Exception exception) {
				OpenDatabase.results = exception.getMessage();
			}
		}
}
