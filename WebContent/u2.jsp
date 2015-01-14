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
		/* List<DeviceInfoBean> data = (List<DeviceInfoBean>) request.getAttribute("device"); */
		DeviceInfoBean data = (DeviceInfoBean) request.getAttribute("dUp");
		if (data != null) {
			/* Iterator<DeviceInfoBean> itr = data.iterator();
			while (itr.hasNext()) {
				DeviceInfoBean device = itr.next(); */
	%>
	<form action="deviceinsert" method="get">
		<table>
			<tbody>
				<tr>
					<th>Update device
				</tr>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="dName"
						value="<%=data.getCompanyName()%>" required="required"></td>
				</tr>
				<tr>
					<td>Type:</td>
					<td><select name="dType">
							<option value="Laptop">Laptop</option>
							<option value="Mobile">Mobile</option>
							<option value="Tablet">Tablet</option>
					</select></td>
				</tr>
				<tr>
					<td>Company:</td>
					<td><select name="dCompanyId">
							<!-- <option value="">Select type</option> -->
							<%
								Class.forName("com.mysql.jdbc.Driver").newInstance();
									String connectionURL = "jdbc:mysql://localhost:3306/fptshop";
									Connection connection = DriverManager.getConnection(
											connectionURL, "root", "");
									PreparedStatement psmnt = connection
											.prepareStatement("SELECT company_id, company_name FROM company");
									ResultSet results = psmnt.executeQuery();
									while (results.next()) {
										String name = results.getString(2);
										int id = Integer.parseInt(results.getString(1));
							%>
							<option value="<%=id%>"><%=name%></option>
							<%
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
						value="<%=data.getPrice()%>" required></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" name="updateSubmit" value="Update">
	</form>
	<%
		} else
			out.println("data is null");
		/* } */
	%>
</div>