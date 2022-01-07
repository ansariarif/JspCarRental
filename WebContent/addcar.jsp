<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.elib.dao.CarDao"%>

    
    
<jsp:useBean id="user" class="com.elib.beans.AddCar" />
<jsp:setProperty property="*" name="user" />


<%
int status = CarDao.save(user);
if (status > 0) {
	out.print("<h3> Car Added successfully!! </h3>");
%>
<jsp:include page="addcar.html"></jsp:include>
<%
} else {
out.print("<h3> Record Not saved !! </h3>");
%>
<jsp:include page="addcar.html"></jsp:include>
<%
}
%>