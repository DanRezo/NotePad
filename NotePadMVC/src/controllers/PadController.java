package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import data.LoginDAO;

@Controller
public class PadController{
	public class NoteController {
		@Autowired
		LoginDAO loginDAO;
	}

}
