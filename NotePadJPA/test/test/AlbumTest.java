
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
		System.out.println("test");
		album = em.find(Album.class, 1);
		System.out.println("test");
	}

	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();

	}

	@Test
	public void test_Album_has_songs() {
		assertEquals("", album.getSongs().size());

	}
}
