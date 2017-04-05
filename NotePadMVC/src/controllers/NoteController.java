package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.NoteDAO;
import data.PadDAO;
import entities.Album;
import entities.Artist;
import entities.Song;
import entities.User;

@Controller
@SessionAttributes({"user"})
public class NoteController{
	ModelAndView mv = new ModelAndView();

	@Autowired
	PadDAO padDAO;

	@Autowired
	NoteDAO noteDAO;
	
	@RequestMapping(path = "albumByArtist.do" , method = RequestMethod.GET)
	public ModelAndView albumByArtist(@RequestParam("Artists") int Artists){
		List<Album> albums = padDAO.getAlbumsByArtist(Artists);
		mv.addObject("artist", Artists);
		mv.addObject("albums", albums);
		mv.setViewName("albumbyartist");
		return mv;
	}
	
	@RequestMapping(path = "artist.do", method = RequestMethod.GET)
	public ModelAndView listArtist(){
		List<Artist> artists = padDAO.listArtist();
		mv.addObject("artists", artists);
		mv.setViewName("artist");
		return mv;
	}

	@RequestMapping(path="getSongs.do", method = RequestMethod.GET)
	public ModelAndView listSong(){
		List<Artist> artists = padDAO.getArtists();
		mv.addObject("artists", artists);
		mv.setViewName("song");
		return mv;
	}
	
	@RequestMapping(path="getAlbum.do", method = RequestMethod.GET)
	public ModelAndView listSong(@RequestParam("id") int id){
		Album album = padDAO.getSongsByAlbumById(id);
		mv.addObject("album", album);
		mv.setViewName("album");
		return mv;
	}
	
	@RequestMapping(path="admin.do", method = RequestMethod.GET)
	public ModelAndView list(){
		List<Artist> artists = padDAO.listArtist();
		List<Album> albums = padDAO.listAlbum();
		List<Song> songs = padDAO.listSongs();
		mv.addObject("songs", songs);
		mv.addObject("artists", artists);
		mv.addObject("albums" , albums);
		mv.setViewName("admin");
		
		return mv;
	}
	
	@RequestMapping(path = "newArtist.do", method = RequestMethod.GET)
	public ModelAndView createArtist(){
//		Artist newArtist = padDAO.createNewArtist(artist);
//		mv.addObject("newArtist", newArtist);
		mv.setViewName("album");
		return mv;
	}

	@RequestMapping(path = "deleteArtist.do", method = RequestMethod.GET)
	public ModelAndView deleteArtist(@RequestParam("Artists") int Artists){
		if (padDAO.deleteArtist(Artists))
			mv.setViewName("deleteFail");
		else
			mv.setViewName("success");
		return mv;

	}

	@RequestMapping(path = "newAlbum.do", method = RequestMethod.GET)
	public ModelAndView createNewAlbum(Album album){
		Album newAlbum = padDAO.createNewAlbum(album);
		mv.addObject("newAlbum", newAlbum);
		mv.setViewName("album");
		return mv;
	}
	
	@RequestMapping(path = "editAlbum.do", method = RequestMethod.GET)
	public ModelAndView edit(int id, Album album){
		Album newAlbum = padDAO.edit(id, album);
		mv.addObject("newAlbum", newAlbum);
		mv.setViewName("album");
		return mv;
	}

	@RequestMapping(path = "deleteAlbum.do", method = RequestMethod.GET)
	public ModelAndView ModelAndView(@RequestParam("album") int album){
		if (padDAO.deleteAlbum(album))
		   mv.setViewName("failure");
		else{
			mv.setViewName("successalbum");
		}
		
		System.out.println("SUCCESS DELETE");
		return mv;
	}

	@RequestMapping(path = "newSongExistingAlbum.do" , method = RequestMethod.GET)
	public ModelAndView createNewSongWithExistingAlbum(Song song, Album album){
		Song newSong = padDAO.createNewSongWithExistingAlbum(song, album);
		mv.addObject("newSong", newSong);
		mv.setViewName("song");
		return mv;
	}

	@RequestMapping(path = "editSongForm.do" , method = RequestMethod.GET)
	public ModelAndView editSongForm(@RequestParam("id") int id,@RequestParam("albumId") int albumId){
		ModelAndView mv = new ModelAndView();
		Song newSong = padDAO.getSongById(id);
		Album album = padDAO.getAlbumById(albumId);
		mv.setViewName("edit");
		mv.addObject("song", newSong);
		mv.addObject("album", album);
		return mv;
	}

	@RequestMapping(path = "editSong.do" , method = RequestMethod.GET)
	public String editSong(@RequestParam("songId") int id, Song song){
		Song newSong = padDAO.edit(id, song);
		mv.addObject("newSong", newSong);
		return "edit";
	}

	@RequestMapping(path = "deleteSong.do", method = RequestMethod.GET)
	public ModelAndView deleteSong(@RequestParam("id") int id){
		if (padDAO.deleteSong(id))
		mv.setViewName("failure");
		else{
		mv.setViewName("sucesssong");
		}
		return mv;
	}

}
