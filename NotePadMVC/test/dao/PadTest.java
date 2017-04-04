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
		   Album album = new Album();
		   List<Album> albums = new ArrayList<>();
		   
		   album.setTitle("What UP");
		   albums.add(album);
		   a.setName("D-Reezy");
		   a.setAlbums(albums);
		   
		   Artist p = dao.createNewArtist(a);

		   assertEquals("D-Reezy",p.getName());
		   assertEquals("What UP",p.getAlbums().get(0).getTitle());
	  }
	  
	  @Test
	  public void test_creatNewAlbum(){
		  Album Lost = new Album();
		  List<Album> albums = new ArrayList<Album>();
		  
		  Lost.setTitle("Lost");
		  Lost.setReleaseYear(2017);
		  albums.add(Lost);
		  
		  Album a = dao.createNewAlbum(Lost);
		  
		  assertEquals("Lost",a.getTitle());
		  assertEquals(2017 , a.getReleaseYear());
		 
	  }
	  
	  @Test
	  public void test_create_New_Song_with_Album(){
		  Song s = new Song();
		  
		  
		  s.setTitle("Up");
		  Album a = dao.getAlbumById(1);
		  s.setAlbum(a);
	  }
	  
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