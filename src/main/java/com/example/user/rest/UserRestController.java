package com.example.user.rest;

import com.example.user.model.Role;
import com.example.user.model.User;
import com.example.user.repo.RoleRepo;
import com.example.user.repo.UserRepo;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserRestController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepo roleRepo;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUsers() {
        Role role = roleRepo.findRoleByRoleName("ROLE_USER");
        User user = User.builder().username("uson").password("1234").
                roles(roleRepo.findAll()).build();

        user.setId(1L);
        return user ;
    }

   /* @PostMapping(value = "/createUser", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public User save(@RequestBody  User user) {
      //  Role role = new Role();
        //role.setRoleName("ROLE_ADMIN");
        ///List<Role> roles = new ArrayList<>();
        //roles.add(role);
        //user.setRoles(roles);
        userRepo.save(user);
        return user;
    }*/

}
