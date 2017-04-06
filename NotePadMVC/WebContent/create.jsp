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
<title>Add A Song</title>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Gloria+Hallelujah" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="npstyle.css"></head>
<body>
<div class="page-header">
<h1 class="notePadHeader">${user.alias}</h1>
</div>

<div class="loginForm">
<div class="jumbotron notePadContainer">
<h2>Add a New Song on a New Album</h2>
<form action="createSongWithNewAlubum.do" method="POST">
<div class="form-group">
<input type="text" name="songTitle" placeholder="Song Title"/><br>
<input type="text" name="artistName" placeholder="Artist Name"/><br>
<input type="text" name="albumTitle" placeholder="Album Title"/><br>
<input type="text" name="albumYear" placeholder="Album Year"/><br>
<select name="genreId">
  <option value="1">Country</option>
  <option value="2">Hip Hop</option>
  <option value="3">Pop</option>
  <option value="4">R&B</option>
  <option value="5">Rock</option>
</select><br>
<button type="submit" class="btn btn-info btn-lg">Create The Song</button>
</div>
</form>
<h1>OR</h1>
<h2>Add a New Song on an Existing Album</h2>
<form action="createSongWithExistingAlbum.do" method="POST">
<div class="form-group">
<input type="text" name="songTitle" placeholder="Song Title"/><br>
<select name="albumId" >
<c:forEach var="album" items="${albums}">
  <option value="${album.id}">${album.title}</option>
</c:forEach>
</select><br>
<button type="submit" class="btn btn-info btn-lg">Create The Song</button>
</div>
</form>
<a href="goToPad.do" class="btn btn-info btn-lg" role="button">Go Home</a>
</div>
</div>
</body>
</html>