package com.java.servlet;

import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bean.DeviceInfoBean;
import com.java.devicedao.DeviceDao;

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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id").toString());

		DeviceDao dao = new DeviceDao();
		DeviceInfoBean d;

		try {

			d = dao.viewDeviceDetails(id);

			request.setAttribute("dUp", d);

			RequestDispatcher despatch = request.getRequestDispatcher("u2.jsp");
			
			despatch.forward(request, response);
			

		} catch (ClassNotFoundException | SQLException e) {
			out.println(e.getMessage());
		}
	}

}
