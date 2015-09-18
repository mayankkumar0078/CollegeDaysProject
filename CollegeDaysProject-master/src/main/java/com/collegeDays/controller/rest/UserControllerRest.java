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

	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody User create(@RequestBody UserDTO userDTO) {
		System.out.println("Creating a new role with information: " + userDTO);
		User user = new User();
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getUserName());
		return userRepository.save(user);
	}

}
