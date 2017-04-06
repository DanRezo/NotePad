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
<link href="https://fonts.googleapis.com/css?family=Gloria+Hallelujah" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="npstyle.css"></head>
<body>


<div class="container">
<div class="page-header">
<h1 class="notePadHeader">Welcome to <strong>NotePad</strong></h1>
</div>

<div class="loginForm">
<div class="jumbotron notePadContainer">
<c:choose>
<c:when test="${userNotFound}">
<h3>
<em>User Name and Password do not match. Please try again.</em>
</h3>
<form action="login.do" method="POST">
<div class="form-group">
<input type="text" name="alias" value="${user.alias}"/>
<input type="password" name="password" placeholder="Password"/><br><br>
<button type="submit" class="btn btn-info btn-lg">Login</button>
</div>
</form>
<br>
</c:when>
<c:otherwise>
<form action="login.do" method="POST">
<div class="form-group">
<input type="text" name="alias" placeholder="User name"/>
<input type="password" name="password" placeholder="Password"/><br><br>
<button type="submit" class="btn btn-info btn-lg">Login</button>
</div>
</form>
<br/>
</c:otherwise>
</c:choose>
<br>
<h3>No Account?</h3><br>
<c:choose>
<c:when test="${aliasExists}">
<h3>
<em>This User name already exists. Please pick a different User name and try again.</em>
</h3>
<form action="createNewUser.do" method="POST">
<input type="text" name="firstName" placeholder="${user.firstName}"/>
<input type="text" name="lastName" placeholder="${user.lastName}"/><br><br>
<input type="text" name="alias" placeholder="User name"/>
<input type="password" name="password" placeholder="New password"/><br><br>
<button type="submit" class="btn btn-info btn-lg">Create New Account</button>
</form>
<br>
</c:when>
<c:otherwise>
<form action="createNewUser.do" method="POST">
<input type="text" name="firstName" placeholder="First name"/>
<input type="text" name="lastName" placeholder="Last name"/><br><br>
<input type="text" name="alias" placeholder="User name"/>
<input type="password" name="password" placeholder="New password"/><br><br>
<button type="submit" class="btn btn-info btn-lg">Create New Account</button>
</form>
<br>
</c:otherwise>
</c:choose>
</div>
</div>
</div>
</body>
</html>
