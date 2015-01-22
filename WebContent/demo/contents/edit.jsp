<%@page import="com.java.model.EType"%>
<%@page import="com.java.model.EColor"%>
<%@page import="com.java.model.ECompany"%>
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
<title>Edit</title>
</head>
<body>
	<!-- include navigation content -->
	<%@ include file="partialviews/nav.html"%>

	<%
		/* Get dispatched attributes from servlet */
		boolean eFlag = (boolean) request.getAttribute("eFlag");
		DeviceInfoBean details = (DeviceInfoBean) request
				.getAttribute("details");

		if (eFlag | details == null) {
			response.sendRedirect("/DemoServlet/demo/contents/error.jsp");
		} else {
	%>
	<h2>Details</h2>
	<div class="content">
		<form action="/DemoServlet/device/update" method="get">
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
						<td><input name="dName" value="<%=details.getDeviceName()%>"></td>

						<!-- device type drop down list -->
						<td><select name="dType">
								<%
									for (EType tName : EType.values()) {
											if (tName.toString().trim()
													.equalsIgnoreCase(details.getType().trim())) {
								%>
								<option value="<%=details.getType()%>" selected="selected"><%=details.getType()%></option>
								<%
									} else {
								%>
								<option value="<%=tName%>"><%=tName%></option>
								<%
									}
										}
								%>
						</select></td>

						<!-- device company drop down list -->
						<td><select name="dCompanyID">
								<%
									for (ECompany cName : ECompany.values()) {
											if (cName.toString().trim()
													.equalsIgnoreCase(details.getCompanyName().trim())) {
								%>
								<option value="<%=cName.company_id%>" selected="selected"><%=details.getCompanyName()%></option>

								<%
									} else {
								%>
								<option value="<%=cName.company_id%>"><%=cName%></option>
								<%
									}
										}
								%>
						</select></td>

						<!-- device color drop down list -->
						<td><select name="dColor">
								<%
									for (EColor colorName : EColor.values()) {
											if (colorName.toString().trim()
													.equalsIgnoreCase(details.getColor().trim())) {
								%>
								<option value="<%=details.getColor()%>" selected="selected"><%=details.getColor()%></option>
								<%
									} else {
								%>
								<option value="<%=colorName%>"><%=colorName%></option>
								<%
									}
										}
								%>
						</select></td>

						<td><input id="price" name="dPrice"
							value="<%=details.getPrice()%>"></td>
					</tr>
				</tbody>
			</table>
			<br> <input type="submit" value="Update"> <input
				name="id" value="<%=details.getDeviceID()%>" type="hidden">
		</form>

	</div>
	<%
		}
	%>

</body>
</html>