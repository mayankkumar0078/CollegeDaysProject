package com.collegeDays.controller;
/**
 * @author Mayank
 * 
 */
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.collegeDays.entity.User;
import com.collegeDays.repository.UserRepository;

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
