package com.auth_service.Auth_Service.controller;

import com.auth_service.Auth_Service.dto.LoginRequest;
import com.auth_service.Auth_Service.dto.LoginResponse;
import com.auth_service.Auth_Service.dto.RegisterRequest;
import com.auth_service.Auth_Service.dto.UserResponse;
import com.auth_service.Auth_Service.entity.User;
import com.auth_service.Auth_Service.service.AuthService;
import com.auth_service.Auth_Service.service.impl.AuthServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
@Tag(
        name = "Authentication APIs",
        description = "User registration and authentication"
)
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthServiceImpl authService;

    @Operation(
            summary = "Register User",
            description = "Registers a new user as ADMIN, TEACHER or STUDENT."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User registered successfully"),
            @ApiResponse(responseCode = "400", description = "Validation failed or email already exists")
    })
    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@Valid  @RequestBody RegisterRequest request)
    {
        System.out.println("Register API Hit");
        return  ResponseEntity.ok(authService.register(request));
    }
    @Operation(
            summary = "Login User",
            description = "Authenticates user and returns JWT token."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Login successful"),
            @ApiResponse(responseCode = "400", description = "Invalid credentials")
    })
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request
    ) {

        return ResponseEntity.ok(
                authService.login(request)
        );
    }
    @Operation(
            summary = "Current User",
            description = "Returns the authenticated user's email."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Authenticated user details returned"
    )
    @GetMapping("/me")
    public ResponseEntity<String> me(
            Authentication authentication
    ) {

        return ResponseEntity.ok(
                authentication.getName()
        );
    }
}
