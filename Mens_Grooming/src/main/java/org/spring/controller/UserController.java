package org.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import biz.MemberBiz;
import dto.MemberDto;


/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
	
	private final MemberBiz biz;

	@Autowired
	public UserController(MemberBiz biz) {

		this.biz = biz;
	}


	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/register.do")
	public String showRegistrationForm() {
		return "Registration";
	}
	
	@PostMapping("/register.do")
	public String registerUser(@RequestParam("Id") String member_Id, @RequestParam("password") String pass_word, @RequestParam("password2") String pass_word2, @RequestParam("address") String address, @RequestParam("phone_number") String phone_number, @RequestParam("email") String e_mail) {

		MemberDto dto;
		int res=0;
		
		dto = new MemberDto(member_Id, pass_word, pass_word2, address, phone_number, e_mail);
		
		res=biz.join(dto);
		
		if(res>0) {
			return "redirect:/login";
		}else {
		return "forward:/Registration";
		}

	}
	
}
