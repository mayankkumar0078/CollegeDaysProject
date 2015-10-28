package com.collegeDays.business.service;

import java.util.List;

import com.collegeDays.business.domain.request.LoginRequest;
import com.collegeDays.business.domain.response.UserResponse;
import com.collegeDays.entity.User;

public interface UserService {

	public UserResponse verifyUser(LoginRequest userDto);
	
	List<User> getUsers(int userId);
}
