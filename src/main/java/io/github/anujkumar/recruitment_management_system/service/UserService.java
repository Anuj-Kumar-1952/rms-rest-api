package io.github.anujkumar.recruitment_management_system.service;

import org.springframework.stereotype.Service;

import io.github.anujkumar.recruitment_management_system.entity.User;

@Service
public interface UserService {
    // create profile on system
    User createUser(User user);
}
