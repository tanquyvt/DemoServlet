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
		if ("${device}" != null) {
	%>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Type</th>
			<th>Company</th>
			<th>Color</th>
			<th>Price</th>
		</tr>
		<tr>
			<td>${device.getDeviceID() }</td>
			<td>${device.getDeviceName() }</td>
			<td>${device.getType ()}</td>
			<td>${device.getCompanyName ()}</td>
			<td>${device.getColor() }</td>
			<td>${device.getPrice() }</td>

		</tr>
		<%
			}
		%>
	</table>

</div>
<!-- include footer content -->
<%@ include file="partialview/footer.html"%>