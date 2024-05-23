package org.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import auth.Auth;
import auth.AuthType;
import authorization.Authentication;
import biz.MemberBiz;
import dto.LoginDto;
import dto.Member;
import dto.MemberDto;
import dto.RoleType;
import dto.SignUpDto;
import exception.ErrorCode;
import exception.MemoAPIException;
import lombok.RequiredArgsConstructor;


/**
 * Handles requests for the application home page.
 */
@RequestMapping("/api/v1/user")
@Controller
@RequiredArgsConstructor
public class UserController {
	

	private final MemberBiz biz;
	private final PasswordEncoder passwordEncoder=null;

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
	
	@PostMapping(value = {"/register", "/signup"})
	public ResponseEntity<?> register(@RequestBody SignUpDto signUpDto) throws MemoAPIException {
		
		if(biz.findByEmail(signUpDto.getEmail())!=null) {
			throw new MemoAPIException(ErrorCode.DUPLICATED_ENTITY, "이미 존재하는 멤버입니다");
		}
		
		return ResponseEntity.ok(biz.register(signUpDto));
	}
	
	// 구현해야함.
	@PostMapping(value = {"/login", "/signin"})
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
		
									
		return ResponseEntity.ok(biz.login(loginDto));
	}
	
	@GetMapping("/oauth")
	public OAuth2AuthenticationToken oauthToken(OAuth2AuthenticationToken token) {
		return token;
	}
	
}
