package com.java.dbutil;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SearchTable {
	
	// Define SearchTable constructor with argument "id"
	public SearchTable(int num) {
		try {
			
			int existResult = 0;
			
			// create Statement for querying database
			OpenDatabase.statement = OpenDatabase.connection.createStatement();
			
			// Define result set with statement
			ResultSet resultSet = OpenDatabase.statement.executeQuery("SELECT * FROM `device`");
			
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
				if (num == (int) resultSet.getObject(1) ||
					num == (int) resultSet.getObject(6)) {
					OpenDatabase.results = OpenDatabase.results.concat("<tr>");
					for (int i = 1; i <= numberOfColumns; i++) {
						OpenDatabase.results = OpenDatabase.results.concat("<td>" + resultSet.getObject(i) + "</td>");
					}
					OpenDatabase.results = OpenDatabase.results.concat("</tr>");
					existResult = 1;
				}
			}
			OpenDatabase.results = OpenDatabase.results.concat("</table>");
			if (existResult == 1) {
				OpenDatabase.results.concat("<br />There are no results");
			}
		} // End try
		
		// Detect problems interacting with database
		catch (SQLException sqlException) {
			OpenDatabase.results = sqlException.getMessage();
		}
	}
	
	// Define SearchTable constructor with argument "name"
	public SearchTable(String str) {
		try {
			
			int existResult = 0;
			
			// create Statement for querying database
			OpenDatabase.statement = OpenDatabase.connection.createStatement();
			
			// Define result set with statement
			ResultSet resultSet = OpenDatabase.statement.executeQuery("SELECT * FROM `device`");
			
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
				if (str.equals(resultSet.getObject(2)) ||
					str.equals(resultSet.getObject(3)) ||
					str.equals(resultSet.getObject(4)) ||
					str.equals(resultSet.getObject(5))) {
					OpenDatabase.results = OpenDatabase.results.concat("<tr>");
					for (int i = 1; i <= numberOfColumns; i++) {
						OpenDatabase.results = OpenDatabase.results.concat("<td>" + resultSet.getObject(i) + "</td>");
					}
					OpenDatabase.results = OpenDatabase.results.concat("</tr>");
					existResult = 1;
				}
			}
			OpenDatabase.results = OpenDatabase.results.concat("</table>");
			if (existResult == 0) {
				OpenDatabase.results.concat("<br />There are no results");
			}
		} // End try
		
		// Detect problems interacting with database
		catch (SQLException sqlException) {
			OpenDatabase.results = sqlException.getMessage();
		}
	}
}
