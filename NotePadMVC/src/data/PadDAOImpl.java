package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Album;
import entities.Artist;
import entities.Genre;
import entities.Playlist;
import entities.Song;
import entities.User;

@Transactional
@Repository
public class PadDAOImpl  implements PadDAO{

	@PersistenceContext
	private EntityManager em;

//Create	
	@Override
	public Artist createNewArtist(Artist artist){
		em.persist(artist);
		em.flush();
		return artist;
	}
	
	@Override
	public Album create(Album album){
		
		em.persist(album);
		em.flush();
		return album;
	}
	
	@Override
	public Song create(Song song){
	em.persist(song);
	em.flush();
	return song;
	}
//Update
	public Album edit(int id, Album album){
		Album alb = em.find(Album.class, id);
		
		alb.setTitle(album.getTitle());
		alb.setGenres(album.getGenres());
		alb.setSongs(album.getSongs());
		alb.setReleaseYear(album.getReleaseYear());
		
		return alb;
	}

	public Song edit(int id, Song song){
		Song s = em.find(Song.class, id);
		
		s.setAlbum(song.getAlbum());
		s.setTitle(song.getTitle());
		return s;
		
		}
	
	public Artist edit(int id, Artist artist){
		Artist a = em.find(Artist.class, id);
		
		a.setName(artist.getName());
		a.setPicture(artist.getPicture());
		return a;
	}
//Read
	@Override
	
	public List <Song> getSongsByAlbum(int id) {
		return em.find(Album.class, id).getSongs();
	}
	
	@Override
	public List <Song> getSongsByArtist(int id) {
		String queryString ="SELECT a FROM Artist a WHERE a.id = :id";
		Artist artist = em.createQuery(queryString, Artist.class).setParameter("id", id).getSingleResult();
		List<Song> songs = new ArrayList<Song>();
		for (Album a : artist.getAlbums()) {
			songs.addAll(a.getSongs());
		}
		return songs;
	}
	
	@Override
	public List <Song> getSongsByGenre(int id) {
		String queryString ="SELECT g FROM Genre g WHERE g.id = :id";
		Genre genre = em.createQuery(queryString, Genre.class).setParameter("id", id).getSingleResult();
		List<Song> songs = new ArrayList<Song>();
		for (Album a : genre.getAlbums()) {
			songs.addAll(a.getSongs());
		}
		return songs;
	}
	
	public List <Album> getAlbumsByArtist(int id) {
		String queryString = "Select a From Artist a JOIN FETCH a.albums where a.id = :id ";
		Artist artist = em.createQuery(queryString, Artist.class).setParameter("id", id).getSingleResult();
		return artist.getAlbums();	
		}
	
	public List <Album> getAlbumsByGenre(int id) {
		String queryString = "Select g FROM Genre g JOIN FETCH g.albums where g.id = :id";
		Genre genre = em.createQuery(queryString, Genre.class).setParameter("id", id).getSingleResult();
		return genre.getAlbums();	
		}
	
	public List<Playlist> showPlaylistByUser(int id){
		String queryString = "Select p From Playlist p JOIN FETCH p.users WHERE p.id = :id ";
		User user = em.createQuery(queryString, User.class).setParameter("id", id).getSingleResult();
		return user.getPlaylists();
		
	}
	
//	Delete
	

	
}

