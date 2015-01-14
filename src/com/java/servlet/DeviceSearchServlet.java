package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
		List<DeviceInfoBean> dBean;
		
		try {

			dBean = dao.searchDevice(sField, sValue);

			request.setAttribute("dBean", dBean);
			request.setAttribute("dBeanSize", dBean.size());
			request.setAttribute("sValue", sValue);
			request.setAttribute("sField", sField);

			RequestDispatcher despatch = request.getRequestDispatcher("searchsuccess.jsp");
			
			despatch.forward(request, response);
			

		} catch (ClassNotFoundException | SQLException e) {
			out.println(e.getMessage());
		}
	}

}
