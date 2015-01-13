package com.java.servlet;

import java.util.*;
import java.io.*;
import java.sql.*;

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

		try {
			Accessible dAccessObj = new DeviceDao();
			List<Device> dList = dAccessObj.viewAllDevices();

			out.println("<html>");
			out.println("<head><title>List Device</title></head>");
			out.println("<body>");
			out.println("<h2>View Device List</h2>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>Device ID</th>");
			out.println("<th>Device Name</th>");
			out.println("</tr>");
			for (int i = 0; i < dList.size(); i++) {
				out.println("<tr>");
				out.print("<td>" + dList.get(i).getDeviceID() + "</td>");
				out.println("<td><a href=" + ">" + dList.get(i).getDeviceName() + "</a></td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body></html>");
		} catch (SQLException sqlException) {
			out.println("<p style=\"color: red\">" + sqlException.getMessage() + "</p>");
		} catch (ClassNotFoundException classNotFound) {
			out.println("<p style=\"color: red\">" + classNotFound.getMessage() + "</p>");
		}
	}
}
