<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.elib.dao.CustomerDao"%>

<jsp:useBean id="user" class="com.elib.beans.Customer" />
<jsp:setProperty property="*" name="user" />


<%
int status = CustomerDao.save(user);
if (status > 0) {
	out.print("<h3> Record saved successfully!! </h3>");
%>
<jsp:include page="customerregister.html"></jsp:include>
<%
} else {
out.print("<h3> Record Not saved !! </h3>");
%>
<jsp:include page="customerregister.html"></jsp:include>
<%
}
%>