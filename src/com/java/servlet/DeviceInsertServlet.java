package com.java.servlet;

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
 * Servlet implementation class DeviceInsertServlet
 */
@WebServlet("/DeviceInsertServlet")
public class DeviceInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeviceInsertServlet() {
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
		
		String dName = request.getParameter("dName");
		String dType = request.getParameter("dType");
		int dCompanyId = Integer.parseInt(request.getParameter("dCompanyId"));
		String dColor = request.getParameter("dColor");
		int dPrice = Integer.parseInt(request.getParameter("dPrice")); 
		
		Device dObj = new Device();
		
		dObj.setDeviceName(dName);
		dObj.setType(dType);
		dObj.setCompanyID(dCompanyId);
		dObj.setColor(dColor);
		dObj.setPrice(dPrice);
		
		try {
			Accessible dAccessObj = new DeviceDao();
			Device dNew = dAccessObj.insertNewDevice(dObj);
			
			response.sendRedirect("insertsuccess.jsp");

//			out.println("<html>");
//			out.println("<head><title>Insert Device</title></head>");
//			out.println("<body>");
//			out.println("<h2>Insert Device Succesful!</h2>");
//			out.println("<table>");
//			out.println("<tr>");
//			out.println("<th>ID</th>");
//			out.println("<th>Name</th>");
//			out.println("<th>Type</th>");
//			out.println("<th>Color</th>");
//			out.println("<th>Price</th>");
//			out.println("</tr>");
//			out.println("<tr>");
//			out.println("<td>"+ dNew.getDeviceID() +"</td>");
//			out.println("<td>" + dNew.getDeviceName() +"</td>");
//			out.println("<td>"+ dNew.getType() +"</td>");
//			out.println("<td>"+ dNew.getColor() +"</td>");
//			out.println("<td>"+ dNew.getPrice() +"</td>");
//			out.println("</tr>");
//			out.println("</table>");
//			out.println("</body></html>");
		} catch (SQLException sqlException) {
			out.println("<p style=\"color: red\">" + sqlException.getMessage() + "</p>");
		} catch (ClassNotFoundException classNotFound) {
			out.println("<p style=\"color: red\">" + classNotFound.getMessage() + "</p>");
		}
	}

}
