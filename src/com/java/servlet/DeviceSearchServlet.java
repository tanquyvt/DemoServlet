package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bean.DeviceInfoBean;
import com.java.devicedao.DeviceDao;

/**
 * Servlet implementation class DeviceSearchServlet
 */
@WebServlet("/DeviceSearchServlet")
public class DeviceSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeviceSearchServlet() {
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

		String sValue = request.getParameter("sValue");
		String sField = request.getParameter("sField");

		DeviceDao dao = new DeviceDao();
		try {
			List<DeviceInfoBean> dBean = dao.SearchDevice(sField, sValue);

			out.println("<html>");
			out.println("<head><title>Search Result</title></head>");
			out.println("<body>");
			out.println("<h2>View Search Result</h2>");

			if (dBean.size() == 0) {
				out.println("<p>There are no <b>" + sField + "</b> is <b>" + sValue + "</b></p>");
			} else {
				out.println("<table>");
				out.println("<tr>");
				out.println("<th>ID</th>");
				out.println("<th>Name</th>");
				out.println("<th>Type</th>");
				out.println("<th>Color</th>");
				out.println("<th>Price</th>");
				out.println("</tr>");

				for (int i = 0; i < dBean.size(); i++) {
					out.println("<tr>");
					out.println("<td>" + dBean.get(i).getDeviceID() + "</td>");
					out.println("<td>" + dBean.get(i).getDeviceName() + "</td>");
					out.println("<td>" + dBean.get(i).getType() + "</td>");
					out.println("<td>" + dBean.get(i).getColor() + "</td>");
					out.println("<td>" + dBean.get(i).getPrice() + "</td>");
					out.println("</tr>");
				}
				out.println("</table>");
				out.println("</body></html>");
			}

		} catch (SQLException sqlException) {
			out.println("<p style=\"color: red\">" + sqlException.getMessage()
					+ "</p>");
		} catch (ClassNotFoundException classNotFound) {
			out.println("<p style=\"color: red\">" + classNotFound.getMessage()
					+ "</p>");
		}
	}

}
