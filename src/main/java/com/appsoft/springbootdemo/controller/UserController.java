package com.appsoft.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.appsoft.springbootdemo.model.User;
import com.appsoft.springbootdemo.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping({"/","/login"})
	public String getlogin() {
		
		return "LoginForm";
		
	}
	@PostMapping("/login")
	public String postlogin(@ModelAttribute User user, Model model) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User u = userService.userLogin(user.getUsername(), user.getPassword());
		
		 if(u != null) {
			 
			 model.addAttribute("fname",u.getFname());
			 return "Home";
		 }
		
		 model.addAttribute("message","user not found!!");
		 return "LoginForm";
		
	}
	@GetMapping("/signup")
	public String getsingup() {
		
		return "SignupForm";
		
	}
	@PostMapping("/signup")
	public String postsignup(@ModelAttribute User user, Model model) {
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		
		userService.userSignup(user);
		
		return "LoginForm";
		
	}
	
	
}
