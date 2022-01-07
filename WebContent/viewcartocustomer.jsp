<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.elib.dao.*,java.util.*, com.elib.beans.*"%>
	

<!--  To make below work: Download jar and add it to lib 
https://mvnrepository.com/artifact/javax.servlet/jstl/1.2
 -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>View Car</title>
<link rel="stylesheet" href="bootstrap.min.css"/>
</head>
<body>


<nav class="navbar navbar-inverse">
 
    
    
   <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="customerhome.html" class="active">HOME</a></li>
      
        <li><a href="viewcartocustomer.jsp">VIEW CAR</a></li>
        <li><a href="issuecartocustomer.html">BOOK THE CAR</a></li>
          <li><a href="viewissuecartocustomer.jsp">VIEW BOOKED CAR</a></li>
        <!--    <li><a href="">RETURN CAR</a></li> -->
        <li><a href="index.html">LOG OUT</a></li>
       </ul>

    </div><!-- /.navbar-collapse -->
  
</nav>

	<h1>Car List</h1>

	<%
	List<AddCar> users = CarDao.view();
	request.setAttribute("users", users);
	%>

	<table class="table " width="90%">
		<tr>
			<th>CarNo</th>
			<th>Car Name</th>
			<th>Owner</th>
			<th>Type Of Car</th>
			<th>Quantity</th>
			<th>Booked</th>
			
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.getCallno()}</td>
				<td>${user.getName()}</td>
				<td>${user.getOwners()}</td>
				<td>${user.getTypee()}</td>
				<td>${user.getQuantity()}</td>
				<td>${user.getIssued()}</td>
				
				
				
			</tr>
		</c:forEach>

	</table>

	<br>




</body>
</html>