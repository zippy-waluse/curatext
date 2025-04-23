package com.example.first.service;

import com.example.first.repository.UserRepository;
import com.example.first.utility.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
        // Hash password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String emailAddress, String rawPassword) {
        Optional<User> optionalUser = userRepository.findByEmailAddress(emailAddress);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(rawPassword, user.getPassword())) {
                return user;
            }
        }
        return null; // Either user not found or password doesn't match
    }
}
