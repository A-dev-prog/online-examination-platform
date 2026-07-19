package com.auth_service.Auth_Service.service;

import com.auth_service.Auth_Service.dto.*;

public interface AuthService {

   UserResponse register(RegisterRequest request);

   LoginResponse login(LoginRequest request);

   CurrentUserResponse getCurrentUser(String email);
}
