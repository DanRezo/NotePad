package controllers;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import data.LoginDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import entities.User;

@Controller
@SessionAttributes({"user"})
public class PadController{
	
		@Autowired
		LoginDAO loginDAO;

	@RequestMapping(value="test.do")
	public ModelAndView test(@ModelAttribute("user") User user){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("note");
		System.out.println(user);
		return mv;
	}
}
