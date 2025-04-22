

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

    List<Interactions> findAllByUserEmailAddress(String emailAddress);

    Optional<Interactions> findByUserEmailAddressAndCoursesId(String emailAddress, Long courseId);
    Optional<Interactions> findInteractionsByUserEmailAddress(String emailAddress);
}
