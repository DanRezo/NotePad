package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Category;
import entities.Genre;

public class GenreTest {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private Genre genre;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("TestNotePad");
		em = emf.createEntityManager();
		genre = em.find(Genre.class, 3);
	}

	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();

	}

	@Test
	public void test_Genre() {
		assertEquals(Category.POP, genre.getGenre().POP);

	}

	@Test
	public void test_Artist_in_Genre() {
		assertEquals(1, genre.getAlbums().size());
	}
	
	@Test
	public void test_songs_in_Genre(){
		assertEquals(4, genre.getAlbums().get(0).getSongs().size());
	}
}
