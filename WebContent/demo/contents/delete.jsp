<%@page import="com.java.model.ECompany"%>
<%@page import="com.java.model.Device"%>
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
<title>Delete page</title>
</head>
<body>
	<!-- include navigation content -->
	<%@ include file="partialviews/nav.jsp"%>

	<%
		/* Get dispatched attributes from servlet */
		boolean eFlag = (boolean) request.getAttribute("eFlag");

		if (eFlag) {
			response.sendRedirect("/DemoServlet/demo/contents/error.jsp");
		} else {
	%>
	<h2>Delete successful!</h2>
	<div class="content"></div>
	<%
		}
	%>
</body>
</html>