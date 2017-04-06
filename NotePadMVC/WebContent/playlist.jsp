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
<h1 class="notePadHeader">${playlist.title}</h1>
<a href="goToPad.do" class="btn btn-info btn-lg" role="button">Go Home</a>
</div>
</div>
<div class="container">
<div class="notePadContainer">

<c:choose>
<c:when test="${!emptyPlaylist}">
<table>
<tr>
<th>Song</th>
<th>Album</th>
</tr>
<c:forEach var="song" items="${playlist.songs}">
<tr>
		<td>${song.title}</td>
		<td>${song.album.title}</td>
</tr>
</c:forEach>
</table>
</c:when>
</c:choose>
<a href="chooseSongFromAlbumToAddToPlayList.do?playlistId=${playlist.id}">Add a song to this Playlist</a>
<h3>OR</h3>
<a href="NewSongNewAlbum.do">Create a New Song</a><br>
<h3>OR</h3>
<a href="deletePlaylist.do?playlistId=${playlist.id}">Delete this Playlist</a><br>
</div>
</div>
</body>
</html>