<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
		<c:when test="${userNotFound}">
			<h3>
				<em>User Name and Password do not match. Please try again.</em>
			</h3>
		</c:when>
	<form action="login.do" method="POST">
		<input type="text" name="alias" placeholder="User name"/><br />
		<input type="password" name="password" placeholder="Password"/><br />
	</form><br>
	No account? <a href="signup.html">Sign Up</a>

</body>
</html>