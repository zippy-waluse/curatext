//package com.example.first.controller;
//import com.example.first.repository.TopicRepository;
//import com.example.first.utility.Topic;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//
//@RestController
//@RequestMapping("/pdf")
//public class PdfResourceController {
//
//    @Autowired
//    private TopicRepository topicRepository;
//
//    @PostMapping("/upload")
//    public ResponseEntity<?> uploadPdf(
//            @RequestParam("file") MultipartFile file,
//            @RequestParam("topicId") Long topicId) {
//
//        Topic topic = topicRepository.findById(topicId)
//                .orElseThrow(() -> new RuntimeException("Topic not found with ID: " + topicId));
//
//        try {
//            // 1. Define upload directory
//            String uploadDir = "pdf-uploads/";
//            Path uploadPath = Paths.get(uploadDir);
//
//            // 2. Create directory if it doesn't exist
//            if (!Files.exists(uploadPath)) {
//                Files.createDirectories(uploadPath);
//            }
//
//            // 3. Create file name (could be more sophisticated)
//            String fileName = topicId + "_" + file.getOriginalFilename();
//
//            // 4. Save the file
//            Path filePath = uploadPath.resolve(fileName);
//            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//            // 5. Save metadata to database or perform additional operations
//            // (You might want to create a PdfResource entity and save it)
//
//            return new ResponseEntity<>("File uploaded successfully: " + fileName, HttpStatus.OK);
//
//        } catch (IOException e) {
//            return new ResponseEntity<>("Failed to upload file: " + e.getMessage(),
//                    HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}


package com.example.first.controller;

import com.example.first.repository.CourseRepository;
import com.example.first.repository.TopicRepository;
import com.example.first.repository.PdfResourceRepository;
import com.example.first.utility.Courses;
import com.example.first.utility.Topic;
import com.example.first.utility.PdfResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

@RestController
@RequestMapping("/pdf")
public class PdfResourceController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private PdfResourceRepository pdfResourceRepository;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadPdfToTopic(
            @RequestParam("file") MultipartFile file,
            @RequestParam("topicId") Long topicId) {

//        Topic topic = topicRepository.findById(topicId)
//                .orElseThrow(() -> new RuntimeException("Topic not found with ID: " + topicId));

        try {
            String uploadDir = "pdf-uploads/";
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String fileName = topicId + "_" + file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            PdfResource pdf = new PdfResource(fileName, filePath.toString());
            pdfResourceRepository.save(pdf);

            return new ResponseEntity<>("PDF uploaded to topic successfully: " + fileName, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to upload file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/upload-to-courses")
    public ResponseEntity<?> uploadPdfToCourse(
            @RequestParam("file") MultipartFile file,
            @RequestParam("courseId") Long courseId) {

        Courses courses = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Courses not found with ID: " + courseId));

        try {
            String uploadDir = "pdf-uploads/";
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String fileName = courseId + "_" + file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            PdfResource pdf = new PdfResource(fileName, filePath.toString(), courses);
            pdfResourceRepository.save(pdf);

            return new ResponseEntity<>("PDF uploaded to courses successfully: " + fileName, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to upload file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 🔽 New: Fetch PDFs by Courses ID
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<?> getPdfsByCourse(@PathVariable Long courseId) {
        List<PdfResource> pdfs = pdfResourceRepository.findByCourses_Id(courseId);
        return new ResponseEntity<>(pdfs, HttpStatus.OK);
    }
}
