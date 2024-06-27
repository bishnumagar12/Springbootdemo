package com.appsoft.springbootdemo.service;

import com.appsoft.springbootdemo.model.User;

public interface UserService {
	
	void userSignup(User user);
	
	User userLogin(String un, String psw);
	
}
