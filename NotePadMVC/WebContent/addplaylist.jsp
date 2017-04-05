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
<div class="page-header">
<h1 class="notePadHeader">${user.alias}</h1>
</div>
<div class="container">
<c:forEach var="playlist" items="${playlists}">
	<h2><a href="addExistingPlaylist.do?playlistid=${playlist.id}">${playlist.title}</a></h2>
	<ol>
	<c:forEach var="song" items="${playlist.songs}">
		<li>
		${song.title}
		${song.album.title}
		</li>
	</c:forEach>
	</ol>
</c:forEach>
</div>
</body>
</html>