package com.example.user.repo;

import com.example.user.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepo extends JpaRepository<Role, Long> {
    List<Role> findAll();
    Role findRoleByRoleName(String name);

}
