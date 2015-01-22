package com.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.dbutil.DBNameConstant;
import com.java.dbutil.DatabaseUtility;
import com.java.dbutil.ResultRecord;
import com.java.model.Company;
import com.java.preparedsql.CompanyTableSql;

public class CompanyDao implements InterfaceCompanyDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.java.Companydao.InterfaceCompanyDao#viewAllCompanies()
	 */
	@Override
	public List<Company> viewAllCompanies() throws SQLException,
			ClassNotFoundException {

		// Initiate result list of companies
		List<Company> companies = new ArrayList<Company>();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		try {

			// Open database
			newDBUtil.openDatabase();

			// Create Statement for querying database
			newDBUtil.statement = newDBUtil.connection.prepareStatement(
					CompanyTableSql.SQL_VIEW_ALL);

			// Define result set with statement
			ResultSet rs = newDBUtil.statement.executeQuery();

			// Store the information of devices to device list
			ResultRecord rr = new ResultRecord(rs);
			for (int i = 0; i < rr.getTotalCount(); i++) {
				Company company = new Company();
				company.setCompanyID(Integer.parseInt(rr
						.getString(i, DBNameConstant.COMPANY_ID)));
				company.setCompanyName(rr.getString(i, DBNameConstant.COMPANY_NAME));
				companies.add(company);
			}

			// Return the device list
			return companies;
		} // End try

		// Exception handling
		catch (Exception exception) {

			throw exception;
		}

		// Clean up the connnection
		finally {

			// Close database
			newDBUtil.closeDatabase();
		}
	}

	
	/* (non-Javadoc)
	 * @see com.java.Companydao.InterfaceCompanyDao#viewCompanyDetails(int)
	 */
	@Override
	public Company viewCompanyDetails(int id) throws SQLException,
			ClassNotFoundException {

		// Initiate a list containing all the infomation of device
		Company company = new Company();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		try {

			// Open database
			newDBUtil.openDatabase();

			// Create Statement for querying database
			newDBUtil.statement = newDBUtil.connection.prepareStatement(
					CompanyTableSql.SQL_VIEW_DETAILS);
			newDBUtil.statement.setInt(1, id);

			// Define result set with statement
			ResultSet rs = newDBUtil.statement.executeQuery();

			// Get values of the specific device
			ResultRecord rr = new ResultRecord(rs);
			for (int i = 0; i < rr.getTotalCount(); i++) {
				company.setCompanyID(Integer.parseInt(
						rr.getString(i, DBNameConstant.COMPANY_ID)));
				company.setCompanyName(rr.getString(i, DBNameConstant.COMPANY_NAME));
				company.setCountry(rr.getString(i, DBNameConstant.COUNTRY));
			}

			// Return device information
			return company;
		} // End try

		// Exception handling
		catch (Exception exception) {

			throw exception;
		}

		// Clean up the connection
		finally {

			// Close database
			newDBUtil.closeDatabase();
		}
	}

	/* (non-Javadoc)
	 * @see com.java.Companydao.InterfaceCompanyDao#insertNewCompany(com.java.model.Company)
	 */
	@Override
	public Company insertNewCompany(Company newCompany) throws SQLException,
			ClassNotFoundException {

		// Initiate result device
		Company insertedCompany = new Company();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		try {
			// Open database
			newDBUtil.openDatabase();

			// Create Statement for querying database
			newDBUtil.statement = newDBUtil.connection.prepareStatement(
					CompanyTableSql.SQL_INSERT_COMPANY);

			// Add arguments to the query
			newDBUtil.statement.setString(1, newCompany.getCompanyName());
			newDBUtil.statement.setString(2, newCompany.getCountry());

			// Execute the statement
			newDBUtil.statement.executeUpdate();

			// create another statement to get the new ID
			newDBUtil.statement = newDBUtil.connection.prepareStatement(
					CompanyTableSql.SQL_LAST_ID);

			// Define result set with the statement
			ResultSet rs = newDBUtil.statement.executeQuery();

			// Get the values of the inserted device
			ResultRecord rr = new ResultRecord(rs);
			for (int i = 0; i < rr.getTotalCount(); i++) {
				if (Integer.parseInt(rr.getString(i, DBNameConstant.LAST_ID)) == 0) {
					break;
				}
				insertedCompany.setCompanyID(
						Integer.parseInt(rr.getString(i, DBNameConstant.LAST_ID)));
				insertedCompany.setCompanyName(newCompany.getCompanyName());
				insertedCompany.setCountry(newCompany.getCountry());
			}

			// Return the inserted device's information
			return insertedCompany;
		} // End try

		// Exception handling
		catch (Exception exception) {

			throw exception;
		}

		// Clean up the connection
		finally {

			// Close database
			newDBUtil.closeDatabase();
		}
	}

	/* (non-Javadoc)
	 * @see com.java.Companydao.InterfaceCompanyDao#updateCompany(int, java.lang.String[])
	 */
	@Override
	public Company updateCompany(int id, Company updateCompany)
			throws SQLException, ClassNotFoundException {

		// Initiate update device
		Company company = new Company();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		try {

			// Open database
			newDBUtil.openDatabase();

			// Create statement for querying database
			newDBUtil.statement = newDBUtil.connection.prepareStatement(
					CompanyTableSql.SQL_UPDATE_COMPANY);
			newDBUtil.statement.setString(1, updateCompany.getCompanyName());
			newDBUtil.statement.setString(2, updateCompany.getCountry());
			newDBUtil.statement.setInt(3, id);

			// Execute the statement
			newDBUtil.statement.executeUpdate();

			// Create another statement to view the updated information
			newDBUtil.statement = newDBUtil.connection.prepareStatement(
					CompanyTableSql.SQL_VIEW_DETAILS);
			newDBUtil.statement.setInt(1, id);

			// Define result set with statement
			ResultSet rs = newDBUtil.statement.executeQuery();

			// Get the values of the updated device
			ResultRecord rr = new ResultRecord(rs);
			for (int i = 0; i < rr.getTotalCount(); i++) {
				company.setCompanyID(Integer.parseInt(
						rr.getString(i, DBNameConstant.COMPANY_ID)));
				company.setCompanyName(rr.getString(i, DBNameConstant.COMPANY_NAME));
				company.setCountry(rr.getString(i, DBNameConstant.COUNTRY));
			}

			// Return the updated device's information
			return company;
		}

		catch (Exception exception) {

			throw exception;
		}

		finally {

			// Close database
			newDBUtil.closeDatabase();
		}
	}

	/* (non-Javadoc)
	 * @see com.java.Companydao.InterfaceCompanyDao#searchCompany(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Company> searchCompany(String tableField, String stringToSearch)
			throws SQLException, ClassNotFoundException {

		// Initiate search device
		List<Company> companies = new ArrayList<Company>();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		try {

			// Open database
			newDBUtil.openDatabase();

			// Create statement for querying database
			newDBUtil.statement = newDBUtil.connection.prepareStatement(
					CompanyTableSql.SQL_SEARCH_COMPANY);
			newDBUtil.statement.setString(1, tableField);
			newDBUtil.statement.setString(2, stringToSearch);

			// Define result set with statement
			ResultSet rs = newDBUtil.statement.executeQuery();

			// Get the values of the searched device(s)
			ResultRecord rr = new ResultRecord(rs);
			for (int i = 0; i < rr.getTotalCount(); i++) {
				Company company = new Company();
				company.setCompanyID(Integer.parseInt(
						rr.getString(i, DBNameConstant.COMPANY_ID)));
				company.setCompanyName(rr.getString(i, DBNameConstant.COMPANY_NAME));
				company.setCountry(rr.getString(i, DBNameConstant.COUNTRY));
				companies.add(company);
			}

			// Return the device's information after searching
			return companies;
		}

		catch (Exception exception) {

			throw exception;
		}

		finally {

			// Close database
			newDBUtil.closeDatabase();
		}
	}

	/* (non-Javadoc)
	 * @see com.java.Companydao.InterfaceCompanyDao#deleteCompany(int)
	 */
	@Override
	public void deleteCompany(int id) throws SQLException,
			ClassNotFoundException {

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		// Open database
		newDBUtil.openDatabase();

		// Create statement for querying database
		newDBUtil.statement = newDBUtil.connection.prepareStatement(
				CompanyTableSql.SQL_DELETE_COMPANY);
		newDBUtil.statement.setInt(1, id);

		// Execute the statement
		newDBUtil.statement.executeUpdate();

		// Close database
		newDBUtil.closeDatabase();
	}

	/* (non-Javadoc)
	 * @see com.java.Companydao.InterfaceCompanyDao#writeLog()
	 */
	@Override
	public void writeLog() {
		// TODO Auto-generated method stub

	}

}
