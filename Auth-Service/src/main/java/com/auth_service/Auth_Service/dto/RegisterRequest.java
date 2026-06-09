package com.auth_service.Auth_Service.dto;

import com.auth_service.Auth_Service.entity.RoleName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(@NotBlank
                              String username,

                              @Email
                              String email,

                              @NotBlank
                              String password,

                              RoleName role)
{


}
