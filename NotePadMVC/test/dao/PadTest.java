package dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import data.PadDAO;
import entities.Album;
import entities.Artist;
import entities.Song;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "../WEB-INF/Test-context.xml"})
@WebAppConfiguration
@Transactional
public class PadTest {
	
	 @Autowired
	  private WebApplicationContext wac;
	
	  @Autowired
	  private PadDAO dao;
	  
	  @PersistenceContext
	  private EntityManager em;
	  
	  @Before
	  public void setUp() {
	    dao =  (PadDAO)wac.getBean("padDAO");
	  }
	  @After
	  public void tearDown() {
	    dao = null;
	    em = null;
	    wac = null;
	  }
	  
// Testing Create
	  @Test
	  public void test_creatNewArtist(){
		   Artist a = new Artist();
		   Album bum = new Album();
		   List<Album> albums = new ArrayList<>();
		   
		   bum.setTitle("What UP");
		   albums.add(bum);
		   dao.createNewArtist(a);
		   a.setName("D-Reezy");
		   a.setAlbums(albums);
		   
	  }
//	  
//	  @Test
//	  public void test_creatNewAlbum(){
//		  
//		  Album Lost = new Album();
//		  
//		  Lost.setTitle("Lost");
//		  Lost.setReleaseYear(2017);
//		  Lost.set
//	  }
//	  
//	  @Test
//	  public void test_creatNewSong(){
//		  
//		  Song s = new Song();
//		  
//		assertEquals(s.setTitle("Wonderer"));
//		  s.setTitle("Up");
//		  s.setTitle("Friends");
//		  s.setTitle("Script");
//		  
//		  s.setAlbum("Lost");
//		  
//	  }
	  
// Testing Read
	  @Test
	  public void test_get_songs_by_Artist(){
		  assertEquals(7, dao.getSongsByArtist(1).size());
	  }
	  
	  @Test
	  public void test_get_songs_by_Album(){
		  assertEquals(3, dao.getSongsByAlbum(1).size());
	  }
	  
	  @Test
	  public void test_get_songs_by_Genre(){
		  assertEquals(4, dao.getSongsByGenre(3).size());
	  }
	  
	  @Test
	  public void test_get_Album_by_Genre(){
		  assertEquals(2, dao.getAlbumsByGenre(2).size());
	  }
	  
	  @Test
	  public void test_get_Album_by_Artist(){
		  assertEquals(2, dao.getAlbumsByArtist(1).size());
	  }
	  
	  
// Testing Update
	  @Test
	  public void test_edit_Song(){
       	  Song s = em.find(Song.class, 1);
       	  
       	  s.getAlbum();
       	  s.setTitle("Loser");
       	  s.setTitle(s.getTitle());
       	  
       	  assertEquals("Loser", s.getTitle());
       	  
       	  
	  }
	  
	  @Test
	  public void test_edit_Album(){
		  Album a = em.find(Album.class, 1);
		  
		  a.setTitle("RayBandShades");
		  a.setTitle(a.getTitle());
		  
		  assertEquals("RayBandShades", a.getTitle());
	  }
	  
	  @Test
	  public void test_edit_Artist(){
		  Artist art = em.find(Artist.class, 1);
		  
		  art.setName("Lincoln Parkers");
		  art.setName(art.getName());
		  
		  
		  assertEquals("Lincoln Parkers", art.getName());
		  
	  }
	  
	  // Testing Delete
	  
		
}