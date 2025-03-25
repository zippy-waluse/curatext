//package com.example.first.utility;
//
//import jakarta.persistence.*;
//import lombok.*;
//import org.hibernate.annotations.CreationTimestamp;
//import org.springframework.data.annotation.Id;
//
//import java.sql.Timestamp;
//@Data
//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "users")
//
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "first_name")
//    private String firstName;
//
//    @Column(name="last_name")
//    private String lastName;
//
//    @Column(name = "email_id", nullable = false,unique = true)
//    private String email;
//
//    private String role;
//    @Column(name = "created_at")
//    private Timestamp createdAt;
//
//    public User(Long id, String firstName, String lastName, String email, Object o) {
//    }
//
//    public User(Long id, String firstName, String lastName, String email) {
//
//    }
////    private String password;
//}



package com.example.first.utility;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;


    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name = "email_Address", nullable = false, unique = true)
    @JsonProperty("email_Address")
    private String emailAddress;

    private String password;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;

    public User(Long id, String firstName, String lastName, String email) {




    }



    // private String password;
}

//package com.tericcabrel.authapi.entities;
//
//import jakarta.persistence.*;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.util.Date;
//
//@Table(name = "users")
//@Entity
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(nullable = false)
//    private Integer id;
//
//    @Column(nullable = false)
//    private String fullName;
//
//    @Column(unique = true, length = 100, nullable = false)
//    private String email;
//
//    @Column(nullable = false)
//    private String password;
//
//    @CreationTimestamp
//    @Column(updatable = false, name = "created_at")
//    private Date createdAt;
//
//    @UpdateTimestamp
//    @Column(name = "updated_at")
//    private Date updatedAt;
//
//    // Getters and setters
//}