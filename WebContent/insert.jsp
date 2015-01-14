<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" type="text/css" href="style.css">
<jsp:include page="partialview/header.html"></jsp:include>
<jsp:include page="partialview/nav.html"></jsp:include>
<div id="content">
	out.println("
	<h2>Insert Device Succesful!</h2>
	"); out.println("
	<table>
		"); out.println("
		<tr>
			"); out.println("
			<th>ID</th>"); out.println("
			<th>Name</th>"); out.println("
			<th>Type</th>"); out.println("
			<th>Color</th>"); out.println("
			<th>Price</th>"); out.println("
		</tr>
		"); out.println("
		<tr>
			"); out.println("
			<td>"+ dNew.getDeviceID() +"</td>"); out.println("
			<td>" + dNew.getDeviceName() +"</td>"); out.println("
			<td>"+ dNew.getType() +"</td>"); out.println("
			<td>"+ dNew.getColor() +"</td>"); out.println("
			<td>"+ dNew.getPrice() +"</td>"); out.println("
		</tr>
		"); out.println("
	</table>
	");
</div>