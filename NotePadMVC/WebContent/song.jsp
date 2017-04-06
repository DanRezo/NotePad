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
<link rel="stylesheet" type="text/css" href="ui.css">
</head>
<!-- jQuery -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.0.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.0/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
<script>
	$(document).ready(function() {
		// Add smooth scrolling to all links
		$("a").on('click', function(event) {

			// Make sure this.hash has a value before overriding default behavior
			if (this.hash !== "") {
				// Prevent default anchor click behavior
				event.preventDefault();

				// Store hash
				var hash = this.hash;

				// Using jQuery's animate() method to add smooth page scroll
				// The optional number (800) specifies the number of milliseconds it takes to scroll to the specified area
				$('html, body').animate({
					scrollTop : $(hash).offset().top
				}, 800, function() {

					// Add hash (#) to URL when done scrolling (default click behavior)
					window.location.hash = hash;
				});
			} // End if
		});
	});
</script>
</head>
<body>
<div class="songContent">
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<a href="#" class="navbar-brand">NotePad</a>

			<button class="navbar-toggle" data-toggle="collapse"
				data-target=".navHeaderCollapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>

			</button>

			<div class="collapse navbar-collapse navHeaderCollapse">

				<ul class="nav navbar-nav navbar-right">
					<a href="goToPad.do" class="btn btn-info btn-lg" role="button">Go
						Home</a>
				</ul>
			</div>
		</div>
	</div>
			<c:forEach items="${artists}" var="artist">
				<h2 class="notePadHeader">${artist.name}
				</h2><br><br><br>

				<c:forEach items="${artist.albums }" var="album">
					<br>
					<a href="getAlbum.do?id=${album.id}">${album.title}</a>
					<br>
					<c:if test="${playListId != null }">
						<form action="chooseSongToAddToPlayList.do">
							<input type="hidden" name="albumId" value="${album.id }" /> <input
								type="hidden" name="playListId" value="${playListId }" /> <input
								type="submit" name=""
								value="Add Song To Playlist From This Album" />
						</form>
					</c:if>
				</c:forEach>
				<br>
				<br>
			</c:forEach>
	</div>

</body>
</html>