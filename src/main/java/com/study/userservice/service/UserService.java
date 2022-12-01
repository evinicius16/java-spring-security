package com.study.userservice.service;

import com.study.userservice.models.Role;
import com.study.userservice.models.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();

}
