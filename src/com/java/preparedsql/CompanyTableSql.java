package com.java.preparedsql;

import com.java.dbutil.*;

public class CompanyTableSql {
	// SQL query to view all the companies
	public static final String SQL_VIEW_ALL = ("SELECT `"
			+ DBNameConstant.COMPANY_ID + "`, `" + DBNameConstant.COMPANY_NAME
			+ "` " + "FROM `" + DBNameConstant.COMPANY + "` " + "ORDER BY `"
			+ DBNameConstant.COMPANY_ID + "`");

	// SQL query to view a company's details
	public static final String SQL_VIEW_DETAILS = ("SELECT `"
			+ DBNameConstant.COMPANY_ID + "`, `" + DBNameConstant.COMPANY_NAME
			+ DBNameConstant.COUNTRY + "` " + "FROM `" + DBNameConstant.COMPANY
			+ "`, `" + "WHERE `" + DBNameConstant.COMPANY + "`.`"
			+ DBNameConstant.COMPANY_ID + "`= ? ");

	// SQL query to insert a new company
	public static final String SQL_INSERT_COMPANY = ("INSERT INTO `"
			+ DBNameConstant.COMPANY + "`(`" + DBNameConstant.COMPANY_NAME
			+ "`, `" + DBNameConstant.TYPE + "`, `" + DBNameConstant.COMPANY_ID
			+ "`, `" + DBNameConstant.COLOR + "`, `" + DBNameConstant.PRICE
			+ "`) " + "VALUES (?, ?, ?, ?, ?)");

	// SQL query to search company(s)
	public static final String SQL_SEARCH_COMPANY = ("SELECT `"
			+ DBNameConstant.COMPANY_ID + "`, `" + DBNameConstant.COMPANY_NAME
			+ "`, `" + DBNameConstant.TYPE + "`, `"
			+ DBNameConstant.COMPANY_NAME + "`, `" + DBNameConstant.COUNTRY
			+ "`, `" + DBNameConstant.COLOR + "`, `" + DBNameConstant.PRICE
			+ "` " + "FROM `" + DBNameConstant.COMPANY + "`, `"
			+ DBNameConstant.COMPANY + "` " + "WHERE `"
			+ DBNameConstant.COMPANY + "`.`" + DBNameConstant.COMPANY_ID
			+ "`=`" + DBNameConstant.COMPANY + "`.`"
			+ DBNameConstant.COMPANY_ID + "` "
			+ "AND `?` LIKE '%?%' ORDER BY `" + DBNameConstant.COMPANY_ID + "`");

	// SQL query to update an old company
	public static final String SQL_UPDATE_COMPANY = ("UPDATE `"
			+ DBNameConstant.COMPANY + "` " + "SET `"
			+ DBNameConstant.COMPANY_NAME + "`= ?, `" + DBNameConstant.TYPE
			+ "`= ?, `" + DBNameConstant.COMPANY_ID + "`= ?, `"
			+ DBNameConstant.COLOR + "`= ?, `" + DBNameConstant.PRICE + "`= ? "
			+ "WHERE `" + DBNameConstant.COMPANY_ID + "`= ?");

	// SQL query to delete a company
	public static final String SQL_DELETE_COMPANY = ("DELETE FROM `"
			+ DBNameConstant.COMPANY + "` WHERE `" + DBNameConstant.COMPANY_ID + "`= ?");
}
