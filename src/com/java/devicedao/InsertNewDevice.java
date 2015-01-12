package com.java.devicedao;

import java.sql.SQLException;

import com.java.dbutil.CloseTable;
import com.java.dbutil.InsertTable;
import com.java.dbutil.OpenDatabase;
import com.java.model.Device;
import com.java.model.Mobile;

public class InsertNewDevice {
	
	// Define InsertNewDevice constructor
	public InsertNewDevice(Device newDevice) throws SQLException, ClassNotFoundException {
		try {
			
			// Insert new device to the table
			new OpenDatabase();
			new InsertTable(newDevice);
			new CloseTable();
			
		} // End try
		
		// Detect problems interacting with database
		catch (Exception exception) {
			OpenDatabase.results = exception.getMessage();
		}
	}
	
	public static void main(String agrs[]) {
		try {
			Device mobile1 = new Mobile("Asus Zenfone A450", "0002", "Black", 2499000);
			new InsertNewDevice(mobile1);
			System.out.println(OpenDatabase.results);
			new SearchDevice(mobile1.deviceName);
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
