package com.java.model;

//enumeration type of distinct companies
public enum ECompany {
	Apple(1), Asus(2), Samsung(3), Dell(4), Lenovo(5);

	// company id for each of name
	public int company_id;

	// setter of company value
	private ECompany(int company_id) {
		this.company_id = company_id;
	}
}
