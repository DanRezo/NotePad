
package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Album;

public class AlbumTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private Album album;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("TestNotePad");
		em = emf.createEntityManager();
		album = em.find(Album.class, 1);
	}

	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();

	}
	
	@Test
	public void test_Album_Info(){
		assertEquals("MTV Unplugged in New York (Live)", album.getTitle());
		assertEquals(1994, album.getReleaseYear());
		assertEquals( 3, album.getSongs().size());
				
	}
	
	@Test
	public void test_Album_Genre(){
		assertEquals("ROCK", album.getGenres().toString());
	}
	
	
}
