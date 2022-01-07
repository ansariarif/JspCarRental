<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.elib.dao.*,java.util.*, com.elib.beans.*"%>

     <jsp:useBean id="user" class="com.elib.beans.AddCar"></jsp:useBean>
    <jsp:setProperty property="*" name="user"/>
    
    <% 
     int status = CarDao.deleteCar(user);
     response.sendRedirect("viewcar.jsp");
  %>