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
<%
	String error = (String) request.getAttribute("Error");
String success = (String) request.getAttribute("Succesfull");
%>
<h1>Welcome To Our Registrarion Page.</h1>
<h2>Registration Form</h2>
<form action="Registration" method="POST">
	<label> Name: </label>
	<input type="text" name="name" />
	<br />
	<label> Email: </label>
	<input type="text" name="email" />
	<br />
	<label> Password: </label>
	<input type="password" name="password" />
	<br />
	<button type="submit">Register</button>
</form>
<p> Have an account? <a href="/TaskManagment/Login">Create an account</a></p>
<div>
<% if (error != null) { %>
	<div class="alert alert-danger">
		<p><%=error%></p>
		<p>Try Again</p>>
	</div>
<% } %>
<% if (success != null) { %>
	<div class="alert alert-danger">
		<p><%=error%></p>
		<p> Successfully Registered <a href="/TaskManagment/Login">Login Here</a></p>
	</div>
<% } %>
</div>

</body>
</html>