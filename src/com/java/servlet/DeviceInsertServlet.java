package com.java.servlet;

import java.io.IOException;
//import java.sql.SQLException;

import java.io.PrintWriter;
import java.sql.SQLException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dbutil.OpenDatabase;
import com.java.devicedao.InsertNewDevice;
import com.java.model.Device;
import com.java.model.Laptop;
import com.java.model.Mobile;
import com.java.model.Tablet;

/**
 * Servlet implementation class DeviceInsertServlet
 */
@WebServlet("/DeviceInsertServlet")
public class DeviceInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Device d = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeviceInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/hrml");
		PrintWriter out = response.getWriter();

		String dName = request.getParameter("dName");
		String dCompany = request.getParameter("dCompany");
		String dType = request.getParameter("dType");
		String dColor = request.getParameter("dColor");
		int dPrice = Integer.parseInt(request.getParameter("dPrice"));

		out.println("<html>");
		out.println("<head><title>Insert Device</title></head>");
		out.println("<body>");
		out.println("<h2>Name: " + dName + "</h2>");
		out.println("<h2>Company: " + dCompany + "</h2>");
		out.println("<h2>Type: " + dType + "</h2>");
		out.println("<h2>Color: " + dColor + "</h2>");
		out.println("<h2>Price: " + dPrice + "</h2>");
		out.println("</body></html>");

		switch (dType) {
		case "1":
			d = new Mobile(dName, dCompany, dColor, dPrice);
			break;
		case "2":
			d = new Laptop(dName, dCompany, dColor, dPrice);
			break;
		case "3":
			d = new Tablet(dName, dCompany, dColor, dPrice);
			break;

		default:
			break;
		}

		try {
			new InsertNewDevice(d);
			out.println(OpenDatabase.results);
		} catch (SQLException sqlException) {
			OpenDatabase.results = sqlException.getMessage();
		} catch (ClassNotFoundException classNotFound) {
			OpenDatabase.results = classNotFound.getMessage();
		}
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
