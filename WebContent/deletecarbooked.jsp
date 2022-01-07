<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.elib.dao.*,java.util.*, com.elib.beans.*"%>

   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<jsp:useBean id="user" class="com.elib.beans.IssueCarBean" />
<jsp:setProperty property="*" name="user" />


<%


 int status = CarDao.deleteCarBooked(user);
if (status > 0) {
	out.print("<h3>booked Car delete successfully!! </h3>");
%>
<jsp:include page="viewissuecar.jsp"></jsp:include>
<%
} else {
out.print("<h3> Record Not return !! </h3>");
%>
<jsp:include page="viewissuecar.jsp"></jsp:include>
<%
}
%>