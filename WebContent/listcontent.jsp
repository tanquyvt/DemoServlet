<%@page import="java.util.Iterator"%>
<%@page import="java.sql.*"%>
<%@page import="com.java.servlet.*"%>
<%@page import="com.java.model.Device"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" type="text/css" href="style.css">
<jsp:include page="partialview/header.html"></jsp:include>
<jsp:include page="partialview/nav.html"></jsp:include>

<div id="content">
	<%
		List<Device> data = (List<Device>) request.getAttribute("device");
		if (data != null) {
	%>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<!-- <td>Type</td>
			<td>Company</td>
			<td>Color</td>
			<td>Price</td> -->
		</tr>
		<%
			Iterator<Device> itr = data.iterator();
				while (itr.hasNext()) {
					Device device = itr.next();
		%>
		<tr>
			<td><%=device.getDeviceID()%></td>
			<td><%=device.getDeviceName()%></td>
			<%-- <td><%=device.getType()%></td>
			<td><%=device.getCompanyID()%></td>
			<td><%=device.getColor()%></td>
			<td><%=device.getPrice()%></td> --%>
			<td>
				<form action="deviceupdate" method="get">
					<input type="hidden" name="id" value="<%=device.getDeviceID()%>">
					<input type="submit" value="Edit">
				</form>
			</td>
			<td>
				<form action="devicedelete" method="get">
					<input type="hidden" name="id" value="<%=device.getDeviceID()%>">
					<input type="submit" value="Delete">
				</form>
			</td>
		</tr>
		<%
			}
			}
		%>
	</table>
</div>
<jsp:include page="partialview/footer.html"></jsp:include>