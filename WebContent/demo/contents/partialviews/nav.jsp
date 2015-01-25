<%@page import="com.java.dbutil.DBNameConstant"%>
<div class="nav">
	<a href="/DemoServlet">Home</a> <a href="/DemoServlet/device/list">List</a>
	<a href="/DemoServlet/demo/contents/insertform.jsp">Insert</a>
	<form action="/DemoServlet/device/search">
		<input type="text" name="sValue"> <select name="sField">
			<option value="<%=DBNameConstant.DEVICE_NAME%>">Name</option>
			<option value="<%=DBNameConstant.TYPE%>">Type</option>
			<option value="<%=DBNameConstant.COMPANY_NAME%>">Company</option>
			<option value="<%=DBNameConstant.COUNTRY%>">Country</option>
			<option value="<%=DBNameConstant.COLOR%>">Color</option>
		</select> <input type="submit" name="search" value="Search">
	</form>
</div>