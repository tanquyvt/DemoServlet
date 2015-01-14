package com.java.servlet;

import java.util.*;
import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.devicedao.Accessible;
import com.java.devicedao.DeviceDao;
import com.java.model.Device;

/**
 * Servlet implementation class CompanyListServlet
 */
@WebServlet("/CompanyListServlet")
public class DeviceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeviceListServlet() {
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
		 PrintWriter out = response.getWriter();

		Accessible dAccessObj = new DeviceDao();
		List<Device> dList;
		try {
			dList = dAccessObj.viewAllDevices();
			request.setAttribute("device", dList);
			request.setAttribute("lSize", dList.size());
			
			RequestDispatcher despatch = request
					.getRequestDispatcher("listcontent.jsp");
			despatch.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			out.println(e.getMessage());
		}

	}
}
