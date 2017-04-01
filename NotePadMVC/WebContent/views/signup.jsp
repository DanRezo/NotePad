<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Insert title here</title>
		</head>
		<body>
			<c:choose>
				<c:when test="${userNotFound}">
					<h3>
						<em>This User name already exists. Please pick a different User name and try again.</em>
					</h3>
					<form action="createNewUser.do" method="POST">
						<input type="text" name="firstName" placeholder="${user.firstName}"/>
						<input type="text" name="lastName" placeholder="${user.lastName}"/><br/>
					</c:when>
					<c:otherwise>
						<form action="createNewUser.do" method="POST">
							<input type="text" name="firstName" placeholder="First name"/>
							<input type="text" name="lastName" placeholder="Last name"/><br/>
						</c:otherwise>
					</c:choose>
					<input type="text" name="alias" placeholder="User name"/><br/>
					<input type="password" name="password" placeholder="New password"/><br/>
				</form>

				<br></body>
			</html>
