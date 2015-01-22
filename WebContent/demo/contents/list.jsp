<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.java.model.Device"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/DemoServlet/demo/contents/css/mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List page</title>
</head>
<body>
	<!-- include navigation content -->
	<%@ include file="partialviews/nav.html"%>

	<%
		/* Get dispatched attributes from servlet */
		boolean eFlag = (boolean) request.getAttribute("eFlag");
		List<Device> data = (List<Device>) request.getAttribute("devices");

		if (eFlag | data == null) {
			response.sendRedirect("/DemoServlet/demo/contents/error.jsp");
		} else {
	%>
	<h2>Device list</h2>
	<div class="content">
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
			</tr>

			<%
				Iterator<Device> itr = data.iterator();
					while (itr.hasNext()) {
						Device device = itr.next();
			%>
			<tr>
				<td><%=device.getDeviceID()%></td>
				<td><a
					href="/DemoServlet/device/view/<%=device.getDeviceID()%>"><%=device.getDeviceName()%></a></td>
				<td><a
					href="/DemoServlet/device/edit/<%=device.getDeviceID()%>">Edit</a></td>
				<td><a href="">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
	<%
		}
	%>

</body>
</html>