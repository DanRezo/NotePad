package data;

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

	
	@Override
	public Artist create(Artist artist){
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
	
	public Album edit(int id, Album album){
		Album alb = em.find(Album.class, 1);
		
		alb.set
		Return
	}

	
	public Song edit(int id, Song song){
		Song s = em.find(Song.class, 1);
		
		s.setAlbum(song.getAlbum());
		s.setTitle(song.getTitle());
		return s;
		
		}
	
	@Override
	public List <Song> getSongsByAlbum(int id) {
		String queryString ="SELECT a FROM Album a JOIN FETCH a.songs where a.id = :id";
		Album album = em.createQuery(queryString, Album.class).setParameter("id", id).getSingleResult();
		return album.getSongs();
	}
	
	
	@Override
	public List <Song> getSongsByArtist(int id) {
		String queryString ="SELECT a FROM Artist a JOIN FETCH a.albums.songs WHERE a.id = :id";
		Artist artist = em.createQuery(queryString, Artist.class).setParameter("id", id).getSingleResult();
		return artist.getSongs();
	}
	
	@Override
	public List <Song> getSongsByGenre(int id) {
		String queryString ="SELECT a FROM Artist a JOIN FETCH a.albums.songs WHERE a.id = :id";
		Artist artist = em.createQuery(queryString, Artist.class).setParameter("id", id).getSingleResult();
		return artist.getSongs();
	}
	
	@Override
	public List <Song> getSongsByGenre(int id){
		String queryString = "Select g From  a JOIN FETCH a.";
		Genre genre = em.createQuery(queryString, Genre.class).setParameter("id",id).getSingleResult();
		return genre.setSongs;
	}
	
	public List <Artist> getAlbumsByArtist(int id) {
		String queryString = "";
		Artist artist = em.createQuery(queryString, Artist.class).setParameter("id", id).getSingleResult();
		return artist.getAlbums();	
		}
	
	public List <Artist> getAlbumsByGenre(int id) {
		String queryString = "Select ";
		Artist artist = em.createQuery(queryString, Artist.class).setParameter("id", id).getSingleResult();
		return artist.getAlbums();	
		}
	
	public List<Playlist> showPlaylistByUser(int id){
		String queryString = "Select p From Playlist p JOIN FETCH p.users WHERE p.id = :id ";
		User user = em.createQuery(queryString, User.class).setParameter("id", id).getSingleResult();
		return user.getPlaylists();
		
	}
	
}

