package com.auth_service.Auth_Service.repository;

import com.auth_service.Auth_Service.entity.Role;
import com.auth_service.Auth_Service.entity.RoleName;
import com.auth_service.Auth_Service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName name);
}
