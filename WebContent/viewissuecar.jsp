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
        <li><a href="rentalhome.html" class="active">HOME</a></li>
        <li><a href="addcar.html">ADD CAR</a></li>
        <li><a href="viewcar.jsp">VIEW CAR</a></li>
         <!--    <li><a href="issuecarform.html">BOOK THE CAR</a></li> -->
        <li><a href="viewissuecar.jsp">VIEW BOOKED CAR</a></li>
       <!-- <li><a href="returncarform.html">RETURN CAR</a></li>  --> 
        <li><a href="index.html">LOG OUT</a></li>
       </ul>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

	<h1 style="margin-left:42%">Car List</h1>

	<%
	List<IssueCarBean> users = CarDao.viewIssuedCar();
	request.setAttribute("users", users);
	%>

	<table class="table" style="margin-top:5%">
		<tr>
			<th>CarNo</th>
			<th>Renter Id</th>
			<th>Renter Name</th>
			<th>Renter Mobile</th>
			<th>Return Date</th>
			<th>Return status</th>
			<th>Return Car</th>
			<th>Delete Record</th>
			
			
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.getCallno()}</td>
				<td>${user.getRentalid()}</td>
				<td>${user.getRentalname()}</td>
				<td>${user.getRentalmobile()}</td>
				<td>${user.getIssueddate()}</td>
				<td>${user. getReturnstatus()}</td>
				<td><a href="returncar.jsp?callno=${user.getCallno()}">Return</a></td>
				<td><a href="deletecarbooked.jsp?callno=${user.getCallno()}">Delete</a></td>
				
				
				
				
			</tr>
		</c:forEach>

	</table>

	<br>




</body>
</html>