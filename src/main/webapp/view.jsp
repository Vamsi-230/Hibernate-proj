<%@page import="user.webapp.dto.User"%>
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
	User u=(User)session.getAttribute("u");
	if(u!=null){
%>
<h1>Your details display below</h1>
<h2>
	ID:<%=u.getId()%></h2>
<h2>
	name:<%=u.getName()%></h2>
<h2>
	phone:<%=u.getPhone()%></h2>
<h2>
   Age:<%=u.getAge()%></h2>
   <% 
	}else
		response.sendRedirect("login.jsp");
	%>
</body>
</html>