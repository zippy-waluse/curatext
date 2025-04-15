//package com.example.first.controller;
//
//import com.example.first.models.LoginRequest;
//import com.example.first.models.LoginResponse;
//import com.example.first.service.UserService;
//import com.example.first.utility.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/api/v1/users")
//public class UserController {
//    @Autowired
//    private UserService userService;
//    @PostMapping("/register")
//    public ResponseEntity<User> createUser(@RequestBody User user){
//        try {
//            System.out.println(user.getEmailAddress());
//            User savedUser = userService.createUser(user);
//            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    @PostMapping("/login")
//    public ResponseEntity<Object> loginUser(@RequestBody LoginRequest loginRequest){
//        User user = userService.loginUser(loginRequest.getEmailAddress(), loginRequest.getPassword());
//        LoginResponse loginResponse = new LoginResponse();
//        if (user !=null){
//            loginResponse.setMessage("User authenticated successfully");
//            loginResponse.setStatus_code("200");
//            loginResponse.setToken("jwt token here");
//            loginResponse.setEmailAddress(user.getEmailAddress());
//            loginResponse.setFirstName(user.getFirstName());
//            loginResponse.setSecondName(user.getLastName());
//            loginResponse.setLastName(user.getLastName());
//            return ResponseEntity.ok(loginResponse);
//        } else {
//            loginResponse.setMessage("Invalid login details");
//            loginResponse.setStatus_code("403");
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginResponse);
//        }
//    }
//}
//


package com.example.first.controller;

import com.example.first.models.LoginRequest;
import com.example.first.models.LoginResponse;
import com.example.first.service.UserService;
import com.example.first.utility.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            System.out.println(user.getEmailAddress());
            User savedUser = userService.createUser(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody LoginRequest loginRequest) {
        User user = userService.loginUser(loginRequest.getEmailAddress(), loginRequest.getPassword());
        LoginResponse loginResponse = new LoginResponse();

        if (user != null) {
            loginResponse.setMessage("User authenticated successfully");
            loginResponse.setStatus_code("200");
            loginResponse.setToken("jwt token here");
            loginResponse.setEmailAddress(user.getEmailAddress());

            return ResponseEntity.ok(loginResponse);
        } else {
            loginResponse.setMessage("Invalid login details");
            loginResponse.setStatus_code("401"); // Correct HTTP status for unauthorized
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginResponse);
        }
    }
}
