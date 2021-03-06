<p align="center">
<img src="./gitpics/login.png" alt="Home Page Login Screen" style="width:128px;height:128px;">
</p>


# Summary
NotePad is a music based web-app which allows users to to perform CRUD functionality on lists of their favorite Artist,Genres,Songs, and Playlists. NotePad is a full stack application utilizing Spring MVC, JPA,MySQL,HTML and CSS. This web-app implements session control as well as user login while deployed to an Apache Tomcat 8 Server.

This collaborative project was kept on track with the utilization of a Trello board. This was the first time many of use had used Trello. During the build of NotePad we were able to stay on track with daily milestones, as well as communicate effectively using the #slack integrated power-up. Communication was paramount to avoiding merge conflicts as one of the teammates was in a different state for the beginning of the project.


<p align="center">
<img src="./gitpics/pad.png" alt="Groovy Pad"  width="300px" height="245px">
<img src="./gitpics/schema.png" alt="model" width="300px" height="245px">
</p>

## Issues The Team Ran Into:
With many ManyToMany relationships in our schema the team encountered instances where retrieving certain information about songs difficult. One instance was with the genre. Songs are entities which take an album_id and inherit the Genre based on that album. We couldn't retrieve this without first querying the genre by id and then create a new ArrayList our song entity. Then, we iterated over the Album entity looking for genres of those albums and added all songs of those albums into the list of songs created earlier.

[Code Examples](#code-examples)

## Know Issues
- No validation for entries that already exist.
- Form validation was not completed.
- Navigation through the browser back button results in a break.
- Administration deletion has to be done by
  1. Songs
  2. Artists
  3. Album





## If More Time Were Available:
  Stretch goals for the project include:
  - Sharing playlists between users.
  - Comment on playlists from other users.
  - Follow users to stay updated on new playlist.

## In This Document
1. [How to Execute](#how-to-execute)
2. [Class Structure Overview](#class-structure-overview)

## How to Execute
- The web-app is hosted on my AWS server: <a href="http://danrezo.com/" target="">**here**</a>
- Download the entire program as a .war file <a href="https://github.com/DanRezo/NotePad/blob/master/NotePadMVC.war">**here**</a>

## Instructions
1. User arrives on Login page.
2. User logs in an is able to:
    - See there pad, named after their UserName.
    - View a list of current playlists associated to that user.
    - Use CRUD operations to add Artists, Songs or Albums to the database.
    - Change views and get more information on the Playlists associated to them.
    - Use CRUD operations on Playlists.



## Class Structure Overview
   We were challenged to implement multiple controllers within this project. The path we decided to take was one where we broke up the responsibilities of the functionality of the project into three separate controllers. The structure of the project is outlined below.

![alt text](gitpics/Structure.png "Overview of Project Structure")

## Code Examples
``` java
public List <Song> getSongsByGenre(int id) {
		String queryString ="SELECT g FROM Genre g WHERE g.id = :id";
		Genre genre = em.createQuery(queryString, Genre.class).setParameter("id", id).getSingleResult();
		List<Song> songs = new ArrayList<Song>();
		for (Album a : genre.getAlbums()) {
			songs.addAll(a.getSongs());
		}
		return songs;
	}

```

```java
@RequestMapping(path = "logout.do", method = RequestMethod.GET)
public String logout(User newUser, Model model) {

        model.addAttribute("user", new User());
        return "login";

}
```

```HTML
<%@ include file="footer.jsp"%>
```

## Technologies Used

- Java
_ Java Persistent API
- Java Server Pages and JSTL/EL
- Spring MVC and Spring STS
- Gradle Managed Dependencies
- MySQL and MySQL Workbench
- HTML
- CSS
