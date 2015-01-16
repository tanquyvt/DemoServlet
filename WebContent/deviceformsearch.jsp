<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" type="text/css" href="style.css">
<jsp:include page="partialview/header.html"></jsp:include>
<jsp:include page="partialview/nav.html"></jsp:include>

<div id="content">
	<h2>Search device</h2>
	<form action="devicesearch" method="get">
		<input type="text" name="sValue" placeholder="Seach device" required> <select
			name="sField">
			<option value="device_name">Name</option>
			<option value="type">Type</option>
			<option value="color">Color</option>
			<option value="price">Price</option>
		</select> <input type="submit" value="Search">
	</form>
</div>