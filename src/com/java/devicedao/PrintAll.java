package com.java.devicedao;

import java.sql.SQLException;
import com.java.dbutil.CloseTable;
import com.java.dbutil.OpenDatabase;
import com.java.dbutil.ViewTable;

public class PrintAll {
	
	// Define PrintAll constructor
	public PrintAll() throws SQLException, ClassNotFoundException {
		
		try {
			// Open the database
			new OpenDatabase();
			
			// Present the device table
			new ViewTable();
			
			// Close the table
			new CloseTable();
		}
		catch (Exception exception) {
			OpenDatabase.results = exception.getMessage();
		}
	}
	
	public static void main (String agrs[]) {
		
		try {
			new PrintAll();
			System.out.println(OpenDatabase.results);
		}
		catch (SQLException sqlException) {
			OpenDatabase.results = sqlException.getMessage();
		}
		catch (ClassNotFoundException classNotFound) {
			OpenDatabase.results = classNotFound.getMessage();
		}
	}
}
