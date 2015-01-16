package com.java.dao;

import java.sql.*;
import java.util.*;

import com.java.bean.*;
import com.java.dbutil.*;
import com.java.model.Device;
import com.java.preparedsql.*;

public class CompanyDao implements InterfaceCompanyDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.java.Companydao.InterfaceCompanyDao#viewAllCompanies()
	 */
	@Override
	public List<Company> viewAllCompanies() throws SQLException,
			ClassNotFoundException {

		// Initiate result list of Companys
		List<Company> companies = new ArrayList<Company>();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		// Open database
		newDBUtil.openDatabase();

		// Initiate the result set for viewing all the Companys
		ResultSet rs = newDBUtil.prepareViewAllCompanies();

		// Store the information of Companys to Company list
		while (rs.next()) {
			Company newCompany = new Company();
			newCompany.setCompanyID(Integer.parseInt(rs.getObject(1).toString()));
			newCompany.setCompanyName((String) rs.getObject(2));
			companies.add(newCompany);
		}

		return companies;
	}

	
	/* (non-Javadoc)
	 * @see com.java.Companydao.InterfaceCompanyDao#viewCompanyDetails(int)
	 */
	@Override
	public Company viewCompanyDetails(int id) throws SQLException,
			ClassNotFoundException {

		// Initiate a list containing all the infomation of Company
		Company company = new Company();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		// Open database
		newDBUtil.openDatabase();

		// Initiate the result set for
		// viewing details of a specific Company
		ResultSet rs = newDBUtil.prepareViewCompanyDetails(id);

		// Get values of the specific Company
		rs.next();
		company.setCompanyID(Integer.parseInt(rs.getObject(1).toString()));
		company.setCompanyName(rs.getObject(2).toString());
		company.setCountry(rs.getObject(3).toString());

		// Close database
		newDBUtil.closeDatabase();

		return company;
	}

	/* (non-Javadoc)
	 * @see com.java.Companydao.InterfaceCompanyDao#insertNewCompany(com.java.model.Company)
	 */
	@Override
	public Company insertNewCompany(Company newCompany) throws SQLException,
			ClassNotFoundException {

		// Initiate result Company
		Company insertedCompany = new Company();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		// Open database
		newDBUtil.openDatabase();

		// Create the result set for
		// inserting a new Company
		ResultSet rs = newDBUtil.prepareInsertCompany(newCompany);

		rs.next();
		insertedCompany.setCompanyID(Integer.parseInt(rs.getObject(1).toString()));
		insertedCompany.setCompanyName(newCompany.getCompanyName());
		insertedCompany.setCountry(newCompany.getCountry());

		// Close database
		newDBUtil.closeDatabase();

		return insertedCompany;
	}

	/* (non-Javadoc)
	 * @see com.java.Companydao.InterfaceCompanyDao#updateCompany(int, java.lang.String[])
	 */
	@Override
	public Company updateCompany(int id, String[] updateValues)
			throws SQLException, ClassNotFoundException {
		
		// Initiate update Company
		Company Company = new Company();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		// Open database
		newDBUtil.openDatabase();

		// Create result set for
		// updating the old Company
		ResultSet rs = newDBUtil.prepareUpdateCompany(id, updateValues);

		// Get the updated Company
		rs.next();
		Company.setCompanyID(Integer.parseInt(rs.getObject(1).toString()));
		Company.setCompanyName(rs.getObject(2).toString());
		Company.setCountry(rs.getObject(3).toString());

		// Close database
		newDBUtil.closeDatabase();

		return Company;
	}

	/* (non-Javadoc)
	 * @see com.java.Companydao.InterfaceCompanyDao#searchCompany(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Company> searchCompany(String tableField, String stringToSearch)
			throws SQLException, ClassNotFoundException {

		// Initiate result list of Companys
		List<Company> Companies = new ArrayList<Company>();

		// Create a database utility object
		DatabaseUtility newDBUtil = new DatabaseUtility();

		// Open database
		newDBUtil.openDatabase();

		// Initiate the result set for viewing all the Companys
		ResultSet rs = newDBUtil.prepareSearchCompany(tableField, stringToSearch);

		while (rs.next()) {
			Company company = new Company();
			company.setCompanyID(Integer.parseInt(rs.getObject(1).toString()));
			company.setCompanyName(rs.getObject(2).toString());
			company.setCountry(rs.getObject(3).toString());
			Companies.add(company);
		}

		// Close database
		newDBUtil.closeDatabase();

		return Companies;
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
		
		// Delete the chosen Company
		newDBUtil.deleteCompany(id);
		
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
