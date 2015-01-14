package com.java.servlet;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bean.DeviceInfoBean;
import com.java.devicedao.DeviceDao;

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
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String[] parts = request.getRequestURI().split("/");
		int id = Integer.parseInt(parts[3]);

		try {
			DeviceDao dao = new DeviceDao();
			DeviceInfoBean d = dao.viewDeviceDetails(id);

			out.println("<html>");
			out.println("<head><title>View:" + d.getDeviceName() + "</title></head>");
			out.println("<body>");
			out.println("<h2>View Detail</h2>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>Name</th>");
			out.println("<th>Type</th>");
			out.println("<th>Color</th>");
			out.println("<th>Price</th>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>" + d.getDeviceID() + "</td>");
			out.println("<td>" + d.getDeviceName() + "</td>");
			out.println("<td>" + d.getType() + "</td>");
			out.println("<td>" + d.getColor() + "</td>");
			out.println("<td>" + d.getPrice() + "</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</body></html>");
		} catch (SQLException sqlException) {
			out.println("<p style=\"color: red\">" + sqlException.getMessage()
					+ "</p>");
		} catch (ClassNotFoundException classNotFound) {
			out.println("<p style=\"color: red\">" + classNotFound.getMessage()
					+ "</p>");
		}

	}

}
