package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.User;

public class UserTest {
	
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	User user = null;
	
	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("TestNotePad");
		em = emf.createEntityManager();
		user = em.find(User.class, 1);
	}
	
	@Test
	public void test_user_association() {
		assertEquals("gmurricane", user.getAlias());
	}
	
	@Test
	public void test_user_owner_association() {
		assertEquals(2, user.getOwnedPlaylists().size());
	}
	
	@Test
	public void test_user_playlist_association() {
		assertEquals(3, user.getPlaylists().size());
	}
	
	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}

}
