package com.auth_service.Auth_Service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "Login Response")
public record LoginResponse(
        @Schema(
                description = "JWT access token used for authenticating subsequent requests",
                example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huQGdtYWlsLmNvbSIsImlhdCI6MTc1MjgzMjAwMCwiZXhwIjoxNzUyODM1NjAwfQ.signature"
        )
        String accessToken,

        @Schema(
                description = "Authentication token type",
                example = "Bearer"
        )
        String tokenType
) {
}
