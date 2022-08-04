<%@page import="javax.websocket.Session"%>
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
String id=request.getSession().getAttribute("id").toString();
String pass=request.getSession().getAttribute("pass").toString();

if(id.equals("harsh")&&pass.equals("123")){
	response.sendRedirect("harsh.jsp");
}else if(id.equals("ansh")&&pass.equals("123")){
	response.sendRedirect("ansh.jsp");
}
%>
</body>
</html>