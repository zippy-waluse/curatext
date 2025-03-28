//package com.example.first.utility;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "resources")
//public class Resource {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String resourceId;
//    private String title;
//    private String contentUrl;
//    private String type;
//
//    @ManyToOne
//    @JoinColumn(name = "topic_id")
//    private Topic topic;
//
//    public Resource(String c1R1, String masteringBusinessCommunication, String url, String pdf, Topic t1) {
//
//    }
//
//    // Constructors, Getters, and Setters
//}
//


package com.example.first.utility;

import jakarta.persistence.*;

@Entity
@Table(name = "resources")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resourceId;
    private String title;
    private String contentUrl;
    private String type;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    // Default constructor
    public Resource() {
    }

    // Parameterized constructor
    public Resource(String resourceId, String title, String contentUrl, String type, Topic topic) {
        this.resourceId = resourceId;
        this.title = title;
        this.contentUrl = contentUrl;
        this.type = type;
        this.topic = topic;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}