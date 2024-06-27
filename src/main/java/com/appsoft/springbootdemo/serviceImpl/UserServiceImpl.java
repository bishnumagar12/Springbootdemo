package com.appsoft.springbootdemo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsoft.springbootdemo.model.User;
import com.appsoft.springbootdemo.repository.UserRepository;
import com.appsoft.springbootdemo.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void userSignup(User user) {
		
		userRepo.save(user);
	}

	@Override
	public User userLogin(String un, String psw) {
		
		return userRepo.findByUsernameAndPassword(un, psw);
	}

}
