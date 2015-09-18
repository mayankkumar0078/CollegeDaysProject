package com.collegeDays.business.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.collegeDays.business.domain.request.LoginRequest;
import com.collegeDays.business.domain.response.UserResponse;
import com.collegeDays.business.service.UserService;
import com.collegeDays.dao.UserRepository;
import com.collegeDays.entity.User;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserRepository userRepository;
	
	@Override
	public UserResponse verifyUser(LoginRequest userRequest) {
		User userEntity = userRepository.findByEmail(userRequest.getEmail());
		UserResponse userResponse = new UserResponse();
		
		if(userEntity != null){
			String userPassword = userEntity.getPassword();
			if(userPassword.equals(userRequest.getPassword())){
				userResponse.setEmail(userEntity.getEmail());
				userResponse.setUserName(userEntity.getName());
				userResponse.setAuthenticated(true);
				return userResponse;
			}
		}
			userResponse.setAuthenticated(false);
			return userResponse;
	}

}
