<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.elib.dao.RentalDao"%>

<jsp:useBean id="user" class="com.elib.beans.RentalBean" />
<jsp:setProperty property="*" name="user" />


<%
int status = RentalDao.save(user);
if (status > 0) {
	out.print("<h3> Record saved successfully!! </h3>");
%>
<jsp:include page="addrental.html"></jsp:include>
<%
} else {
out.print("<h3> Record Not saved !! </h3>");
%>
<jsp:include page="addrental.html"></jsp:include>
<%
}
%>