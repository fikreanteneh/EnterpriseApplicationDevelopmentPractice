<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>Welcome To Our Login Page.</h1>
<h2>Registration Form</h2>
<form action="Login" method="POST">
	<label> Email: </label>
	<input type="text" name="email" />
	<br />
	<label> Password: </label>
	<input type="password" name="password" />
	<br />
	<button type="submit">Log In</button>
</form>
<p>Don't have an account? <a href="/TaskManagment/Registration">Create an account</a></p>
<%
	// Check for an error condition
	String error = (String) request.getAttribute("Error");

	if (error != null && !error.isEmpty()) {
%>
<div style="color: red;">a
	<!-- Display the error message -->
	<%= error %>
</div>
<%
	}
%>
</body>
</html>