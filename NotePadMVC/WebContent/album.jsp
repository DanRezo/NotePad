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
			<h1 class="notePadHeader">${album.title}</h1>
			<br> <br>
			<c:forEach items="${album.songs}" var="song">
${song.title}
<table> 
<c:if test="${playListId != null }">
   <td> <form action="addSongToPlayList.do">
   	<input type="hidden" name="playListId" value="${playListId }" />
   		<button id="button" name="songId" value="${song.id}" type="submit">Add song to play	list</button>
   			</form></td>
   		</c:if>
   		<c:if test="${playListId == null }">
   		
   <td> <form action="editSongForm.do">
	    <button id="button" name="songId" value="${song.id }" type="submit">Edit Song</button>
		     <input type="hidden" name="albumId" value="${album.id }" />
				</form></td>
				
   <td> <form action="deleteSong.do">
		<button id="button" name="songId" value="${song.id}" type="submit">Remove Song</button>
				</form></td>
				</c:if>

</table>  
			</c:forEach>
			<a href="goToPad.do" class="btn btn-info btn-lg" role="button">Go
				Home</a> <a href="getSongs.do">Back to Albums</a>

		</div>
	</div>
</body>
</html>
