package com.java.servlet;

//	Import required java libraries
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.DeviceDao;
import com.java.dao.InterfaceDeviceDao;
import com.java.model.Device;

/**
 * Servlet implementation class DeviceListServlet Extend HttpServlet class
 */
@WebServlet("/DeviceListServlet")
public class DeviceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Handle GET requests from URL
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// set response content type
		response.setContentType("text/html");

		//
		// PrintWriter out = response.getWriter();

		// Declare a DeviceDao instance
		InterfaceDeviceDao dAccessObj = new DeviceDao();

		// Declare a list of Device object
		List<Device> dList;

		// implement logic operation to check if exception occur
		try {

			// assign return value of all devices to list
			dList = dAccessObj.viewAllDevices();

			// set list to "device" attribute for passing value to jsp content
			request.setAttribute("device", dList);

			// Initiate dispatching file variable
			RequestDispatcher despatch = request
					.getRequestDispatcher("listdevicecontent.jsp");

			// Forward to the view
			despatch.forward(request, response);

			// Catch exception
		} catch (ClassNotFoundException | SQLException e) {

			// display detail of exception (if exist) to console
			e.printStackTrace();
		}

	}
}
