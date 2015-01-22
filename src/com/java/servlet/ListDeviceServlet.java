package com.java.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.DeviceDao;
import com.java.model.Device;

/**
 * Servlet implementation class ListDeviceServlet
 */
@WebServlet("/ListDevice")
public class ListDeviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Create a logger for this class
	private static final Logger logger = Logger
			.getLogger(ListDeviceServlet.class.getName());

	// Create a logging handle for display on console
	Handler lh = new ConsoleHandler();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * Processing Http GET request
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// logger level initiate
		logger.setLevel(Level.WARNING);

		// using console handler
		logger.addHandler(lh);

		// default value means that there are no exception
		boolean exceptionFlag = false;

		// initiate model object
		DeviceDao dObj = new DeviceDao();

		// initiate variable for storing device list
		List<Device> dList = null;

		// initiate dispatcher object to jsp file
		RequestDispatcher dispatch = req
				.getRequestDispatcher("/demo/contents/list.jsp");

		try {

			// assign result to list
			dList = dObj.viewAllDevices();
		} catch (ClassNotFoundException | SQLException e1) {

			// assign flag to true if any exception are caught
			exceptionFlag = true;

			// log exception message for debugging
			logger.log(Level.WARNING, "Exception log: " + e1);
		}

		// set attributes for preparing dispatching
		req.setAttribute("eFlag", exceptionFlag);
		req.setAttribute("devices", dList);

		// implement forward with attributes
		dispatch.forward(req, resp);
	}
}
