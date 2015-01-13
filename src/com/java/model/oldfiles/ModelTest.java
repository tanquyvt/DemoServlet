package com.java.model;

// Initial test for Device classes
public class ModelTest {

	public static void main(String[] args) {
		Device mobile1 = new Mobile("Asus Zenfone A450", "0002", "Black", 2499000);
		Device tablet1 = new Tablet("Samsung Galaxy Tab 3", "0003", "White", 8990000);
		Device laptop1 = new Laptop("Dell Inspiron 15", "0004", "Silver", 15100000);
		mobile1.viewInfo(); tablet1.viewInfo(); laptop1.viewInfo();
	}

}
