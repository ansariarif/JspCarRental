<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.elib.dao.*,java.util.*, com.elib.beans.*"%>

     <jsp:useBean id="user" class="com.elib.beans.RentalBean"></jsp:useBean>
    <jsp:setProperty property="*" name="user"/>
    
    <% 
     int status = RentalDao.deleteRental(user);
     response.sendRedirect("viewuser.jsp");
  %>