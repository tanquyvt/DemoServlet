<%@page import="com.java.model.EColor"%>
<%@page import="com.java.model.ECompany"%>
<%@page import="com.java.model.EType"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/DemoServlet/demo/contents/css/mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert</title>
</head>
<body>
	<!-- include navigation content -->
	<%@ include file="partialviews/nav.jsp"%>

	<h2>Fill the form</h2>
	<div class="content">
		<form action="/DemoServlet/device/insert" method="get">
			<table>
				<tr>
					<td>Name</td>
					<td><input type="text" name="dName"></td>
				</tr>
				<tr>
					<td>Type</td>
					<td><select name="dType">
							<%
								for (EType tName : EType.values()) {
							%>
							<option value="<%=tName%>"><%=tName%></option>
							<%
								}
							%>
					</select></td>
				</tr>
				<tr>
					<td>Company</td>
					<td><select name="dCompanyID">
							<%
								for (ECompany cName : ECompany.values()) {
							%>
							<option value="<%=cName.company_id%>"><%=cName%></option>
							<%
								}
							%>
					</select></td>
				</tr>
				<tr>
					<td>Color</td>
					<td><select name="dColor">
							<%
								for (EColor colorName : EColor.values()) {
							%>
							<option value="<%=colorName%>"><%=colorName%></option>
							<%
								}
							%>
					</select></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input id="price" type="text" name="dPrice" value="0"></td>
				</tr>
			</table>
			<br> <input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>