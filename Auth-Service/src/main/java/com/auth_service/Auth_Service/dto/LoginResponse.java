package com.auth_service.Auth_Service.dto;

public record LoginResponse(String accessToken,
                            String tokenType) {
}
