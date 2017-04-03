package controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import data.PadDAO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import entities.Album;
import entities.Artist;
import entities.Playlist;
import entities.Song;
import entities.User;

@Controller
@SessionAttributes({"user"})
public class PadController{
	ModelAndView mv = new ModelAndView();
	
	@Autowired
	PadDAO padDAO;

	@RequestMapping(path = "createArtist.do", method = RequestMethod.GET)
	public String createArtist(Artist artist){
		artist = padDAO.createNewArtist(artist);
		mv.addObject("artist", artist);
		return "artist";
	}
	
	@RequestMapping(path = "createAlbum.do", method = RequestMethod.GET)
	public String createAlbum(Album album){
		album = padDAO.create(album);
		mv.addObject("album", album);
		return "album";
	}
	
	@RequestMapping(path = "createSong.do", method = RequestMethod.GET)
		public String createSong(Song song){
		song = padDAO.create(song);
		mv.addObject("song", song);
		return "song";
	}
	
	@RequestMapping(path = "editSong.do", method = RequestMethod.GET)
		public String editSong(int id, Song song){
		song = padDAO.edit(id,  song);
		mv.addObject("song", song);	
		return "song";
	}
	
}

//public Song edit(int id, Song song);
//public Artist edit(int id, Artist artist);
//public List <Song> getSongsByAlbum(int id);
//public List <Song> getSongsByArtist(int id);
//public List <Song> getSongsByGenre(int id);
//public List <Album> getAlbumsByArtist(int id); 
//public List <Album> getAlbumsByGenre(int id);
//public List<Playlist> showPlaylistByUser(int id);
