package com.example.first.controller;//package com.example.first.controller;
//
//import com.example.first.dto.PdfResourceRequest;
//import com.example.first.repository.PdfResourceRepository;
//import com.example.first.repository.TopicRepository;
//import com.example.first.utility.PdfResource;
//import com.example.first.utility.Topic;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/pdf-resources")
//public class PdfResourceController {
//
//    @Autowired
//    private PdfResourceRepository pdfResourceRepository;
//
//    @Autowired
//    private TopicRepository topicRepository;
//
//    @PostMapping
//    public ResponseEntity<PdfResource> addPdfResource(@RequestBody PdfResourceRequest request) {
//        Topic topic = topicRepository.findById(request.getTopicId())
//                .orElseThrow(() -> new RuntimeException("Topic not found"));
//
//        PdfResource pdfResource = new PdfResource(request.getPdfUrl(), topic);
//        PdfResource savedPdf = pdfResourceRepository.save(pdfResource);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedPdf);
//    }
//
//    @GetMapping("/topic/{topicId}")
//    public ResponseEntity<List<PdfResource>> getPdfsByTopic(@PathVariable Long topicId) {
//        List<PdfResource> pdfResources = pdfResourceRepository.findByTopicId(topicId);
//        return ResponseEntity.ok(pdfResources);
//    }
//}


//import com.example.first.repository.PdfResourceRepository;
//
//import com.example.first.repository.TopicRepository;
//import com.example.first.utility.PdfResource;
//import com.example.first.utility.Topic;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import com.example.first.repository.TopicRepository;
//import com.example.first.utility.Topic;
//import com.example.first.repository.PdfResourceRepository;
//
//@RestController
//@RequestMapping("/pdf")
//public class PdfResourceController {
//
//    private final TopicRepository topicRepository;
//    private final PdfResourceRepository pdfResourceRepository;
//
//    @Autowired
//    public PdfResourceController(
//            TopicRepository topicRepository,
//            PdfResourceRepository pdfResourceRepository
//    ) {
//        this.topicRepository = topicRepository;
//        this.pdfResourceRepository = pdfResourceRepository;
//    }
//
//    @PostMapping("/upload")
//    public ResponseEntity<PdfResource> uploadPdfResource(
//            @RequestParam("file") MultipartFile file,
//            @RequestParam("topicId") Long topicId
//    ) {
//        // Find the topic
//        Topic topic = topicRepository.findById(topicId)
//                .orElseThrow(() -> new RuntimeException("Topic not found with ID: " + topicId));
//
//        // Save file locally
//        try {
//            String uploadDir = "pdf-uploads/";
//            Path uploadPath = Paths.get(uploadDir);
//            if (!Files.exists(uploadPath)) {
//                Files.createDirectories(uploadPath);
//            }
//
//            String fileName = file.getOriginalFilename();
//            Path filePath = uploadPath.resolve(fileName);
//            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//            // Create and save PdfResource
//            PdfResource pdfResource = new PdfResource();
//            pdfResource.setFileName(fileName);
//            pdfResource.setFilePath(filePath.toString());
//            pdfResource.setTopic(topic);
//
//            PdfResource savedResource = pdfResourceRepository.save(pdfResource);
//
//            return ResponseEntity.ok(savedResource);
//        } catch (IOException e) {
//            throw new RuntimeException("Could not store file: " + e.getMessage());
//        }
//    }
//}

import com.example.first.repository.TopicRepository;
import com.example.first.utility.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/pdf")
public class PdfResourceController {

    @Autowired
    private TopicRepository topicRepository;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadPdf(
            @RequestParam("file") MultipartFile file,
            @RequestParam("topicId") Long topicId) {

        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found with ID: " + topicId));

        try {
            // 1. Define upload directory
            String uploadDir = "pdf-uploads/";
            Path uploadPath = Paths.get(uploadDir);

            // 2. Create directory if it doesn't exist
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // 3. Create file name (could be more sophisticated)
            String fileName = topicId + "_" + file.getOriginalFilename();

            // 4. Save the file
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // 5. Save metadata to database or perform additional operations
            // (You might want to create a PdfResource entity and save it)

            return new ResponseEntity<>("File uploaded successfully: " + fileName, HttpStatus.OK);

        } catch (IOException e) {
            return new ResponseEntity<>("Failed to upload file: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
