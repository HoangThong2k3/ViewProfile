package com.se4f7.prj301.service;

import java.sql.SQLException;

import com.se4f7.prj301.dto.request.LoginRequestDto;
import com.se4f7.prj301.dto.request.RegisterRequestDto;
import com.se4f7.prj301.dto.response.LoginResponseDto;
import com.se4f7.prj301.dto.response.UserResponseDto;

public interface AuthService {
	
	public boolean register(RegisterRequestDto registerRequestDto) throws SQLException;
	
	public LoginResponseDto login(LoginRequestDto loginRequestDto) throws SQLException;
	
	public UserResponseDto getUserInfo(int id);
	
}
