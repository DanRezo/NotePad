package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Playlist;

public class PlaylistTest {
	
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	Playlist playlist = null;
	
	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("TestNotePad");
		em = emf.createEntityManager();
		playlist = em.find(Playlist.class, 1);
	}
	
	@Test
	public void test_playlist_association() {
		assertEquals("My First Playlist", playlist.getTitle());
	}
	
	@Test
	public void test_playlist_owner_association() {
		assertEquals("gmurricane", playlist.getOwner().getAlias());
	}
	
	@Test
	public void test_playlist_song_association() {
		assertEquals(10, playlist.getSongs().size());
	}
	
	@Test
	public void test_playlist_user_association() {
		assertEquals(2, playlist.getUsers().size());
	}
	
	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}

}
