<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>Welcome To Our Login Page.</h1>
<h2>Registration Form</h2>
<form action="LoginServlet">
	<label> Email: </label>
	<input type="text" name="email" />
	<br />
	<label> Password: </label>
	<input type="password" name="password" />
	<br />
	<button type="submit">Log In</button>
</form>
</body>
</html>