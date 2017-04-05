package controllers;

import java.util.List;

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
import entities.Playlist;
import entities.Song;
import entities.User;

@Controller
@SessionAttributes({"user", "playlist"})
public class PadController{
	ModelAndView mv = new ModelAndView();

	@Autowired
	PadDAO padDAO;

	@Autowired
	NoteDAO noteDAO;

	@RequestMapping(value="retrievePlaylist.do", params = "id", method = RequestMethod.GET)
	public String test(@RequestParam("id") int id, Model model){

		Playlist playlist = noteDAO.showPlaylist(id);
		
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
	
	@RequestMapping(path="goToPad.do", method = RequestMethod.GET)
	public String goToPad(Model model, @ModelAttribute("user") User user){
		
		model.addAttribute("user", user);
		return "pad";
	}
	
	@RequestMapping(path="deletePlaylist.do", params = "id", method = RequestMethod.GET)
	public String deletePlaylist(Model model, @ModelAttribute("user") User user,
			@RequestParam("id") int id){
		
		Playlist playlist = noteDAO.showPlaylist(id);
		
		noteDAO.destroyPlaylist(user, playlist);
		
		model.addAttribute("user", user);
		
//		if (!successfulDelete) {
//			model.addAttribute("notTheOwner", true);
//			model.addAttribute("playlist", playlist);
//			return "playlist";
//		}
		
		
		return "pad";
	}
	
//	@RequestMapping(path="editPlaylist.do", method = RequestMethod.GET)
//	public String editPlaylist() {
//
//	}

}
