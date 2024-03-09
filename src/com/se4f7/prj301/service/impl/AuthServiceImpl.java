package com.se4f7.prj301.service.impl;

import java.sql.SQLException;

import com.se4f7.prj301.dto.request.LoginRequestDto;
import com.se4f7.prj301.dto.request.RegisterRequestDto;
import com.se4f7.prj301.dto.response.LoginResponseDto;
import com.se4f7.prj301.dto.response.UserResponseDto;
import com.se4f7.prj301.repository.UserRepository;
import com.se4f7.prj301.service.AuthService;

public class AuthServiceImpl implements AuthService {

	private UserRepository userRepository = new UserRepository();

	@Override
	public boolean register(RegisterRequestDto registerRequestDto) throws SQLException {
		// TODO: Validate fields in register dto.
		return this.userRepository.registerUser(registerRequestDto);
	}

	@Override
	public LoginResponseDto login(LoginRequestDto loginResponseDto) throws SQLException {
		// TODO: Validate fields in register dto.
		return this.userRepository.validateLogin(loginResponseDto);
	}

	@Override
	public UserResponseDto getUserInfo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
