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
<title>${user.alias}</title>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Gloria+Hallelujah"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="ui.css">

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
	<div class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<a href="#" class="navbar-brand">NotePad</a>
			<a href="#" class="navbar-brand"><img src="./photos/noteLogo.png"></a>

			<button class="navbar-toggle" data-toggle="collapse"
				data-target=".navHeaderCollapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> 
				<span class="icon-bar"></span>

			</button>

			<div class="collapse navbar-collapse navHeaderCollapse">

				<ul class="nav navbar-nav navbar-right">
				

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> Music <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="artist.do">Browse Artist</a></li>
							<li><a href="getSongs.do">Browse Songs</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> PlayLists <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="routeToAddExistingPlaylist.do">Subscribe to
									Existing Play List</a></li>
						</ul></li>
				</ul>


			</div>
		</div>

	</div>
	<div class="container">
		<div class="page-header">
			<ul>
				<li><h1 class="notePadHeader">${user.alias}</h1></li>

				<li class="albumForm"><form action="createPlaylist.do"
						method="POST">
						<input type="text" name="title" placeholder="Title" />
						<button type="submit" class="btn btn-info btn-lg">Create
							New Playlist</button>
					</form></li>
			</ul>
		</div>
		<c:forEach var="playlist" items="${user.playlists}">
			<h2>
				<a href="retrievePlaylist.do?id=${playlist.id}">${playlist.title}</a>
			</h2>
		</c:forEach>
		
	</div>
	<!-- <h3>OR</h3> -->
	<!-- <a href="routeToAddExistingPlaylist.do">Subscribe to an existing Playlist</a>
<h3>OR</h3>
<div><a href="getSongs.do">Get Songs</a><a href="NewSongNewAlbum.do">Add Note</a></div>
<h3>OR</h3>
<a href="artist.do">Browse Artists</a> -->

</body>
</html>
