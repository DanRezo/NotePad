<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width = device-width, initial-scale = 1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Gloria+Hallelujah"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="npstyle.css">
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1 class="notePadHeader">Albums</h1>
			<br><br>
					<c:forEach var="album" items="${albums}">
					<h4><font color="pink"><a href="getAlbum.do?id=${album.id}"> ${album.title}</a></font></h4>
					<a href="deleteAlbums.do?albumId=${album.id}" class="btn btn-info btn-lg" role="button">Delete</a>					</c:forEach>
					</div>
	</div>
</body>