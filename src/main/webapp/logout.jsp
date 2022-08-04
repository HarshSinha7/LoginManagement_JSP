<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log Out</title>
</head>
<body>
<%
if(request.getParameter("logout").equals("logout")){
	request.getSession().invalidate();
	response.sendRedirect("login.jsp");
	}
else{
	response.sendRedirect("login.jsp");
}
%>
</body>
</html>