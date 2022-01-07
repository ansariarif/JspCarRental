<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.elib.dao.*,java.util.*, com.elib.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Form</title>
</head>
<body>






<%
	String id = request.getParameter("id");
	RentalBean user = RentalDao.getRentalById(Integer.parseInt(id));
%>

<h1> Edit Form </h1>

<form action="edituser.jsp" method="post">

<input type="hidden" name="id" value="<%=user.getId() %>"/>

		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="<%= user.getName() %>"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="password" value="<%= user.getPassword() %>" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" value="<%= user.getEmail() %>" /></td>
				
			</tr>
			
			<tr>
				<td>mobile:</td>
				<td><input type="text" name="mobile" value="<%= user.getMobile() %>" /></td>
				
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form>


</body>
</html>