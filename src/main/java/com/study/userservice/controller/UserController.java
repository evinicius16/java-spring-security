package com.study.userservice.controller;

import com.study.userservice.models.Role;
import com.study.userservice.models.User;
import com.study.userservice.service.UserService;
import com.study.userservice.vo.RoleToUserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api")
public class UserController {

    @Autowired
    private final UserService userService;


    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        URI uri =  URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/v1/api/user").toUriString());
        return ResponseEntity.created(uri).body( userService.saveUser(user));
    }

    @PostMapping("/role")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri =  URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/v1/api/role").toUriString());
        return ResponseEntity.created(uri).body( userService.saveRole(role));
    }

    @PostMapping("/role/add")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserVo roleToUserVo){
        userService.addRoleToUser(roleToUserVo.getUsername(), roleToUserVo.getRoleName());
        return ResponseEntity.ok().build();
    }
}
