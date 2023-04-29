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
	<form action="edit"  method="post">
		ID:	<input type="number" name="id" value="<%=u.getId()%>"readonly="readonly">
		<br>
		Name:<input type="text" name="nm" value="<%=u.getName()%>">
		<br>
		
		Age:<input type="number" name="age" value="<%=u.getAge()%>">
		<br>
		
		Phone:<input type="tel" name="ph" value="<%=u.getPhone()%>">
		<br>
		
		password:<input type="password" name="ps" value="<%=u.getPassword()%>">
		<br>
		<input type="submit" value="Update">
	</form>
	<%
		}else{
			response.sendRedirect("login.jsp");
		}
	
	%>
</body>
</html>