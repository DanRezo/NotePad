package controllers;

import org.hibernate.LazyInitializationException;
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
import entities.AdminLevel;
import entities.Album;
import entities.Playlist;
import entities.User;

@Controller
@SessionAttributes({"user", "playlist"})
public class PadController{
	ModelAndView mv = new ModelAndView();

	@Autowired
	PadDAO padDAO;

	@Autowired
	NoteDAO noteDAO;

	@RequestMapping(value="retrievePlaylist.do", params = "playlistId", method = RequestMethod.GET)
	public String test(@RequestParam("playlistId") int playlistId, Model model){

		Playlist playlist = noteDAO.showPlaylist(playlistId);
		
		try {
			playlist.getSongs().size();
		} catch (LazyInitializationException e) {
			model.addAttribute("emptyPlaylist", true);	
		}
		
		model.addAttribute("playlist", playlist);

		return "playlist";
	}

	@RequestMapping(path="routeToAddExistingPlaylist.do", method = RequestMethod.GET)
	public String routeToAddExistingPlaylist(Model model, @ModelAttribute("user") User user){

		model.addAttribute("user", user);
		model.addAttribute("playlists", noteDAO.showAllPlaylists());
		return "addplaylist";
	}
	
	@RequestMapping(path="deleteAlbums.do", params = "albumId", method = RequestMethod.GET)
	public String deleteAlbums(Model model, @ModelAttribute("user") User user, 
			@RequestParam("albumId") int albumId){
				
		padDAO.deleteAlbum(albumId);
		
		model.addAttribute("user", user);
		model.addAttribute("isAdmin", user.getAdminLevel() == AdminLevel.ADMIN);
		return "pad";
	}

	@RequestMapping(path="createPlaylist.do", params = "title", method = RequestMethod.POST)
	public String createPlaylist(Model model, @ModelAttribute("title") String title,
			@ModelAttribute("user") User user){

		model.addAttribute("user", noteDAO.createPlaylist(title, user));
		model.addAttribute("isAdmin", user.getAdminLevel() == AdminLevel.ADMIN);
		return "pad";
	}

	@RequestMapping(path="addExistingPlaylist.do", params = "playlistid", method = RequestMethod.GET)
	public String addExistingPlaylist(Model model, @ModelAttribute("user") User user,
			@RequestParam("playlistid") int id){

		model.addAttribute("user", noteDAO.addPlaylistUser(user, id));
		model.addAttribute("isAdmin", user.getAdminLevel() == AdminLevel.ADMIN);
		return "pad";
	}
	
	@RequestMapping(path="goToPad.do", method = RequestMethod.GET)
	public String goToPad(Model model, @ModelAttribute("user") User user){
		
		model.addAttribute("user", user);
		model.addAttribute("isAdmin", user.getAdminLevel() == AdminLevel.ADMIN);
		return "pad";
	}
	
	@RequestMapping(path="deletePlaylist.do", params = "playlistId", method = RequestMethod.GET)
	public String deletePlaylist(Model model, @ModelAttribute("user") User user,
			@RequestParam("playlistId") int playlistId){
		
		System.out.println(user + "****************&&&&&****************");

		model.addAttribute("user", noteDAO.destroyPlaylist(user.getId(), playlistId));
		model.addAttribute("isAdmin", user.getAdminLevel() == AdminLevel.ADMIN);
		return "pad";
	}
	
}
