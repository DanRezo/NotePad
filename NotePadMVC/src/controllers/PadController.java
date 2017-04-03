package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import data.NoteDAO;
import data.PadDAO;
import entities.User;

@Controller
@SessionAttributes({"user"})
public class PadController{
	
	@Autowired
	PadDAO padDAO;
	
	@Autowired
	NoteDAO noteDAO;

	@RequestMapping(value="retrievePlaylist.do", params = "id", method = RequestMethod.GET)
	public String test(@ModelAttribute("user") User user, @RequestParam("id") int id, Model model){

		model.addAttribute("playlist", noteDAO.showPlaylist(id));
		
		return "playlist";
	}
}
