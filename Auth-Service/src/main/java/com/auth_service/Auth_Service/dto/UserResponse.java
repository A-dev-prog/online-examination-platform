package com.auth_service.Auth_Service.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "User Response")
public record UserResponse(
        @Schema(
                description = "Unique ID of the user",
                example = "1"
        )
        Long id,
        @Schema(
                description = "Username of the registered user",
                example = "john_doe"
        )
        String username,
        @Schema(
                description = "Email address of the registered user",
                example = "john.doe@gmail.com"
        )
        String email)
{
}
