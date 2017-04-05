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
			<h1 class="notePadHeader">All Artists All the time</h1>
		</div>
		<form action="song.do">
			<select name="Artists">
				<c:forEach var="artist" items="${artists}">
					<option value="${artist.id}">${artist.name}</option>
				</c:forEach>
			</select>
			<h4>
				<button id="bar" type="submit">See all the songs from this
					artist</button>
			</h4>
			<br><br>
		</form>
		<br>
		<form action="deleteArtist.do">
			<select name="Artists">
				<c:forEach var="artist" items="${artists}">
					<option value="${artist.id}">${artist.name}</option>
				</c:forEach>
			</select>
			<h4>
				<button id="bar" type="submit">Delete that sucker!(Cannot
					be undone)</button>
			</h4>
			<br><br><br>
		</form>
		<h4>
			<a href="createAlbum.do" class="btn btn-info btn-med" role="button">or
				click here to add a new Artist to the database</a>
		</h4>
	</div>