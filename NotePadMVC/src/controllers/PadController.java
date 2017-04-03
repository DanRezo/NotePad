package controllers;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import data.LoginDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import entities.User;

@Controller
public class PadController{
	
		@Autowired
		LoginDAO loginDAO;

	@RequestMapping(value="test.do")
	public void test(@ModelAttribute("user") User user){
		System.out.println(user);
	}
}
