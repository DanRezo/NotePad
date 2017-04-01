<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${aliasExists}">
			<h3>
				<em>This User name already exists. Please pick a different User
					name and try again.</em>
			</h3>
			<form action="createNewUser.do" method="POST">
				<input type="text" name="firstName" value="${user.firstName}" />
				<input type="text" name="lastName" value="${user.lastName}" /><br />
				<input type="text" name="alias" placeholder="User name" /><br /> <input
					type="password" name="password" placeholder="New password" /><br />
				<input type="submit" value="Create account" /> <br>
			</form>
		</c:when>
		<c:otherwise>
			<form action="createNewUser.do" method="POST">
				<input type="text" name="firstName" placeholder="First name" /> <input
					type="text" name="lastName" placeholder="Last name" /><br /> <input
					type="text" name="alias" placeholder="User name" /><br /> <input
					type="password" name="password" placeholder="New password" /><br />
				<input type="submit" value="Create account" /> <br>
			</form>
		</c:otherwise>
	</c:choose>
	<br>
</body>
</html>
