package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

//List

	@Override
	public List<Artist> listArtist(){
		String queryString = "Select a From Artist a";
		List<Artist>artists = em.createQuery(queryString, Artist.class).getResultList();
		return artists;
	}

	@Override
	public List<Album> listAlbum(){
		String queryString = "Select a From Album a";
		List<Album>albums = em.createQuery(queryString, Album.class).getResultList();
		return albums;
	}

	@Override
	public List<Song> listSongs(){
		String queryString = "Select s From Song s";
		List<Song> songs = em.createQuery(queryString, Song.class).getResultList();
		return songs;
	}

//Create
	@Override
	public Artist createNewArtist(Artist artist){
		try {
			String queryString = "SELECT a FROM Artist a WHERE a.name = :name";
			em.createQuery(queryString, Artist.class).setParameter("name", artist.getName()).getSingleResult();

			return null;

		} catch (NoResultException e ) {
			em.persist(artist);
			em.flush();

			return artist;
		}

	}
	@Override
	public Album createNewAlbum(Album album){
		try {
			String queryString = "SELECT a FROM Album a WHERE a.title = :title";
			em.createQuery(queryString, Album.class).setParameter("name", album.getTitle()).getSingleResult();

			return null;

		} catch (NoResultException e ) {
			em.persist(album);
			em.flush();

			return album;
		}

	}
	@Override
	public Song createNewSongWithNewAlbum(Song song){
	em.persist(song);
	em.flush();
	return song;
	}
	@Override
	public Song createNewSongWithExistingAlbum(Song song, Album album){
		em.persist(song);
		em.flush();
		return song;
	}
//Update
	@Override
	public Album edit(int id, Album album){
		Album alb = em.find(Album.class, id);

		alb.setTitle(album.getTitle());
		alb.setGenres(album.getGenres());
		alb.setSongs(album.getSongs());
		alb.setReleaseYear(album.getReleaseYear());

		return alb;
	}

	@Override
	public Song edit(int id, Song song){
		Song s = em.find(Song.class, id);

		s.setAlbum(song.getAlbum());
		s.setTitle(song.getTitle());
		return s;

		}

	@Override
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

	@Override
	public List <Album> getAlbumsByArtist(int id) {
		String queryString = "Select a From Artist a JOIN FETCH a.albums where a.id = :id ";
		Artist artist = em.createQuery(queryString, Artist.class).setParameter("id", id).getSingleResult();
		return artist.getAlbums();
		}

	@Override
	public List <Album> getAlbumsByGenre(int id) {
		String queryString = "Select g FROM Genre g JOIN FETCH g.albums where g.id = :id";
		Genre genre = em.createQuery(queryString, Genre.class).setParameter("id", id).getSingleResult();
		return genre.getAlbums();
		}

	@Override
	public List<Playlist> showPlaylistByUser(int id){
		String queryString = "Select p From Playlist p JOIN FETCH p.users WHERE p.id = :id ";
		User user = em.createQuery(queryString, User.class).setParameter("id", id).getSingleResult();
		return user.getPlaylists();

	}
	@Override
	public Album getAlbumById(int id) {
		return em.find(Album.class, id);
	}
	@Override
	public Artist showArtist(int id) {

		return em.find(Artist.class, id);
	}
	@Override
	public Album showAlbum(int id) {

		return em.find(Album.class, id);
	}
	@Override
	public Song showSong(int id) {

		return em.find(Song.class, id);
	}

//	Delete

	@Override
	public boolean removeArtist(Artist artist) {

		try {
			String queryString = "SELECT a FROM Artist a WHERE a.name = :name";
			em.createQuery(queryString, Song.class).setParameter("name", artist.getName()).getSingleResult();


			em.remove(artist);
			em.flush();

			return true;

		} catch (NoResultException e ) {

			return false;
		}
	}

	@Override
	public boolean removeSong(Song song) {

		try {
			String queryString = "SELECT s FROM Song s WHERE s.title = :title";
			em.createQuery(queryString, Song.class).setParameter("title", song.getTitle()).getSingleResult();


			em.remove(song);
			em.flush();

			return true;

		} catch (NoResultException e ) {

			return false;
		}
	}

	@Override
	public boolean removeAlbum(Album album) {

		try {
			String queryString = "SELECT a FROM Album a WHERE a.title = :title";
			em.createQuery(queryString, Album.class).setParameter("title", album.getTitle()).getSingleResult();


			em.remove(album);
			em.flush();

			return true;

		} catch (NoResultException e ) {

			return false;
		}
	}

	public boolean deleteArtist(int id) {
		Artist deadArtist = em.find(Artist.class, id);
		em.remove(deadArtist);
		return em.contains(deadArtist);
	}

	@Override
	public boolean deleteAlbum(Album album) {
		Album deadAlbum = em.find(Album.class, album.getId());
		em.remove(deadAlbum);
		return em.contains(deadAlbum);
	}

	@Override
		public boolean deleteSong(Song song) {
		Song deadSong = em.find(Song.class, song.getId());
		em.remove(deadSong);
		return em.contains(deadSong);
	}
}
