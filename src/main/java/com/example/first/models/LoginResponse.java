package com.example.first.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginResponse {
    String emailAddress;
    String status_code;
    String message;
    String role_id;
    String token;
    String firstName;
    String secondName;
    String lastName;
    String phoneNumber;
}
