package com.java.dbutil;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ViewTable {
	
	// Define ViewTable constructor
	public ViewTable() {
		
		try {
			
			// create Statement for querying database
			OpenDatabase.statement = OpenDatabase.connection.createStatement();
			
			// Define result set with statement
			ResultSet resultSet = OpenDatabase.statement.executeQuery(
					"SELECT `device_id`, `device_name`, `type`, `company_name`, `color`, `price`" +
					"FROM `device`, `company`" +
					"WHERE `device`.`company_id`=`company`.`company_id`" +
					"ORDER BY `device_id`");
			
			// Acquire data by metaData
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			
			// Input the HTML-form table to string results
			OpenDatabase.results = "<table>" +
									"<tr>" +
									"<td>Device ID</td>" +
									"<td>Device Name</td>" +
									"<td>Type</td>" +
									"<td>Company Name</td>" +
									"<td>Color</td>" +
									"<td>Price</td>";
			while (resultSet.next()) {
				OpenDatabase.results = OpenDatabase.results.concat("<tr>");
				for (int i = 1; i <= numberOfColumns; i++) {
					OpenDatabase.results = OpenDatabase.results.concat("<td>" + resultSet.getObject(i) + "</td>");
				}
				OpenDatabase.results = OpenDatabase.results.concat("</tr>");
			}
			OpenDatabase.results = OpenDatabase.results.concat("</table>");
			
		} // End try
		
		// Detect problems interacting with database
		catch (SQLException sqlException) {
			OpenDatabase.results = sqlException.getMessage();
		}
	} // End ViewTable constructor
}
