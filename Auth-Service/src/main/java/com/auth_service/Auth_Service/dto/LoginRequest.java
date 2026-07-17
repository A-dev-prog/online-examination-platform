package com.auth_service.Auth_Service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
@Schema(description = "Login Request")
public record LoginRequest(
        @Schema(
                description = "Email Address",
                example = "john@gmail.com"
        )
        @Email
        @NotBlank
        String email,
        @Schema(
                description = "Password",
                example = "Password@123"
        )
        @NotBlank
        String password
) {
}
