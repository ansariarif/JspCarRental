<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.elib.dao.*,java.util.*, com.elib.beans.*"%>
    
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="user" class="com.elib.beans.IssueCarBean" />
<jsp:setProperty property="*" name="user" />

<%
 
 int status = CarDao.issueCar(user);

 if (status > 0) {
	out.print("<h3> Car issued successfully!! </h3>");
%>
<jsp:include page="issuecarform.html"></jsp:include>
<%
} else {
out.print("<h3> Record Not issued !! </h3>");
%>
<jsp:include page="issuecarform.html"></jsp:include>
<%
}
%>