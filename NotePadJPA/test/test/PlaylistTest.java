package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Playlist;
import entities.Song;
import entities.User;

public class PlaylistTest {
	
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	Playlist playlist = null;
	Song song = null;
	User user = null;
	
	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("notepad");
		em = emf.createEntityManager();
		playlist = em.find(Playlist.class, 1);
		song = em.find(Song.class, 21);
		user = em.find(User.class, 1);
	}
	
	@Test
	public void test_playlist_song_association() {
		assertEquals("My First Playlist", playlist.getTitle());
		assertEquals(10, playlist.getSongs().size());
	}
	
	@Test
	public void test_song_playlist_association() {
		assertEquals("Ignition", song.getTitle());
		assertEquals(2, song.getPlaylists().size());
	}
	
	@Test
	public void test_playlist_user_association() {
		assertEquals("My First Playlist", playlist.getTitle());
		assertEquals(2, playlist.getUsers().size());
	}
	
	@Test
	public void test_user_playlist_association() {
		assertEquals("gmurricane", user.getAlias());
		assertEquals(3, user.getPlaylists().size());
	}
	
	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}

}
