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
		List<Company> data = (List<Company>) request.getAttribute("company");
		if (data != null) {
	%>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
		</tr>
		<%
			Iterator<Company> itr = data.iterator();
				while (itr.hasNext()) {
					Company company = itr.next();
		%>
		<tr>
			<td><%=company.getCompanyID()%></td>
			<td><a href="CompanyDetail/<%=company.getCompanyID()%>"><%=company.getCompanyName()%></a></td>
			<td>
				<form action="companyupdate" method="get">
					<input type="hidden" name="id" value="<%=company.getCompanyID()%>">
					<input type="submit" value="Edit">
				</form>
			</td>
			<td>
				<form action="companydelete" method="get">
					<input type="hidden" name="id" value="<%=company.getCompanyID()%>">
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