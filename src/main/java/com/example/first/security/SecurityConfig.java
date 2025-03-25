package com.example.first.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeHttpRequests(auth -> auth
//                                .requestMatchers("/users/register","/api/v1/*").permitAll()
////                                .requestMatchers("/api/v1/events/**").hasRole("ADMIN")
////                        .anyRequest().authenticated()
//                                .anyRequest().permitAll()
//                )

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

////                .httpBasic();
//                .formLogin().disable() // Disable default login form if not needed
//                .httpBasic().disable();
//        return http.build();
//    }
//    }
//


@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/users/register","/api/v1/*").permitAll()
//                                .requestMatchers("/api/v1/events/**").hasRole("ADMIN")
//                        .anyRequest().authenticated()
                                .anyRequest().permitAll()
                )
//                .httpBasic();
                .formLogin().disable() // Disable default login form if not needed
                .httpBasic().disable();
        return http.build();
    }
}
