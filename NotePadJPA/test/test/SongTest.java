package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Song;

public class SongTest {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	Song song = null;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("TestNotePad");
		em = emf.createEntityManager();
		song = em.find(Song.class, 21);
	}

	@Test
	public void test_song_association() {
		assertEquals("Ignition", song.getTitle());
	}

	@Test
	public void test_song_playlist_association() {
		assertEquals(2, song.getPlaylists().size());
	}

	@Test
	public void test_song_album_association() {
		assertEquals("Chocolate Factory", song.getAlbum().getTitle());
	}

	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}

}
