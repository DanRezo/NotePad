package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Artist;
import entities.Category;

public class ArtistTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private Artist artist;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("TestNotePad");
		em = emf.createEntityManager();
		artist = em.find(Artist.class,3);
	}

	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();

	}
	
	@Test
	public void test_Artist_Info(){
		assertEquals(3, artist.getId());
		assertEquals("Chance The Rapper", artist.getName());
		assertEquals(1, artist.getAlbums().size());
		
				
	}
	@Test
	public void test_Artist_Genre(){
		assertEquals(Category.HIP_HOP, artist.getAlbums().get(0).getGenres().get(0).getGenre());
	}
	
	@Test 
	public void test_Artist_in_Playlist(){
		assertEquals(2, artist.getAlbums().get(0).getSongs().get(0).getPlaylists().size());
		
	}
	
	@ Test
	public void test_Artist_Songs(){
		assertEquals(4, artist.getAlbums().get(0).getSongs().size());
	}
}