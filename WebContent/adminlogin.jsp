<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
     if(email.equals("admin@admin.com")&&password.equals("admin123")){
  %>
     <jsp:forward page="adminhome.html"></jsp:forward>
 <%   
  } else{
  %>
      <jsp:include page="index.html"></jsp:include>
     <% 
     }
     %>
</body>
</html>