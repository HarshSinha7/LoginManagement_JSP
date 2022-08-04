<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ansh</title>
</head>
<body>
<% 
if(request.getSession().getAttribute("id")==null){
	response.sendRedirect("login.jsp");
}
%>
<H3>Hello my name is Ansh Vijay.</H3></br>
Instagram:<a href="https://www.instagram.com/anshhhhhhh_____/"/>Click here</a></br>
</br>
<form>
<input type="hidden" name="logout" value="logout">
<input type="submit" value="LOG OUT">
</form>
</body>
</html>