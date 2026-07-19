package com.auth_service.Auth_Service.dto;

public record CurrentUserResponse(
        Long id,
        String username,
        String email,
        String role
) {
}
