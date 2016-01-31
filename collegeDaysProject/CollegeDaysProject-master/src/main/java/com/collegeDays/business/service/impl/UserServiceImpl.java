package com.collegeDays.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.collegeDays.business.domain.request.LoginRequest;
import com.collegeDays.business.domain.response.UserResponse;
import com.collegeDays.business.service.UserService;
import com.collegeDays.entity.User;
import com.collegeDays.repository.UserRepository;

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

	@Override
	@Cacheable(value="users")
	public List<User> getUsers(int userId){
		List<User> list = new ArrayList<User>();
		User user = userRepository.findOne(userId);
		list.add(user);
		return list;
		
	}
}
