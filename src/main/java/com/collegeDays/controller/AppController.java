package com.collegeDays.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.collegeDays.dao.UserRepository;
import com.collegeDays.entity.User;

@Controller
public class AppController {
	
	@Resource
    private UserRepository userRepository;
	@RequestMapping("/login")
    String home() {
    	System.out.println("userRepository  :"+userRepository);
    	/*User user=new User();
    	user.setEmail("mayankkumar@gmail.com");
    	user.setPassword("mayank");
    	userRepository.save(user);*/
    	        return "login";
    }



}
