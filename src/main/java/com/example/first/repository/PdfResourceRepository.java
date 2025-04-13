//package com.example.first.repository;
//
//import com.example.first.utility.PdfResource;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface PdfResourceRepository extends JpaRepository<PdfResource, Long> {
//    List<PdfResource> findByTopicId(Long topicId);
//}
package com.example.first.repository;

import com.example.first.utility.PdfResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PdfResourceRepository extends JpaRepository<PdfResource, Long> {
    //List<PdfResource> findByTopicId(Long topicId);
    List<PdfResource> findByCourses_Id(Long courseId); // ✅ fixed method
}
