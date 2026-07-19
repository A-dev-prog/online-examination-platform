package com.auth_service.Auth_Service.service.impl;

import com.auth_service.Auth_Service.dto.*;
import com.auth_service.Auth_Service.entity.Role;
import com.auth_service.Auth_Service.entity.User;
import com.auth_service.Auth_Service.exception.BusinessException;
import com.auth_service.Auth_Service.exception.ResourceNotFoundException;
import com.auth_service.Auth_Service.repository.RoleRepository;
import com.auth_service.Auth_Service.repository.UserRepository;
import com.auth_service.Auth_Service.security.jwt.JwtService;
import com.auth_service.Auth_Service.service.AuthService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    @Override
    public UserResponse register(RegisterRequest request) {

       if(userRepository.existsByEmail(request.email()))
       {
           throw new BusinessException("Email already exists");
       }

        Role role = roleRepository.findByName(request.role())
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));

       User user = User.builder()
               .username(request.username())
               .email(request.email())
               .password(passwordEncoder.encode(request.password()))
               .enabled(true)
               .roles(Set.of(role))
               .build();

        User saved = userRepository.save(user);

        return new UserResponse(
                saved.getId(),
                saved.getUsername(),
                saved.getEmail()
        );
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.email(),
                                request.password()
                        )
                );

        UserDetails userDetails =
                (UserDetails) authentication.getPrincipal();

        String token =
                jwtService.generateToken(userDetails);

        return new LoginResponse(
                token,
                "Bearer"
        );
    }

    @Override
    public CurrentUserResponse getCurrentUser(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        String role = user.getRoles()
                .stream()
                .findFirst()
                .map(Role::getName)
                .map(Enum::name)
                .orElse("");

        return new CurrentUserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                role
        );
    }
}
