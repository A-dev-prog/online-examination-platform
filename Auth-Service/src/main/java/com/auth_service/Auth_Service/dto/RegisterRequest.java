package com.auth_service.Auth_Service.dto;

import com.auth_service.Auth_Service.entity.RoleName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Register Request")
public record RegisterRequest(
        @Schema(
                description = "Username",
                example = "john_doe"
        )
        @NotBlank(message = "Username is required")
        String username,
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
        String password,
        @Schema(
                description = "User Role",
                example = "ROLE_STUDENT"
        )
        @NotNull
        RoleName role
)
{


}
