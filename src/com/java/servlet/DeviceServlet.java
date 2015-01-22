package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
import com.java.dao.InterfaceDeviceDao;
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

	// enumeration type of distinct companies
	public enum eCompany {
		Apple(1), Asus(2), Samsung(3), Dell(4), Lenovo(5);

		// company id for each of name
		private int company_id;

		// setter of company value
		private eCompany(int company_id) {
			this.company_id = company_id;
		}
	}

	// enumeration type of distinct colors
	public enum eColor {
		Silver, Black, White, Pink, Yellow, Blue, Red, Green
	}

	// decimal format for display price
	DecimalFormat decim = new DecimalFormat("0.00");

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
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// request.getRequestDispatcher(arg0);
		// get id on URI
		String[] url = request.getRequestURI().split("/");

		// switch suitable manipulation
		switch (url[3]) {
		case "list":
			listAll(request, response);
			break;
		case "detail":
			int uid = Integer.parseInt(url[4]);
			viewDetails(request, response, uid);
			break;
		case "edit":
			int eUID = Integer.parseInt(url[4]);
			viewDetails(request, response, eUID);
			editDevice(request, response, eUID);
			break;
		case "update":
			int UID = Integer.parseInt(url[4]);
			updateDevice(request, response, UID);
			break;
		case "insert":
			insertDevice(request, response);
			break;
		case "delete":
			int id = Integer.parseInt(url[4]);
			deleteDevice(request, response, id);
			break;
		case "search":
			// int id = Integer.parseInt(url[4]);
			searchDevice(request, response);
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

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	public void listAll(HttpServletRequest req, HttpServletResponse res) {

		// set content to HTML/Text
		res.setContentType("text/html");

		// logger level initiate
		log.setLevel(Level.WARNING);

		// using console handler
		log.addHandler(lh);

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

		Iterator<Device> itr = null;

		try {
			// display device list by using loop (iterator)
			itr = dList.iterator();
		} catch (NullPointerException e) {
			log.log(Level.WARNING, "[x]NullPointerException: " + e);
		}

		if (itr != null) {
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

			while (itr.hasNext()) { // not null
				Device device = itr.next();
				out.println("<tr>");
				out.println("<td>" + device.getDeviceID() + "</td>");
				out.println("<td><a href=\"detail/" + device.getDeviceID()
						+ "\">" + device.getDeviceName() + "</a></td>");
				out.println("<td><a href=\"update/" + device.getDeviceID()
						+ "\">Update</a></td>");
				out.println("<td><a href=\"delete/" + device.getDeviceID()
						+ "\">Delete</a></td>");
				out.println("</tr>");
			} // end of loop
		} else {
			// display some text other than error page
			out.println("<h2>Something wrong, sorry for that.</2>");
			out.println("<a href=\"/DemoServlet\">Back home</a>");
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

		// initiate details variable
		DeviceInfoBean details = null;
		try {

			// store device details
			details = dao.viewDeviceDetails(id);
			// output variable
			out = res.getWriter();

		} catch (SQLException | ClassNotFoundException | IOException
				| NullPointerException e) {

			// display detail of exception (if exist) to console
			log.log(Level.WARNING, e.toString());

			// display some text other than error page
			out.println("<h2>Something wrong, sorry for that.</2>");
			out.println("<a href=\"/DemoServlet\">Back home</a>");
		}

		// Displaying HTML output
		out.println("<html>");
		out.println("<head><title>detail device</title>");
		// out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id=\"content\">");
		out.println("<h2>Detail informations</h2>");
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
		out.println("<td align=\"right\" size=50>" + details.getPrice()
				+ "</td>");
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

		DeviceDao dDao = new DeviceDao();
		// CompanyDao cDao = new CompanyDao();

		String[] tList = { "Laptop", "Mobile", "Tablet" };
		DeviceInfoBean details;

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
			out.println("<h2>New informations to update</h2>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>Name</td>");
			out.println("<th>Type</td>");
			out.println("<th>Company</td>");
			out.println("<th>Color</td>");
			out.println("<th>Price</td>");
			out.println("</tr>");

			out.println("<form action=\"\" method=\"GET\">");

			out.println("<tr>");
			out.println("<td>" + details.getDeviceID() + "</td>");
			out.println("<td><input type=\"text\" name=\"dName\" value=\""
					+ details.getDeviceName() + "\"></input></td>");
			// device type drop down list
			out.println("<td>");
			out.println("<select name=\"dType\">");

			for (int i = 0; i < tList.length; i++) {
				if (tList[i].trim().equals(details.getType().trim())) {
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
					// System.out.println("true");
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

			// device color drop down list
			out.println("<td>");
			out.println("<select name=\"dColor\">");

			for (eColor colorName : eColor.values()) {
				if (colorName.toString().trim()
						.equalsIgnoreCase(details.getColor().trim())) {
					// System.out.println("true");
					out.println("<option value=\"" + details.getColor()
							+ "\" selected=\"selected\">" + details.getColor()
							+ "</option>");
				} else {
					out.println("<option value=\"" + colorName + "\">"
							+ colorName + "</option>");
				}
			}

			out.println("</select>");
			out.println("</td>");
			// price input
			out.println("<td><input type=\"text\" name=\"dPrice\" value=\""
					+ decim.format(details.getPrice()) + "\"></td>");

			out.println("</tr>");
			out.println("</table>");
			out.println("<hr>");

			out.println("<input type=\"submit\" name=\"submit\" value=\"update\">");
			out.println("</form>");

			out.println("</div>");
		} catch (ClassNotFoundException | SQLException | IOException e1) {

		}
	}

	public void updateDevice(HttpServletRequest req, HttpServletResponse res,
			int id) {
		res.setContentType("text/html");
		PrintWriter out;
		// variable for passing value to method
		Device d = new Device();
		// DeviceDao instance
		DeviceDao dDao = new DeviceDao();
		// check make change or not
		String submit = req.getParameter("submit");
		if (submit != null && submit.equals("update")) {

			d.setDeviceName(req.getParameter("dName"));
			d.setType(req.getParameter("dType"));
			d.setCompanyID(Integer.parseInt(req.getParameter("dCompanyID")));
			d.setColor(req.getParameter("dColor"));
			d.setPrice(Double.parseDouble(req.getParameter("dPrice")));

			try {
				out = res.getWriter();
				dDao.updateDevice(id, d);
				out.println("<h2><font color=\"green\">Update successful.</font></h2>");

			} catch (ClassNotFoundException | SQLException | IOException e) {
				e.printStackTrace();
			}
			// After success, redisplay details
			viewDetails(req, res, id);
			// and form for next change
			editDevice(req, res, id);
		} else {
			// Not submit yet, display current detail information
			viewDetails(req, res, id);
			// and form to get change
			editDevice(req, res, id);
		}

	}

	public void insertDevice(HttpServletRequest req, HttpServletResponse res) {

		res.setContentType("text/html");
		PrintWriter out = null;

		try {
			out = res.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String submit = req.getParameter("submit");

		if (submit != null && submit.equals("add")) {

			String dName = req.getParameter("dName");
			String dType = req.getParameter("dType");
			int dCompanyID = Integer.parseInt(req.getParameter("dCompanyID"));
			String dColor = req.getParameter("dColor");
			double dPrice = Double.parseDouble(req.getParameter("dPrice"));

			Device dObj = new Device();

			dObj.setDeviceName(dName);
			dObj.setType(dType);
			dObj.setCompanyID(dCompanyID);
			dObj.setColor(dColor);
			dObj.setPrice(dPrice);

			try {
				DeviceDao dAccessObj = new DeviceDao();
				Device dNew = dAccessObj.insertNewDevice(dObj);

				out.println("<html>");
				out.println("<head><title>Insert Device</title></head>");
				out.println("<body>");
				out.println("<h2>Insert Device Succesful!</h2>");
				out.println("<table>");
				out.println("<tr>");
				out.println("<th>ID</th>");
				out.println("<th>Name</th>");
				out.println("<th>Type</th>");
				out.println("<th>Color</th>");
				out.println("<th>Price</th>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>" + dNew.getDeviceID() + "</td>");
				out.println("<td>" + dNew.getDeviceName() + "</td>");
				out.println("<td>" + dNew.getType() + "</td>");
				out.println("<td>" + dNew.getColor() + "</td>");
				out.println("<td>" + dNew.getPrice() + "</td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</body></html>");
			} catch (SQLException sqlException) {
				out.println("<p style=\"color: red\">"
						+ sqlException.getMessage() + "</p>");
			} catch (ClassNotFoundException classNotFound) {
				out.println("<p style=\"color: red\">"
						+ classNotFound.getMessage() + "</p>");
			}

		}

		out.println("<form action=\"\" method=\"get\">");
		out.println("<h2>Insert device</h2>");
		out.println("<table>");
		out.println("<tr><td>Name:</td><td><input type=\"text\" name=\"dName\" required=\"required\"></td></tr>");
		out.println("<tr><td>Type:</td><td><select name=\"dType\">");
		out.println("<option value=\"Laptop\">Laptop</option>");
		out.println("<option value=\"Mobile\">Mobile</option>");
		out.println("<option value=\"Tablet\">Tablet</option>");
		out.println("</select></td></tr>");
		out.println("<tr><td>Company:</td><td><select name=\"dCompanyID\">");
		for (eCompany cName : eCompany.values()) {
			out.println("<option value=\"" + cName.company_id + "\">" + cName
					+ "</option>");
		}
		out.println("</select></td></tr>");
		out.println("<tr><td>Color:</td><td><select name=\"dColor\">");
		out.println("<option value=\"Black\">Black</option>");
		out.println("<option value=\"Black\">White</option>");
		out.println("<option value=\"Black\">Blue</option>");
		out.println("<option value=\"Black\">Red</option>");
		out.println("<option value=\"Black\">Yellow</option>");
		out.println("<option value=\"Black\">Silver</option>");
		out.println("<option value=\"Black\">Green</option>");
		out.println("</select></td></tr>");
		out.println("<tr><td>Price:</td><td><input type=\"text\" name=\"dPrice\" required></td></tr>");
		out.println("</table>");
		out.println("<input type=\"submit\" name=\"submit\" value=\"add\">");
		out.println("</form>");

	}

	public void deleteDevice(HttpServletRequest req, HttpServletResponse res,
			int id) {

		res.setContentType("text/html");
		PrintWriter out = null;
		try {
			out = res.getWriter();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		DeviceDao dao = new DeviceDao();
		// DeviceInfoBean d;

		try {

			dao.deleteDevice(id);

		} catch (ClassNotFoundException | SQLException e) {

		}
		out.println("<h2>Delete successful</h2>");
	}

	public void searchDevice(HttpServletRequest req, HttpServletResponse res) {
		res.setContentType("text/html");
		PrintWriter out = null;
		try {
			out = res.getWriter();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String submit = req.getParameter("submit");
		if (submit != null && submit.equals("search")) {
			String sValue = req.getParameter("sValue");
			String sField = req.getParameter("sField");

			InterfaceDeviceDao dao = new DeviceDao();
			List<DeviceInfoBean> dBean = null;

			try {

				dBean = dao.searchDevice(sField, sValue);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			out.println("<html>");
			out.println("<head><title>Search Result</title></head>");
			out.println("<body>");
			out.println("<h2>Search Result</h2>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>Name</th>");
			out.println("<th>Type</th>");
			out.println("<th>Company</th>");
			out.println("<th>Country</th>");
			out.println("<th>Color</th>");
			out.println("<th>Price</th>");
			out.println("</tr>");

			Iterator<DeviceInfoBean> itr = dBean.iterator();

			while (itr.hasNext()) {
				DeviceInfoBean data = (DeviceInfoBean) itr.next();
				out.println("<tr>");
				out.println("<td>" + data.getDeviceID() + "</td>");
				out.println("<td>" + data.getDeviceName() + "</td>");
				out.println("<td>" + data.getType() + "</td>");
				out.println("<td>" + data.getCompanyName() + "</td>");
				out.println("<td>" + data.getCountry() + "</td>");
				out.println("<td>" + data.getColor() + "</td>");
				out.println("<td>" + data.getPrice() + "</td>");
				out.println("</tr>");

			}

			out.println("</table>");

		} else {
			{
				out.println("<h2>Search device</h2>");
				out.println("<form action=\"\" method=\"get\">");
				out.println("<input type=\"text\" name=\"sValue\" placeholder=\"Seach\" required> <select name=\"sField\">");
				out.println("<option value=\"device_name\">Name</option>");
				out.println("<option value=\"type\">Type</option>");
				out.println("<option value=\"company_name\">Company</option>");
				out.println("<option value=\"country\">Country</option>");
				out.println("<option value=\"color\">Color</option>");
				out.println("<option value=\"price\">Price</option>");
				out.println("</select> <input type=\"submit\" name=\"submit\" value=\"search\">");
				out.println("</form>");
			}
		}

	}
}
