//package com.example.first.service.impl;
//
//import com.example.first.service.UserService;
//import com.example.first.utility.User;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceImpl implements UserService {
//    @Override
//    public User createUser(User user) {
//        return null;
//    }
//
//    @Override
//    public User loginUser(String emailAddress, String password) {
//        return null;
//    }
//}



//package com.example.first.service.impl;
//
//import com.example.first.repository.UserRepository;
//import com.example.first.service.UserService;
//import com.example.first.utility.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public User createUser(User user) {
//        // Hash the password before saving (if using BCrypt)
//        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
//        return userRepository.save(user);
//    }
//
//    @Override
//    public User loginUser(String emailAddress, String password) {
//        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmailAddress(emailAddress));
//
//        if (optionalUser.isEmpty()) {
//            System.out.println("User not found!");
//            return null;
//        }
//
//        User user = optionalUser.get();
//
//        // Verify password
//        if (!BCrypt.checkpw(password, user.getPassword())) {
//            System.out.println("Incorrect password entered!");
//            return null;
//        }
//
//        return user;
//    }
//}



package com.example.first.service.impl;

import com.example.first.repository.UserRepository;
import com.example.first.service.UserService;
import com.example.first.utility.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        // Ensure password is hashed before saving
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String emailAddress, String password) {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmailAddress(emailAddress));

        if (optionalUser.isEmpty()) {
            System.out.println("User not found!");
            return null;
        }

        User user = optionalUser.get();

        // Verify hashed password
        if (!BCrypt.checkpw(password, user.getPassword())) {
            System.out.println("Incorrect password entered!");
            return null;
        }

        return user;
    }
}

