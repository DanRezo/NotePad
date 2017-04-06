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

<c:forEach items="${artists}" var="artist">
<h2 class="notePadHeader">${artist.name }<br>Albums</h2>

<c:forEach items="${artist.albums }" var="album">
<br>
<a href="getAlbum.do?albumId=${album.id}">${album.title}</a>
<br>
<c:if test="${playListId != null }">
<form action="chooseSongToAddToPlayList.do">
<input type="hidden" name="albumId" value="${album.id }" />
<input type="hidden" name="playListId" value="${playListId }" />
<input type="submit" name="" value="Add Song To Playlist From This Album" />
</form>
</c:if>
</c:forEach>
<br>
<br>
</c:forEach>
</div>
<a href="goToPad.do" class="btn btn-info btn-lg" role="button">Go Home</a>
</div>
</body>
</html>