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
<title>Admin</title>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Gloria+Hallelujah"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="npstyle.css">
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1 class="notePadHeader">Administrators only</h1>
		</div>
		<form action="deleteArtist.do">
			<select name="Artists">
				<c:forEach var="artist" items="${artists}">
					<option value="${artist.id}">${artist.name}</option>
				</c:forEach>
			</select>
			<h4>
				<button id="bar" type="submit">Delete that sucker!</button>
			</h4>
			<br> <br> <br>
		</form>

		<form action="deleteAlbum.do">
			<select name="album">
				<c:forEach items="${albums}" var="album">
					<option value="${album.id}">${album.title}</option>
				</c:forEach>
			</select>
			<h4>
				<button id="bar" type="submit">Delete that album!</button>
			</h4>
			<br> <br> <br>
		</form>


		<form action="deleteSong.do">
			<select name="songId">
				<c:forEach items="${songs}" var="song">
					<option value="${song.id}">${song.title}</option>
				</c:forEach>
			</select>
			<h4>
				<button id="bar" type="submit">Delete that song!</button>
			</h4>
			<br> <br> <br>
		</form>

		<br> <a href="goToPad.do" class="btn btn-info btn-lg"
			role="button">Go Home</a>
	</div>
</body>
</html>