package com.example.user.rest;

import com.example.user.model.Role;
import com.example.user.model.User;
import com.example.user.repo.RoleRepo;
import com.example.user.repo.UserRepo;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    /*@GetMapping(value = "role", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Role> getRoles() {
        Role role = Role.builder().roleName("ROLE_ADMIN").build();
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        return roles;
    }
*/


    @PostMapping(value = "addUser", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@Validated @RequestBody final User user) {

        List<Role> role2 = new ArrayList<>();
        for (Role roleStr : user.getRoles()) {
           role2.add( roleRepo.findRoleByRoleName(roleStr.getRoleName()));
        }
        user.setRoles(null);
        user.setRoles(role2);
        userService.save(user);
        return user;
    }
}