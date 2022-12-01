package com.study.userservice.service;

import com.study.userservice.models.Role;
import com.study.userservice.models.User;
import com.study.userservice.repository.RoleRepository;
import com.study.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private RoleRepository roleRepository;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
