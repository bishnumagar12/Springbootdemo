package com.appsoft.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appsoft.springbootdemo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsernameAndPassword(String un, String psw);
	
}
