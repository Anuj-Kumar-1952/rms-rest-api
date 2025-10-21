package io.github.anujkumar.recruitment_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.anujkumar.recruitment_management_system.entity.User;
import io.github.anujkumar.recruitment_management_system.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User userEntity) {
        // Set back-reference for Profile
        if (userEntity.getProfile() != null) {
            userEntity.getProfile().setApplicant(userEntity);
        }
        userEntity.setPasswordHash(passwordEncoder.encode(userEntity.getPasswordHash()));

        return userRepo.save(userEntity);
    }
}
