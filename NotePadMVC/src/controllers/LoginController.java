package controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.LoginDAO;
import entities.AdminLevel;
import entities.User;

@Controller
@SessionAttributes("user")
public class LoginController {

	@ModelAttribute("user")
	public User user(){
		return new User();
	}
	
	@Autowired
	LoginDAO loginDAO;
	
	@RequestMapping(path = "welcome.do", method = RequestMethod.GET)
	public String welcome(Model model, @ModelAttribute("user") User user) {
		
		if(user.getId() == 0 ) {
			return "login";
		} else {
			model.addAttribute("user", user);
			model.addAttribute("isAdmin", user.getAdminLevel() == AdminLevel.ADMIN);
			return "pad";
		}
		
	}
	
	@RequestMapping(path = "login.do", method = RequestMethod.POST)
	public String login(User userAttemptedLogin, Model model) {
		
		User user = loginDAO.getUserByAliasAndPassword(
				userAttemptedLogin.getAlias(), userAttemptedLogin.getPassword());
		
		if (user != null) {
			model.addAttribute("user", user);
			model.addAttribute("isAdmin", user.getAdminLevel() == AdminLevel.ADMIN);
			return "pad";
		} else {
			model.addAttribute("user", userAttemptedLogin);
			model.addAttribute("userNotFound", true);
			return "login";
		}
	}
	
	@RequestMapping(path = "createNewUser.do", method = RequestMethod.POST)
	public String createNewUser(User newUser, Model model) {
	
		User user = loginDAO.createNewUser(newUser);
		
		if (user != null) {
			model.addAttribute("user", user);
			model.addAttribute("isAdmin", user.getAdminLevel() == AdminLevel.ADMIN);
			return "pad";
		} else {
			model.addAttribute("aliasExists", true);
			return "login";
		}
		
	}
	
	  @RequestMapping(path = "logout.do", method = RequestMethod.GET)
	    public String logout(User newUser, Model model) {

	            model.addAttribute("user", new User());
	            return "login";

	    }
	
}
	

