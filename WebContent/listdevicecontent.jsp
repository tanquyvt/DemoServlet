<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.java.servlet.*"%>
<%@page import="com.java.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<link rel="stylesheet" type="text/css" href="style.css">
<!-- include header content -->
<%@ include file="partialview/header.html"%>
<!-- include navigation bar content -->
<%@ include file="partialview/nav.html"%>

<div id="content">

	<%
		List<Device> data = (List<Device>) request.getAttribute("device");
		if (data != null) {
	%>
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
			<td><%=device.getDeviceName()%></td>
			<td>
				<form action="DeviceDetail" method="get">
					<input type="hidden" name="id" value="<%=device.getDeviceID()%>">
					<input type="submit" value="View details">
				</form>
			</td>
			<td>
				<form action="DeviceUpdateForm" method="get">
					<input type="hidden" name="id" value="<%=device.getDeviceID()%>">
					<input type="submit" value="Edit">
				</form>
			</td>
			<td>
				<form action="DeviceDelete" method="get">
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
<!-- include footer content -->
<%@ include file="partialview/footer.html"%>