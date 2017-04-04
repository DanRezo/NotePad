package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import entities.Playlist;
import entities.Song;
import entities.User;

@Controller
@SessionAttributes({"user"})
public class PadController{
	ModelAndView mv = new ModelAndView();

	@Autowired
	PadDAO padDAO;

	@Autowired
	NoteDAO noteDAO;

	@RequestMapping(path = "createArtist.do", method = RequestMethod.GET)
	public String createArtist(Artist artist){
		artist = padDAO.createNewArtist(artist);
		mv.addObject("artist", artist);
		return "artist";
	}

	@RequestMapping(path = "createAlbum.do", method = RequestMethod.GET)
	public String createNewAlbum(Album album){
		album = padDAO.createNewAlbum(album);
		mv.addObject("album", album);
		return "album";
	}

	@RequestMapping(value="retrievePlaylist.do", params = "id", method = RequestMethod.GET)
	public String test(@ModelAttribute("user") User user, @RequestParam("id") int id, Model model){

		model.addAttribute("playlist", noteDAO.showPlaylist(id));

		return "playlist";
	}

//	@RequestMapping(path = "createSong.do", method = RequestMethod.GET)
//		public String createSong(Song song){
//		song = padDAO.create(song);
//		mv.addObject("song", song);
//		return "song";
//	}

	@RequestMapping(path = "editSong.do", method = RequestMethod.GET)
		public String editSong(int id, Song song){
		song = padDAO.edit(id,  song);
		mv.addObject("song", song);
		return "song";
	}
	
	@RequestMapping(path="routeToAddExistingPlaylist.do", method = RequestMethod.GET)
	public String routeToAddExistingPlaylist(Model model, @ModelAttribute("user") User user){
		
		model.addAttribute("user", user);
		model.addAttribute("playlists", noteDAO.showAllPlaylists());
		return "addplaylist";
	}
	
	@RequestMapping(path="createPlaylist.do", method = RequestMethod.POST)
	public String createPlaylist(Model model, Playlist playlist, @ModelAttribute("user") User user){
		
		model.addAttribute("user", noteDAO.createPlaylist(playlist, user));
		return "pad";		
	}
	
	@RequestMapping(path="addExistingPlaylist.do", params = "id", method = RequestMethod.GET)
	public String addExistingPlaylist(Model model, @ModelAttribute("user") User user, 
			@RequestParam("id") int id){
		
		model.addAttribute("user", noteDAO.addPlaylistUser(user, id));
		return "pad";
	}
	
//	@RequestMapping(path="editPlaylist.do", method = RequestMethod.GET)
//	public String editPlaylist() {
//		
//	}

}

//public Song edit(int id, Song song);
//public Artist edit(int id, Artist artist);
//public List <Song> getSongsByAlbum(int id);
//public List <Song> getSongsByArtist(int id);
//public List <Song> getSongsByGenre(int id);
//public List <Album> getAlbumsByArtist(int id);
//public List <Album> getAlbumsByGenre(int id);
//public List<Playlist> showPlaylistByUser(int id);
