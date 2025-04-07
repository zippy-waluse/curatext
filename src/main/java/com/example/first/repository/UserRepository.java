package com.example.first.repository;
import com.example.first.utility.User;
import org.springframework.data.jpa.repository.JpaRepository;
////@Repository
////public interface UserRepository extends JpaRepository<User,Long>{
////}



public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailAddress(String emailAddress);




}
