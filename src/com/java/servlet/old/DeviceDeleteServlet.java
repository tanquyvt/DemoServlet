package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bean.DeviceInfoBean;
import com.java.devicedao.DeviceDao;

/**
 * Servlet implementation class DeviceDeleteServlet
 */
@WebServlet("/DeviceDeleteServlet")
public class DeviceDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeviceDeleteServlet() {
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
//		DeviceInfoBean d;

		try {

			dao.deleteDevice(id);

//			request.setAttribute("dUp", d);

//			RequestDispatcher despatch = request.getRequestDispatcher("delete.jsp");
//
//			despatch.forward(request, response);
			
			response.sendRedirect("delete.jsp");

		} catch (ClassNotFoundException | SQLException e) {
			out.println(e.getMessage());
		}

	}

}
