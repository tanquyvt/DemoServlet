package com.java.servlet;

import java.io.*;
import java.sql.*;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.java.bean.*;
import com.java.dao.*;
import com.java.model.*;

/**
 * Servlet implementation class DeviceUpdateServlet
 */
@WebServlet("/DeviceUpdateServlet")
public class DeviceUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeviceUpdateFormServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		// PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id").toString());

		DeviceDao dDao = new DeviceDao();
		CompanyDao cDao = new CompanyDao();

		List<Company> cList;
		DeviceInfoBean device;

		try {

			device = dDao.viewDeviceDetails(id);

			cList = cDao.viewAllCompanies();

			request.setAttribute("cList", cList);
			request.setAttribute("device", device);

			RequestDispatcher despatch = request
					.getRequestDispatcher("deviceformupdate.jsp");

			despatch.forward(request, response);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}

	}

}
