package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bean.DeviceInfoBean;
import com.java.dao.DeviceDao;
import com.java.model.Device;

/**
 * Servlet implementation class DeviceServlet
 */
@WebServlet("/DeviceServlet")
public class DeviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Create a logger for this class
	private static final Logger log = Logger.getLogger(DeviceServlet.class
			.getName());

	// Create a logging handle for display on console
	Handler lh = new ConsoleHandler();

	public enum eCompany {
		Apple(1), Asus(2), Samsung(3), Dell(4), Lenovo(5);
		private int company_id;

		private eCompany(int company_id) {
			this.company_id = company_id;
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeviceServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String[] url = request.getRequestURI().split("/");
		// System.out.println(request.getRequestURL());
		// System.out.println(request.getServletPath());
		// /Servlet[1]/device[2]/list[3]
		// /Servlet[1]/device[2]/detail[3]

		// for (int i = 0; i < url.length; i++) {
		// System.out.println("url[" + i + "]= " + url[i]);
		// }

		// System.out.println(url[2]);
		switch (url[3]) {
		case "list":
			listAll(request, response);
			break;
		case "detail":
			int uid = Integer.parseInt(url[4]);
			// System.out.println(uid);
			viewDetails(request, response, uid);
			break;
		case "edit":
			int eUID = Integer.parseInt(url[4]);
			editDevice(request, response, eUID);
			break;

		default:
			System.out.println("Default.");
			break;
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

	public void listAll(HttpServletRequest req, HttpServletResponse res) {

		res.setContentType("text/html");

		// logger level initiate
		log.setLevel(Level.INFO);

		// using console handler
		log.addHandler(lh);

		// set response content type
		res.setContentType("text/html");

		// Declare response output variable
		PrintWriter out = null;

		try {

			// Assign writer to a variable
			out = res.getWriter();
		} catch (IOException e1) {
			log.log(Level.WARNING, "[x]IOException: " + e1);
		}

		// Declare a DAO variable
		DeviceDao dAccessObj;

		// Assign new DAO object to a variable
		dAccessObj = new DeviceDao();

		// Declare a list of Device object
		List<Device> dList = null;

		// implement logic operation to check if exception occur
		try {

			// assign return value of all devices to list
			dList = dAccessObj.viewAllDevices();
			// catch and log exception
		} catch (ClassNotFoundException e) {

			// display detail of exception (if exist) to console
			// logging here
			log.log(Level.WARNING, "[x]ClassNotFoundException: " + e);
		} catch (SQLException e) {

			// display detail of exception (if exist) to console
			log.log(Level.WARNING, "[x]SQLException: " + e);
		}

		// Displaying HTML output
		out.println("<html>");
		out.println("<head><title>List device</title>");
		// out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id=\"content\">");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>ID</th>");
		out.println("<th>Name</td>");
		out.println("</tr>");

		Iterator<Device> itr = dList.iterator();
		while (itr.hasNext()) {
			Device device = (Device) itr.next();
			out.println("<tr>");
			out.println("<td>" + device.getDeviceID() + "</td>");
			out.println("<td><a href=\"detail/" + device.getDeviceID() + "\">"
					+ device.getDeviceName() + "</a></td>");
			out.println("<td><a href=\"edit/" + device.getDeviceID()
					+ "\">Edit</a></td>");
			out.println("</tr>");
		}

		out.println("<table>");
		out.println("</div>");
	}

	public void viewDetails(HttpServletRequest req, HttpServletResponse res,
			int id) {
		// set response content type
		res.setContentType("text/html");

		// implement logic operation to check if exception occur
		PrintWriter out = null;
		// declare a DAO instance
		DeviceDao dao = new DeviceDao();

		//
		DeviceInfoBean details = null;
		try {

			// store device details
			details = dao.viewDeviceDetails(id);
			// output variable
			out = res.getWriter();

		} catch (SQLException | ClassNotFoundException | IOException e) {

			// display detail of exception (if exist) to console
			log.log(Level.WARNING, e.toString());
		}

		// Displaying HTML output
		out.println("<html>");
		out.println("<head><title>detail device</title>");
		// out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id=\"content\">");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>ID</th>");
		out.println("<th>Name</td>");
		out.println("<th>Type</td>");
		out.println("<th>Company</td>");
		out.println("<th>Color</td>");
		out.println("<th>Price</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>" + details.getDeviceID() + "</td>");
		out.println("<td>" + details.getDeviceName() + "</td>");
		out.println("<td>" + details.getType() + "</td>");
		out.println("<td>" + details.getCompanyName() + "</td>");
		out.println("<td>" + details.getColor() + "</td>");
		out.println("<td>" + details.getPrice() + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		// out.println("<td><a href=\"/edit/" + details.getDeviceID()
		// + "\">Edit</a></td>");
		out.println("<tr>");
		out.println("</table>");
		out.println("</div>");
	}

	public void editDevice(HttpServletRequest req, HttpServletResponse res,
			int id) {
		res.setContentType("text/html");
		PrintWriter out;

		// int id = Integer.parseInt(request.getParameter("id").toString());

		DeviceDao dDao = new DeviceDao();
		// CompanyDao cDao = new CompanyDao();

		String[] tList = { "Laptop", "Mobile", "Tablet" };
		DeviceInfoBean details;

		viewDetails(req, res, id);

		try {
			out = res.getWriter();
			details = dDao.viewDeviceDetails(id);

			// Displaying HTML output
			out.println("<html>");
			out.println("<head><title>Edit device</title>");
			// out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<div id=\"content\">");
			out.println("<hr>");
			out.println("<h2>New information to update</h2>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>Name</td>");
			out.println("<th>Type</td>");
			out.println("<th>Company</td>");
			out.println("<th>Color</td>");
			out.println("<th>Price</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>" + details.getDeviceID() + "</td>");
			out.println("<td><input type=\"text\" value=\""
					+ details.getDeviceName() + "\"></input></td>");
			// device type drop down list
			out.println("<td>");
			out.println("<select name=\"dType\">");

			for (int i = 0; i < tList.length; i++) {
				if (tList[i].trim().equals(details.getType().trim())) {
					// System.out.println(tList[i].equals(details.getType()));
					out.println("<option value=\"" + details.getType()
							+ "\" selected=\"selected\">" + details.getType()
							+ "</option>");
				} else {
					out.println("<option value=\"" + tList[i] + "\">"
							+ tList[i] + "</option>");
				}
			}

			out.println("</select>");
			out.println("</td>");
			// device company drop down list
			out.println("<td>");
			out.println("<select name=\"dCompanyID\">");
			for (eCompany cName : eCompany.values()) {
				if (cName.toString().trim()
						.equalsIgnoreCase(details.getCompanyName().trim())) {
					System.out.println("true");
					out.println("<option value=\"" + details.getCompanyID()
							+ "\" selected=\"selected\">"
							+ details.getCompanyName() + "</option>");
				} else {
					out.println("<option value=\"" + cName.company_id + "\">"
							+ cName + "</option>");
				}
			}
			out.println("</select>");
			out.println("</td>");

			out.println("<td>" + details.getColor() + "</td>");
			out.println("<td>" + details.getPrice() + "</td>");
			
			out.println("</tr>");
//			out.println("<tr>");
//
//			out.println("<tr>");
			out.println("</table>");
			out.println("<hr>");
			
			out.println("<input type=\"submit\" value=\"Update\">");
			out.println("</div>");
		} catch (ClassNotFoundException | SQLException | IOException e1) {
			e1.printStackTrace();
		}
	}
}
