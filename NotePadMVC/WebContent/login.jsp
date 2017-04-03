<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width = device-width, initial-scale = 1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="npstyle.css">
</head>
<body>
	<div class="container">
	<c:choose>
		<c:when test="${userNotFound}">
			<h3>
				<em>User Name and Password do not match. Please try again.</em>
			</h3>
			<form action="login.do" method="POST">
				<input type="text" name="alias" value="${user.alias}" /><br />
				<input type="password" name="password" placeholder="Password" /><br />
				<input type="submit" value="Login" /> <br>
			</form>
			<br />
		</c:when>
		<c:otherwise>
			<form action="login.do" method="POST">
				<input type="text" name="alias" placeholder="User name" /><br />
				<input type="password" name="password" placeholder="Password" /><br />
				<input type="submit" value="Login" /> <br>
			</form>
			<br />
		</c:otherwise>
	</c:choose>
	<br> No account?
	<a href="signup.jsp">Sign Up</a>
</div>
</body>
</html>
