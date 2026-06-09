package com.auth_service.Auth_Service.service;

import com.auth_service.Auth_Service.dto.LoginRequest;
import com.auth_service.Auth_Service.dto.LoginResponse;
import com.auth_service.Auth_Service.dto.RegisterRequest;
import com.auth_service.Auth_Service.dto.UserResponse;

public interface AuthService {

   UserResponse register(RegisterRequest request);

   LoginResponse login(LoginRequest request);
}
