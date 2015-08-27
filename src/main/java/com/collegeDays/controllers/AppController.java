package com.collegeDays.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.collegeDays.dao.util.UserRepository;
import com.collegeDays.entity.User;

@Controller
public class AppController {
	
	@Resource
    private UserRepository userRepository;
	@RequestMapping("/")
    String home() {
    	System.out.println("userRepository  :"+userRepository);
    	User user=new User();
    	user.setEmail("mayankkumar@gmail.com");
    	user.setPassword("mayank");
    	userRepository.save(user);
    	        return "Hello World!";
    }



}
