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
import com.java.model.Device;

/**
 * Servlet implementation class InsertDeviceServlet
 */
@WebServlet("/InsertDevice")
public class InsertDeviceServlet extends HttpServlet {
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

		// default value means that there are no exception
		boolean exceptionFlag = false;

		// default value means that there are no exception
		boolean validFlag = true;

		String dName = null;

		if (req.getParameter("dName") == null
				|| req.getParameter("dName").isEmpty()) {
			validFlag = false;
		} else {
			dName = req.getParameter("dName");
		}

		String dType = req.getParameter("dType");
		int dCompanyID = Integer.parseInt(req.getParameter("dCompanyID"));
		String dColor = req.getParameter("dColor");
		int dPrice = Integer.valueOf(req.getParameter("dPrice"));

		Device dObj = new Device();

		dObj.setDeviceName(dName);
		dObj.setType(dType);
		dObj.setCompanyID(dCompanyID);
		dObj.setColor(dColor);
		dObj.setPrice(dPrice);

		DeviceDao dDao = new DeviceDao();

		DeviceInfoBean dNew = null;

		// initiate dispatcher object to jsp file
		RequestDispatcher dispatch = req
				.getRequestDispatcher("/demo/contents/insert.jsp");

		try {
			dNew = dDao.insertNewDevice(dObj);
		} catch (ClassNotFoundException | SQLException e) {
			// assign flag to true if any exception are caught
			exceptionFlag = true;

			// display detail of exception (if exist) to console
			logger.log(Level.WARNING, "Exception log: " + e);
		}

		// set attributes for preparing dispatching
		req.setAttribute("eFlag", exceptionFlag);
		req.setAttribute("details", dNew);
		req.setAttribute("valid", validFlag);
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
