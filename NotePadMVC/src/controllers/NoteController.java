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
	
	@RequestMapping(path = "artist.do", method = RequestMethod.GET)
	public ModelAndView listArtist(){
		List<Artist> artists = padDAO.listArtist();
		mv.addObject("artists", artists);
		mv.setViewName("artist");
		return mv;
	}
	
	@RequestMapping(path="song.do", params = "Artists", method = RequestMethod.GET)
	public ModelAndView listSong(@RequestParam("Artists") int Artists){
		List<Song> songs = padDAO.getSongsByArtist(Artists);
		mv.addObject("Songs", songs);
		mv.setViewName("song");
		return mv;
	}

	@RequestMapping(path = "newArtist.do", method = RequestMethod.GET)
	public String createArtist(Artist artist){
		Artist newArtist = padDAO.createNewArtist(artist);
		mv.addObject("newArtist", newArtist);
		return "artist";
	}
	
	@RequestMapping(path = "editArtist.do", method = RequestMethod.GET)
	public String editArtist(int id, Artist artist){
		Artist newArtist = padDAO.edit(id, artist);
		mv.addObject("newArtist", newArtist);
		return "artist";
	}
		
	@RequestMapping(path = "deleteArtist.do", method = RequestMethod.GET)
	public String deleteArtist(Artist artist){
		padDAO.deleteArtist(artist);
		return "artist";
	}

	@RequestMapping(path = "newAlbum.do", method = RequestMethod.GET)
	public String createNewAlbum(Album album){
		Album newAlbum = padDAO.createNewAlbum(album);
		mv.addObject("newAlbum", newAlbum);
		return "album";
	}
	@RequestMapping(path = "editAlbum.do", method = RequestMethod.GET)
	public String edit(int id, Album album){
		Album newAlbum = padDAO.edit(id, album);
		mv.addObject("newAlbum", newAlbum);
		return "album";
	}
	
	@RequestMapping(path = "deleteAlbum.do", method = RequestMethod.GET)
	public String deleteAlbum(Album album){
		padDAO.deleteAlbum(album);
		return "album";
	}
	
	@RequestMapping(path = "newSongExistingAlbum.do" , method = RequestMethod.GET)
	public String createNewSongWithExistingAlbum(Song song, Album album){
		Song newSong = padDAO.createNewSongWithExistingAlbum(song, album);
		mv.addObject("newSong", newSong);
		return "song";
	}
	
	@RequestMapping(path = "NewSongNewAlbum.do" , method = RequestMethod.GET)
	public String createNewSongWithNewAlbum(Song song){
		Song newSong = padDAO.createNewSongWithNewAlbum(song);
		mv.addObject("newSong", newSong);
		return "song";
	}
	
	@RequestMapping(path = "editSong.do" , method = RequestMethod.GET)
	public String editSong(int id, Song song){
		Song newSong = padDAO.edit(id, song);
		mv.addObject("newSong", newSong);
		return "song";
	}
	
	@RequestMapping(path = "deleteSong.do", method = RequestMethod.GET)
	public String deleteSong(Song song){
		padDAO.deleteSong(song);
		return "song";
	}

}
