package com.luv2code.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.luv2code.service.IUserService;


@Controller
public class LoginController {

	
	@Autowired
	IUserService userService; 
	
	@RequestMapping("/About")
	public String About() {
		return "about";
	}
	
	
	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		modelAndView.addObject("userLogIn", auth.getName());
		modelAndView.setViewName("welcome");
		return modelAndView;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView methodForAdmin() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		modelAndView.addObject("userName", "Welcome " + auth.getName());
		modelAndView.addObject("adminMessage", "Content Available Only for Admins with ADMIN Role");
		modelAndView.setViewName("/admin/admin");
		return modelAndView;
	}
	
	@RequestMapping(value = "/Avocat", method = RequestMethod.GET)
	public ModelAndView methodForAvocat() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		modelAndView.addObject("userName", "Welcome " + auth.getName());
		modelAndView.addObject("AvocatMessage", "Content Available Only for Avocats with Avocat Role");
		modelAndView.setViewName("Avocat/Avocat");
		return modelAndView;
	}
	@RequestMapping(value = "/Secretaire", method = RequestMethod.GET)
	public ModelAndView methodForClient() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		modelAndView.addObject("userName", "Welcome " + auth.getName());
		modelAndView.addObject("SecretaireMessage", "Content Available Only for Secretaires with Secretaire Role");
		modelAndView.setViewName("Secretaire/Secretaire");
		return modelAndView;
	}

	
	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public ModelAndView accessdenied() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("access-denied");
		return modelAndView;
	}
	
	@RequestMapping("/Adminhome")
    public String indexAdmin(Model m) {
        return "welcomePageAdmin";
    }
	
	@RequestMapping("/index")
	public String index(Model m) {
		return "index";
	}
	@RequestMapping("/Secretairehome")
    public String indexSecretaire(Model m) {
        return "welcomePageSecretaire";
    }
	
	@RequestMapping("/Avocathome")
    public String indexAvocat(Model m) {
        return "welcomePageAvocat";
    }
}