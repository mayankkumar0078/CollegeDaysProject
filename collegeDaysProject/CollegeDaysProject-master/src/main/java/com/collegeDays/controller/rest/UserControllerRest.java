package com.collegeDays.controller.rest;
/**
 * @author Mayank
 * 
 */
import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.collegeDays.business.domain.request.LoginRequest;
import com.collegeDays.business.domain.response.UserResponse;
import com.collegeDays.business.service.UserService;
import com.collegeDays.dao.UserRepository;
import com.collegeDays.dto.UserDTO;
import com.collegeDays.entity.User;

@RestController
@EnableAutoConfiguration
@ComponentScan
@Transactional
public class UserControllerRest {

	@Resource
	private UserRepository userRepository;
	
	@Resource
	UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody User create(@RequestBody UserDTO userDTO) {
		System.out.println("Creating a new role with information: " + userDTO);
		User user = new User();
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getUserName());
		user.setId(2);
		return userRepository.save(user);
	}

	@ResponseBody
	@RequestMapping(value = "/verifyLogin", method = RequestMethod.POST, produces = {"application/json", "application/xml"})
	public  UserResponse verifyUser(@RequestBody LoginRequest loginRequest){
		UserResponse userResponse = userService.verifyUser(loginRequest);
		return userResponse;
	}
}
