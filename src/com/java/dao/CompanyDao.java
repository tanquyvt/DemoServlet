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

			// create Statement for querying database
			newDBUtil.statement = newDBUtil.connection
					.prepareStatement(CompanyTableSql.SQL_VIEW_ALL);

			// Define result set with statement
			ResultSet rs = newDBUtil.statement.executeQuery();

			// Store the information of companies to company list
			ResultRecord rr = new ResultRecord(rs);
			for (int i = 0; i < rr.getTotalCount(); i++) {
				Company company = new Company();
				company.setCompanyID(Integer.parseInt(rr.getString(i,
						"company_id")));
				company.setCompanyName(rr.getString(i, "company_name"));
				companies.add(company);
			}

			// return the company list
			return companies;
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

	@Override
	public Company viewCompanyDetails(int id) throws SQLException,
			ClassNotFoundException {
		// Initiate a list containing all the information of company
		Company companyInfo = new Company();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		try {

			// Open database
			newDBUtil.openDatabase();

			// create Statement for querying database
			newDBUtil.statement = newDBUtil.connection
					.prepareStatement(CompanyTableSql.SQL_VIEW_DETAILS);
			newDBUtil.statement.setInt(1, id);

			// Define result set with statement
			ResultSet rs = newDBUtil.statement.executeQuery();

			// Get values of the specific company
			ResultRecord rr = new ResultRecord(rs);
			for (int i = 0; i < rr.getTotalCount(); i++) {
				companyInfo.setCompanyID(Integer.parseInt(rr.getString(i,
						DBNameConstant.COMPANY_ID)));
				companyInfo.setCompanyName(rr.getString(i,
						DBNameConstant.COMPANY_NAME));
				companyInfo.setCountry(rr.getString(i, DBNameConstant.COUNTRY));
			}

			return companyInfo;
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

	@Override
	public Company insertNewCompany(Company newCompany) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company updateCompany(int id, String[] updateValues)
			throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> searchCompany(String tableField, String stringToSearch)
			throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCompany(int id) throws SQLException,
			ClassNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeLog() {
		// TODO Auto-generated method stub

	}

}
