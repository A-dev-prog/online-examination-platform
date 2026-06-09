package com.auth_service.Auth_Service.config;

import com.auth_service.Auth_Service.entity.Role;
import com.auth_service.Auth_Service.entity.RoleName;
import com.auth_service.Auth_Service.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {

        List<RoleName> roleNameList = Arrays.asList(RoleName.values());

        roleNameList.stream()
                .forEach(role -> {roleRepository.findByName(role)
                        .orElseGet(()->roleRepository.save(Role.builder()
                                .name(role)
                                .build()
                        )
                        );
                }
                );

    }
}
