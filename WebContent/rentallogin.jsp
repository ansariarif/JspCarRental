<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="com.elib.dao.*,java.util.*, com.elib.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <%
  
     String email = request.getParameter("email");
     String password = request.getParameter("password");
     if(RentalDao.authenticate(email, password)){
  %>
     <jsp:forward page="rentalhome.html"></jsp:forward>
 <%   
  } else{
  %>
      <jsp:include page="rentallogin.html"></jsp:include>
     <% 
     }
     %>
</body>
</html>