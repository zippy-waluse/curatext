//package com.example.first.utility;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "pdf_resources")
//public class PdfResource {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String pdfUrl;       // Optional: still keep for remote links
//    private String fileName;     // New: for locally uploaded file name
//    private String filePath;     // New: for path to the saved file
//
//    @ManyToOne
//    @JoinColumn(name = "topic_id", nullable = false)
//    private Topic topic;
//
//    public PdfResource() {}
//
//    public PdfResource(String pdfUrl, Topic topic) {
//        this.pdfUrl = pdfUrl;
//        this.topic = topic;
//    }
//
//    // Optional: another constructor for file path uploads
//    public PdfResource(String fileName, String filePath, Topic topic) {
//        this.fileName = fileName;
//        this.filePath = filePath;
//        this.topic = topic;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getPdfUrl() {
//        return pdfUrl;
//    }
//
//    public void setPdfUrl(String pdfUrl) {
//        this.pdfUrl = pdfUrl;
//    }
//
//    public String getFileName() {
//        return fileName;
//    }
//
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
//
//    public String getFilePath() {
//        return filePath;
//    }
//
//    public void setFilePath(String filePath) {
//        this.filePath = filePath;
//    }
//
//    public Topic getTopic() {
//        return topic;
//    }
//
//    public void setTopic(Topic topic) {
//        this.topic = topic;
//    }
//}
//


package com.example.first.utility;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pdf_resources")
public class PdfResource {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private String pdfUrl;
    @Getter
    @Setter
    private String fileName;
    @Getter
    @Setter
    private String filePath;

//    @Setter
//    @Getter
//    @ManyToOne
//    @JoinColumn(name = "topic_id")
//    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Courses courses;

    public PdfResource() {}

    public PdfResource(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public PdfResource(String fileName, String filePath, Courses courses) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.courses = courses;
    }


    public Courses getCourses() { return courses; }
    public void setCourses(Courses courses) { this.courses = courses; }
}

