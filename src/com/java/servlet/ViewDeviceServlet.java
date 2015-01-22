package com.java.servlet;

import java.io.IOException;
import java.sql.SQLException;
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

import com.java.bean.DeviceInfoBean;
import com.java.dao.DeviceDao;

/**
 * Servlet implementation class ViewDeviceServlet
 */
@WebServlet("/ViewDevice")
public class ViewDeviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Create a logger for this class
	private static final Logger logger = Logger
			.getLogger(ListDeviceServlet.class.getName());

	// Create a logging handle for display on console
	Handler lh = new ConsoleHandler();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		// logger level initiate
		logger.setLevel(Level.WARNING);

		// using console handler
		logger.addHandler(lh);

		// split uri into small parts
		String[] url = req.getRequestURI().split("/");

		// get value of id
		int id = Integer.parseInt(url[4]);

		// default value means that there are no exception
		boolean exceptionFlag = false;

		// declare a DAO instance
		DeviceDao dao = new DeviceDao();

		// initiate details variable
		DeviceInfoBean details = null;

		// initiate dispatcher object to jsp file
		RequestDispatcher dispatch = req
				.getRequestDispatcher("/demo/contents/view.jsp");
		try {

			// store device details
			details = dao.viewDeviceDetails(id);

		} catch (SQLException | ClassNotFoundException e) {

			// assign flag to true if any exception are caught
			exceptionFlag = true;

			// display detail of exception (if exist) to console
			logger.log(Level.WARNING, "Exception log: " + e);

		}

		// set attributes for preparing dispatching
		req.setAttribute("eFlag", exceptionFlag);
		req.setAttribute("details", details);
		// implement forward with attributes
		dispatch.forward(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
