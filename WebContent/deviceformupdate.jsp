<%@page import="com.java.model.Company"%>
<%@page import="com.java.bean.DeviceInfoBean"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" type="text/css" href="style.css">
<jsp:include page="partialview/header.html"></jsp:include>
<jsp:include page="partialview/nav.html"></jsp:include>
<div id="content">
	<%
		if (request.getAttribute("cList") != null) {
			if (request.getAttribute("device") != null) {
	%>
	<form action="NewDeviceUpdate" method="get">
		<table>
			<tbody>
				<tr>
					<th>Update device
				</tr>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="dName"
						value="${device.getDeviceName()}" required="required"></td>
				</tr>
				<tr>
					<td>Type:</td>
					<td><select name="dType">
							<option>Laptop</option>
							<option>Mobile</option>
							<option>Tablet</option>
					</select></td>
				</tr>
				<tr>
					<td>Company:</td>
					<td><select name="dCompanyId">
							<%
								List<Company> cList = (List<Company>) request
												.getAttribute("cList");
										DeviceInfoBean device = (DeviceInfoBean) request
												.getAttribute("device");

										Iterator<Company> itr = cList.iterator();
										while (itr.hasNext()) {
											Company company = itr.next();
											if (company.getCompanyID() == (
													device.getCompanyID())) {
							%>
							<option value="<%=device.getCompanyID()%>" selected="selected"><%=company.getCompanyName()%></option>
							<%
								} else {
							%>
							<option value="<%=company.getCompanyID()%> "><%=company.getCompanyName()%></option>
							<%
								}
										}
							%>
					</select></td>
				</tr>
				<tr>
					<td>Color:</td>
					<td><select name="dColor">
							<option value="Black">Black</option>
							<option value="Blue">Blue</option>
							<option value="Pink">Pink</option>
							<option value="Red">Red</option>
							<option value="Silver">Silver</option>
							<option value="White">White</option>
							<option value="yellow">Yellow</option>
					</select></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><input type="number" name="dPrice"
						value="<%=device.getPrice()%>" required></td>
				</tr>
			</tbody>
		</table>
		<input type="hidden" name="id" value="${device.getDeviceID()}">

		<input type="submit" name="updateSubmit" value="Update">
	</form>
	<%
		}

		}
	%>
</div>