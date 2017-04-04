package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

//	@RequestMapping(path = "artist.do", method = RequestMethod.GET)
//	public String createArtist(Artist artist){
//		Artist newArtist = padDAO.createNewArtist(artist);
//		mv.addObject("newArtist", newArtist);
//		return "artist";
//	}
//	
//	@RequestMapping(path = "artist.do", method = RequestMethod.GET)
//	public String editArtist(int id, Artist artist){
//		Artist newArtist = padDAO.edit(id, artist);
//		mv.addObject("newArtist", newArtist);
//		return "artist";
//	}
//		
//	@RequestMapping(path = "artist.do", method = RequestMethod.GET)
//	public String deleteArtist(Artist artist){
//		padDAO.deleteArtist(artist);
//		return "artist";
//	}
//
//	@RequestMapping(path = "album.do", method = RequestMethod.GET)
//	public String createNewAlbum(Album album){
//		Album newAlbum = padDAO.createNewAlbum(album);
//		mv.addObject("newAlbum", newAlbum);
//		return "album";
//	}
//	@RequestMapping(path = "album.do", method = RequestMethod.GET)
//	public String edit(int id, Album album){
//		Album newAlbum = padDAO.edit(id, album);
//		mv.addObject("newAlbum", newAlbum);
//		return "album";
//	}
//	
//	@RequestMapping(path = "album.do", method = RequestMethod.GET)
//	public String deleteAlbum(Album album){
//		padDAO.deleteAlbum(album);
//		return "album";
//	}
//	
//	@RequestMapping(path = "song.do" , method = RequestMethod.GET)
//	public String createNewSongWithExistingAlbum(Song song, Album album){
//		Song newSong = padDAO.createNewSongWithExistingAlbum(song, album);
//		mv.addObject("newSong", newSong);
//		return "song";
//	}
//	
//	@RequestMapping(path = "song.do" , method = RequestMethod.GET)
//	public String createNewSongWithNewAlbum(Song song){
//		Song newSong = padDAO.createNewSongWithNewAlbum(song);
//		mv.addObject("newSong", newSong);
//		return "song";
//	}
//	
//	@RequestMapping(path = "song.do" , method = RequestMethod.GET)
//	public String editSong(int id, Song song){
//		Song newSong = padDAO.edit(id, song);
//		mv.addObject("newSong", newSong);
//		return "song";
//	}
//	
//	@RequestMapping(path = "song.do", method = RequestMethod.GET)
//	public String deleteSong(Song song){
//		padDAO.deleteSong(song);
//		return "song";
//	}

}
