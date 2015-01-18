package com.java.servlet;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.java.dao.*;
import com.java.model.*;

/**
 * Servlet implementation class DeviceUpdateServlet
 */
@WebServlet("/DeviceUpdateServlet")
public class DeviceUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeviceUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Device d = new Device();
		DeviceDao dDao = new DeviceDao();
		int id = Integer.parseInt(request.getParameter("id").toString());

		d.setDeviceName(request.getParameter("dName"));
		d.setType(request.getParameter("dType"));
		d.setCompanyID(Integer.parseInt(request.getParameter("dCompany")));
		d.setColor(request.getParameter("dColor"));
		d.setPrice(Integer.parseInt(request.getParameter("dPrice")));

		try {
			dDao.updateDevice(id, d);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
