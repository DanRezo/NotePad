package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import entities.User;

@Controller
@SessionAttributes({"user"})
public class NoteController{
	

	@RequestMapping(value="test2.do")
	public void test(@ModelAttribute("user") User user){
		System.out.println(user);
	}
}
