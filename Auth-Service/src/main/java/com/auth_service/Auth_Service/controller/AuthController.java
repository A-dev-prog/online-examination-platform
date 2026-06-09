package com.auth_service.Auth_Service.controller;

import com.auth_service.Auth_Service.dto.LoginRequest;
import com.auth_service.Auth_Service.dto.LoginResponse;
import com.auth_service.Auth_Service.dto.RegisterRequest;
import com.auth_service.Auth_Service.dto.UserResponse;
import com.auth_service.Auth_Service.entity.User;
import com.auth_service.Auth_Service.service.AuthService;
import com.auth_service.Auth_Service.service.impl.AuthServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthServiceImpl authService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@Valid  @RequestBody RegisterRequest request)
    {

        return  ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request
    ) {

        return ResponseEntity.ok(
                authService.login(request)
        );
    }

    @GetMapping("/me")
    public ResponseEntity<String> me(
            Authentication authentication
    ) {

        return ResponseEntity.ok(
                authentication.getName()
        );
    }
}
