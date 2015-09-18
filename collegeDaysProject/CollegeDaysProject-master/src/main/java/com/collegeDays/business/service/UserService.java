package com.collegeDays.business.service;

import com.collegeDays.business.domain.request.LoginRequest;
import com.collegeDays.business.domain.response.UserResponse;

public interface UserService {

	public UserResponse verifyUser(LoginRequest userDto);
}
