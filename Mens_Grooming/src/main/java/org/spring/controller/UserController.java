package org.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/register")
	public String showRegistrationForm() {
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@RequestParam String Id, @RequestParam String password, @RequestParam String password2, @RequestParam String address, @RequestParam String phone_number, @RequestParam String email) {
		
		return "redirect:/login";
	}
	
}
