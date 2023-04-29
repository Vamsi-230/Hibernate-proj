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
<h2>
	Hello Mr.<%=u.getName()%>
	welcome to my application
</h2>
<h3>
 <a href="edit.jsp">Edit your Details</a>
</h3>
<h3>

<a href="delete?id=<%=u.getId()%>">Delete your details</a>
</h3>

<h3>
	 <a href="view.jsp">view your Details</a>
</h3>

<h3>
<a href="logout">click here to logout</a>
</h3>
<%
	}
	else{
		response.sendRedirect("login.jsp");
	}
%>
</body>
</html>