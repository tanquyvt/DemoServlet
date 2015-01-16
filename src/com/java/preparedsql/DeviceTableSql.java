package com.java.preparedsql;

import com.java.dbutil.DBNameConstant;

public class DeviceTableSql {

	// SQL query to view all the devices
	public static final String SQL_VIEW_ALL = ("SELECT `"
			+ DBNameConstant.DEVICE_ID + "`, `" + DBNameConstant.DEVICE_NAME
			+ "` " + "FROM `" + DBNameConstant.DEVICE + "` " + "ORDER BY `"
			+ DBNameConstant.DEVICE_ID + "`");

	// SQL query to view a device's details
	public static final String SQL_VIEW_DETAILS = ("SELECT `"
			+ DBNameConstant.DEVICE_ID + "`, `" + DBNameConstant.DEVICE_NAME
			+ "`, `" + DBNameConstant.TYPE + "`, `" + DBNameConstant.DEVICE + "`.`" + DBNameConstant.COMPANY_ID
			+ "`, `" + DBNameConstant.COMPANY_NAME + "`, `"
			+ DBNameConstant.COUNTRY + "`, `" + DBNameConstant.COLOR + "`, `"
			+ DBNameConstant.PRICE + "` " + "FROM `" + DBNameConstant.DEVICE
			+ "`, `" + DBNameConstant.COMPANY + "` " + "WHERE `"
			+ DBNameConstant.DEVICE + "`.`" + DBNameConstant.COMPANY_ID + "`=`"
			+ DBNameConstant.COMPANY + "`.`" + DBNameConstant.COMPANY_ID + "` "
			+ "AND `" + DBNameConstant.DEVICE_ID + "`= ? ");

	// SQL query to insert a new device
	public static final String SQL_INSERT_DEVICE = ("INSERT INTO `"
			+ DBNameConstant.DEVICE + "`(`" + DBNameConstant.DEVICE_NAME
			+ "`, `" + DBNameConstant.TYPE + "`, `" + DBNameConstant.COMPANY_ID
			+ "`, `" + DBNameConstant.COLOR + "`, `" + DBNameConstant.PRICE
			+ "`) " + "VALUES (?, ?, ?, ?, ?)");

	// SQL query to get the last inserted device's ID
	public static final String SQL_LAST_ID = ("SELECT LAST_INSERT_ID()");

	// SQL query to search device(s)
	public static final String SQL_SEARCH_DEVICE = ("SELECT `"
			+ DBNameConstant.DEVICE_ID + "`, `" + DBNameConstant.DEVICE_NAME
			+ "`, `" + DBNameConstant.TYPE + "`, `"
			+ DBNameConstant.COMPANY_NAME + "`, `" + DBNameConstant.COUNTRY
			+ "`, `" + DBNameConstant.COLOR + "`, `" + DBNameConstant.PRICE
			+ "` " + "FROM `" + DBNameConstant.DEVICE + "`, `"
			+ DBNameConstant.COMPANY + "` " + "WHERE `" + DBNameConstant.DEVICE
			+ "`.`" + DBNameConstant.COMPANY_ID + "`=`"
			+ DBNameConstant.COMPANY + "`.`" + DBNameConstant.COMPANY_ID + "` "
			+ "AND `?` LIKE '%?%' ORDER BY `" + DBNameConstant.DEVICE_ID + "`");

	// SQL query to update an old device
	public static final String SQL_UPDATE_DEVICE = ("UPDATE `"
			+ DBNameConstant.DEVICE + "` " + "SET `"
			+ DBNameConstant.DEVICE_NAME + "`= ?, `" + DBNameConstant.TYPE
			+ "`= ?, `" + DBNameConstant.COMPANY_ID + "`= ?, `"
			+ DBNameConstant.COLOR + "`= ?, `" + DBNameConstant.PRICE + "`= ? "
			+ "WHERE `" + DBNameConstant.DEVICE_ID + "`= ?");

	// SQL query to delete a device
	public static final String SQL_DELETE_DEVICE = ("DELETE FROM `"
			+ DBNameConstant.DEVICE + "` WHERE `" + DBNameConstant.DEVICE_ID + "`= ?");
}
