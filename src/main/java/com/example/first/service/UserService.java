//package com.example.first.service;
//
//import com.example.first.utility.User;
//import org.springframework.stereotype.Service;
//
//@Service
//public interface UserService {
//    User createUser (User user);
//    User loginUser (String emailAddress, String password);
//}



package com.example.first.service;

import com.example.first.utility.User;

public interface UserService {
    User createUser(User user);
    User loginUser(String emailAddress, String password);
}
