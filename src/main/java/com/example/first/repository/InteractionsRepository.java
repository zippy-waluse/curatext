

//package com.example.first.repository;
//
//import com.example.first.utility.Interactions;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface InteractionsRepository extends JpaRepository<Interactions, Long> {
//
//    @Query("SELECT i FROM Interactions i WHERE i.user.emailAddress = :email")
//    Optional<Interactions> findInteractionsByUserEmailAddress(@Param("email") String email);
//}\

package com.example.first.repository;

import com.example.first.utility.Interactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InteractionsRepository extends JpaRepository<Interactions, Long> {

    // This method will fetch all interactions by the user's email address
    List<Interactions> findAllByUserEmailAddress(String emailAddress);

    // You can still use the existing method for finding a specific interaction by user email and course ID
    Optional<Interactions> findByUserEmailAddressAndCoursesId(String emailAddress, Long courseId);

    // Other methods
    Optional<Interactions> findInteractionsByUserEmailAddress(String emailAddress);
}
