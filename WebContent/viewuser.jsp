<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.elib.dao.*,java.util.*, com.elib.beans.*"%>
	

<!--  To make below work: Download jar and add it to lib 
https://mvnrepository.com/artifact/javax.servlet/jstl/1.2
 -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>View Renter</title>
<link rel="stylesheet" href="bootstrap.min.css"/>

</head>
<body>


<nav class="navbar navbar-inverse">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.html">E-CAR RENTAL</a>
    </div>
    
    
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="index.html" class="active">HOME</a></li>
        <li><a href="addrental.html">ADD RENTAL</a></li>
        <li><a href="viewuser.jsp">VIEW VIEW RENTAL</a></li>
        <li><a href="index.html">LOG OUT</a></li>
        
       </ul>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>




	<h1>Renter List</h1> <br>

	<%
	List<RentalBean> users = RentalDao.getAll();
	request.setAttribute("users", users);
	%>

	<table class="table table-striped" width="90%">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Password</th>
			<th>Email</th>
			<th>mobile</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.getId()}</td>
				<td>${user.getName()}</td>
				<td>${user.getEmail()}</td>
				<td>${user.getPassword()}</td>
				<td>${user.getMobile()}</td>
				<td><a href="editform.jsp?id=${user.getId()}">Edit</a></td>
				<td><a href="deleteuser.jsp?id=${user.getId()}">Delete</a></td>
			</tr>
		</c:forEach>

	</table>

	<br>




</body>
</html>