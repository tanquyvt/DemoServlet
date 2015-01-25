package com.java.model;

public class ColumnValues {
	
	// Set of colors
	private static final String[] colors = {"Black", "Yellow", "Blue", "White", "Pink", "Silver", "Red", "Purple",
		"Green", "Scarlet", "Grey"};
	
	// Set of types
	private static final String[] types = {"Mobile", "Tablet", "Laptop", "Accessory"};

	/**
	 * @return the colors
	 */
	public static String[] getColors() {
		return colors;
	}

	/**
	 * @return the types
	 */
	public static String[] getTypes() {
		return types;
	}
}
