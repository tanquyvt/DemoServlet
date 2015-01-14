<%@ page import="java.sql.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="deviceinsert" method="get">
		<table>
			<tbody>
				<tr>
					<th>Insert device
				</tr>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="dName" required="required"></td>
				</tr>
				<tr>
					<td>Type:</td>
					<!-- <td><input type="text" name="dType"></td> -->
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
								Connection connection = DriverManager.getConnection(connectionURL,
										"root", "");
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
					<td><input type="number" name="dPrice" required></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="Add">
	</form>
</body>
</html>