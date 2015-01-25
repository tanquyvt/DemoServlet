<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/DemoServlet/demo/contents/css/mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm</title>
</head>
<body>
	<%
		int id = Integer.parseInt(request.getParameter("id"));
	%>
	<div class="confirm">
		<form action="/DemoServlet/device/delete/<%=id%>">
			<h2>Are you sure?</h2>
			<input type="submit" value="Delete(<%=id%>)">
		</form>
		<form action="/DemoServlet/device/list">
			<input type="submit" value="No">
		</form>
	</div>
</body>
</html>