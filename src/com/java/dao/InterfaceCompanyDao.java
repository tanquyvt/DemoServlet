package com.java.dao;

import java.sql.SQLException;
import java.util.List;
import com.java.model.Company;

public interface InterfaceCompanyDao {
	
	/**
	 * View all companies method
	 * @return List<Company>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * 
	 * Test Successful!
	 */
	public List<Company> viewAllCompanies()
			throws SQLException, ClassNotFoundException;
	
	/**
	 * View company's details method
	 * @param id
	 * @return Company
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * 
	 * Test Successful!
	 */
	public Company viewCompanyDetails(int id)
			throws SQLException, ClassNotFoundException;
	
	/**
	 * Insert new company method
	 * @param newCompany
	 * @return insertedCompany
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * 
	 * Test Successful!
	 */
	public Company insertNewCompany(Company newCompany)
			throws SQLException, ClassNotFoundException;
	
	/**
	 * Update a company
	 * @param id
	 * @param updateValues
	 * @return updatedCompany
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * 
	 * Test Successful!
	 */
	public Company updateCompany(int id, String[] updateValues)
			throws SQLException, ClassNotFoundException ;
	
	/**
	 * Search company(s)
	 * @param tableField
	 * @param stringToSearch
	 * @return List<Company>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * 
	 * Test Successful!
	 */
	public List<Company> searchCompany(String tableField, String stringToSearch)
			throws SQLException, ClassNotFoundException; 
	
	/**
	 * Delete a company
	 * @param id
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * 
	 * Test Successful!
	 */
	public void deleteCompany(int id) throws SQLException, ClassNotFoundException;
	
	/**
	 * 
	 */
	public void writeLog();
}