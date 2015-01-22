package com.java.preparedsql;

import com.java.dbutil.DBNameConstant;

public class DeviceTableSql extends CommonSql{
	
	// SQL query to view all the devices
	public static final String SQL_VIEW_ALL = 
			("SELECT `" + DBNameConstant.DEVICE_ID + "`, `" + DBNameConstant.DEVICE_NAME + "` " +
			"FROM `" + DBNameConstant.DEVICE + "` " +
			"ORDER BY `" + DBNameConstant.DEVICE_ID + "`");
	
	// SQL query to view a device's details
	public static final String SQL_VIEW_DETAILS = 
			("SELECT `" +
					DBNameConstant.DEVICE_ID + "`, `" + DBNameConstant.DEVICE_NAME + "`, `" +
					DBNameConstant.TYPE + "`, `" + DBNameConstant.COMPANY_NAME + "`, `" +
					DBNameConstant.COUNTRY + "`, `" + DBNameConstant.COLOR + "`, `" +
					DBNameConstant.PRICE + "` " +
			"FROM `" + DBNameConstant.DEVICE + "`, `" + DBNameConstant.COMPANY + "` " +
			"WHERE `" +
					DBNameConstant.DEVICE + "`.`" + DBNameConstant.COMPANY_ID + "`=`" +
					DBNameConstant.COMPANY + "`.`" + DBNameConstant.COMPANY_ID + "` " +
					"AND `" + DBNameConstant.DEVICE_ID + "`=? ");
	
	// SQL query to insert a new device
	public static final String SQL_INSERT_DEVICE =
			("INSERT INTO `" +
					DBNameConstant.DEVICE + "`(`" + DBNameConstant.DEVICE_NAME + "`, `" +
					DBNameConstant.TYPE + "`, `" + DBNameConstant.COMPANY_ID + "`, `" +
					DBNameConstant.COLOR + "`, `" + DBNameConstant.PRICE + "`) " +
			"SELECT ?, ?, ?, ?, ? " +
			"FROM DUAL " +
			"WHERE NOT EXISTS (SELECT `" + DBNameConstant.DEVICE_NAME + "`, `" +
					DBNameConstant.COLOR + "` " +
					"FROM `" + DBNameConstant.DEVICE + "` " +
					"WHERE `" + DBNameConstant.DEVICE_NAME + "`=? AND `" +
					DBNameConstant.COLOR + "`=?)" +
			"LIMIT 1");
	
	// SQL query to search device(s)
	public static String SQL_SEARCH_DEVICE =
			("SELECT `" +
					DBNameConstant.DEVICE_ID + "`, `" + DBNameConstant.DEVICE_NAME + "`, `" +
					DBNameConstant.TYPE + "`, `" + DBNameConstant.COMPANY_NAME + "`, `" + 
					DBNameConstant.COUNTRY + "`, `" + DBNameConstant.COLOR + "`, `" +
					DBNameConstant.PRICE + "` " +
			"FROM `" + DBNameConstant.DEVICE + "`, `" + DBNameConstant.COMPANY + "` " +
			"WHERE `" +
					DBNameConstant.DEVICE + "`.`" + DBNameConstant.COMPANY_ID + "`=`" +
					DBNameConstant.COMPANY + "`.`" + DBNameConstant.COMPANY_ID + "` " +
					"AND `" + DBNameConstant.COLUMN_NAME + "` LIKE ? ORDER BY `" + DBNameConstant.DEVICE_ID + "`");
	
	// SQL query to update a device's information
	public static final String SQL_UPDATE_DEVICE =
			("UPDATE `" + DBNameConstant.DEVICE + "` " +
			"SET `" +
					DBNameConstant.DEVICE_NAME+ "`=?, `" +
					DBNameConstant.TYPE + "`=?, `" +
					DBNameConstant.COMPANY_ID + "`=?, `" +
					DBNameConstant.COLOR + "`=?, `" +
					DBNameConstant.PRICE + "`=? " +
			"WHERE `" + DBNameConstant.DEVICE_ID + "`=?");
	
	// SQL query to delete a device
	public static final String SQL_DELETE_DEVICE =
			("DELETE FROM `" + DBNameConstant.DEVICE + "` WHERE `" +
			DBNameConstant.DEVICE_ID + "`=?");
	
	// SQL query to search device(s) by price
	public static final String SQL_SEARCH_PRICE =
			("SELECT `" +
					DBNameConstant.DEVICE_ID + "`, `" + DBNameConstant.DEVICE_NAME + "`, `" +
					DBNameConstant.TYPE + "`, `" + DBNameConstant.COMPANY_NAME + "`, `" +
					DBNameConstant.COUNTRY + "`, `" + DBNameConstant.COLOR + "`, `" +
					DBNameConstant.PRICE + "` " +
			"FROM `" + DBNameConstant.DEVICE + "`, `" + DBNameConstant.COMPANY + "` " +
			"WHERE `" +
					DBNameConstant.DEVICE + "`.`" + DBNameConstant.COMPANY_ID + "`=`" +
					DBNameConstant.COMPANY + "`.`" + DBNameConstant.COMPANY_ID + "` " +
					"AND `" + DBNameConstant.PRICE + "` BETWEEN ? AND ? " +
			"ORDER BY `" + DBNameConstant.DEVICE_ID + "`");
}
