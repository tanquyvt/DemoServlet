<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.java.bean.DeviceInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" type="text/css" href="style.css">
<jsp:include page="partialview/header.html"></jsp:include>
<jsp:include page="partialview/nav.html"></jsp:include>

<div id="content">
<h2>View Search Result</h2>
<% String sValue = request.getAttribute("dBeanSize").toString(); %>
<% String sField = request.getAttribute("dBeanSize").toString(); %>
<% List<DeviceInfoBean> data = (List<DeviceInfoBean>)request.getAttribute("dBean");
if (data != null) {
%>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<td>Type</td>
			<td>Company</td>
			<td>Color</td>
			<td>Price</td>
		</tr>
		<%
			Iterator<DeviceInfoBean> itr = data.iterator();
				while (itr.hasNext()) {
					DeviceInfoBean device = itr.next();
		%>
		<tr>
			<td><%=device.getDeviceID()%></td>
			<td><%=device.getDeviceName()%></td>
			<td><%=device.getType()%></td>
			<td><%=device.getCompanyName()%></td>
			<td><%=device.getColor()%></td>
			<td><%=device.getPrice()%></td>
		</tr>
		<%
				}
				}
			%>
	
</div>