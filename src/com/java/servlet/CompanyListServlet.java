package com.java.servlet;

//Import required java libraries
import java.util.*;
import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.java.dao.*;
import com.java.model.*;

/**
 * Servlet implementation class CompanyListServlet
 */
@WebServlet("/CompanyListServlet")
public class CompanyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// set response content type
		response.setContentType("text/html");

		// Declare a dao instance
		InterfaceCompanyDao cAccessObj = new CompanyDao();

		// Declare a list type object
		List<Company> cList;

		// implement logic operation to check if exception occur
		try {

			// assign return values to list
			cList = cAccessObj.viewAllCompanies();

			// set list to named attribute for passing value to jsp content
			request.setAttribute("company", cList);

			// Initiate dispatching file variable
			RequestDispatcher dispatch = request
					.getRequestDispatcher("listcompanycontent.jsp");

			// Forward to the view
			dispatch.forward(request, response);

			// Catch exception
		} catch (ClassNotFoundException | SQLException e) {

			// display detail of exception (if exist) to console
			e.printStackTrace();
		}
	}

}
