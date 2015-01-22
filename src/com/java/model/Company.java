package com.java.model;

public class Company {
	
	// Attributes of class Company
	private int companyID;
	private String companyName;
	private String country;

	/**
	 * Constructor without parameters
	 */
	public Company() {}

	/**
	 * Constructor with parameters
	 * @param newCompanyID
	 * @param newCompanyName
	 * @param newCountry
	 */
	public Company(int newCompanyID, String newCompanyName, String newCountry) {
		this.setCompanyID(newCompanyID);
		this.setCompanyName(newCompanyName);
		this.setCountry(newCountry);
	}
	
	/**
	 * @return the companyID
	 */
	public int getCompanyID() {
		return companyID;
	}
	/**
	 * @param companyID the companyID to set
	 */
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
