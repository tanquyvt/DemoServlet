package com.java.dbutil;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultRecord {
	private List<String> items;
	private List<Object> rowData;
	private List<List<Object>> rows = new ArrayList<List<Object>>();
	private int totalCount;
	
	public ResultRecord(ResultSet rs) throws SQLException{
		if (!rs.next()){
			return;
		}
		storeColumnName(rs.getMetaData());
		do {
		storeRowData(rs);
		totalCount++;
		} while (rs.next());
		
	}
	public void storeColumnName(ResultSetMetaData metaData) throws SQLException {
		int numberOfColumns = metaData.getColumnCount();
		items = new ArrayList<String>();
		
		for (int i = 1; i <= numberOfColumns; i++) {
			items.add(metaData.getColumnName(i));
		}
	}
	
	public void storeRowData(ResultSet rs) throws SQLException{
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		rowData = new ArrayList<Object>();
		
		for (int i = 1; i <= columnCount; i++) {
			rowData.add(rs.getObject(i));
		}
		rows.add(rowData);
	}
	
	public String getString(int index, String item) {
		Object obj = getElementValue(index, item);
		if (obj != null) {
		return obj.toString();}
		else return null;
	}

	private Object getElementValue(int index, String item) {
		List<Object> currentRow = rows.get(index);
		int colIndex = items.indexOf(item);
		Object obj = currentRow.get(colIndex);
		
		return obj;
	}
	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}
	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	

}
