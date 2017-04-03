package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import entities.User;

@Controller
public class PadController{
	

	@RequestMapping(value="test.do")
	public void test(@ModelAttribute("user") User user){
		System.out.println(user);
	}
}
