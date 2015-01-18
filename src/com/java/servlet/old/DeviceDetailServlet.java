package com.java.servlet;

import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.java.bean.*;
import com.java.dao.*;

/**
 * Servlet implementation class DeviceDetailServlet
 */
@WebServlet("/DeviceDetailServlet")
public class DeviceDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeviceDetailServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// set response content type
		response.setContentType("text/html");

		// assign parameter to a variable
		int id = Integer.parseInt(request.getParameter("id").toString());

		// implement logic operation to check if exception occur
		try {

			// declare a dao instance
			DeviceDao dao = new DeviceDao();

			// assign return values to list
			DeviceInfoBean d = dao.viewDeviceDetails(id);

			// set list to named attribute for passing value to jsp content
			request.setAttribute("device", d);

			// Initiate dispatching file variable
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("detaildevicecontent.jsp");

			// Forward to the view
			dispatcher.forward(request, response);

			// Catch exception
		} catch (SQLException | ClassNotFoundException e) {

			// display detail of exception (if exist) to console
			e.printStackTrace();
		}

	}

}
