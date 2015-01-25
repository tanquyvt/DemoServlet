<%@page import="java.util.Iterator"%>
<%@page import="com.java.bean.DeviceInfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/DemoServlet/demo/contents/css/mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View details</title>
</head>
<body>
	<!-- include navigation content -->
	<%@ include file="partialviews/nav.jsp"%>

	<%
		/* Get dispatched attributes from servlet */
		boolean eFlag = (boolean) request.getAttribute("eFlag");
		DeviceInfoBean details = (DeviceInfoBean) request
				.getAttribute("details");

		if (eFlag | details == null) {
			response.sendRedirect("/DemoServlet/demo/contents/error.jsp");
		} else {
	%>
	<h2>Update successful!</h2>
	<h2>New details</h2>
	<div class="content">
		<table border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Type</th>
					<th>Company</th>
					<th>Color</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=details.getDeviceID()%></td>
					<td><%=details.getDeviceName()%></td>
					<td><%=details.getType()%></td>
					<td><%=details.getCompanyName()%></td>
					<td><%=details.getColor()%></td>
					<td id="price"><%=details.getPrice()%></td>
				</tr>
			</tbody>
		</table>
	</div>
	<%
		}
	%>

</body>
</html>