//
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
//    public Resource() {
//    }
//
//    public Resource(String resourceId, String title, String contentUrl, String type, Topic topic) {
//        this.resourceId = resourceId;
//        this.title = title;
//        this.contentUrl = contentUrl;
//        this.type = type;
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
//    public String getResourceId() {
//        return resourceId;
//    }
//
//    public void setResourceId(String resourceId) {
//        this.resourceId = resourceId;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContentUrl() {
//        return contentUrl;
//    }
//
//    public void setContentUrl(String contentUrl) {
//        this.contentUrl = contentUrl;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
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

package com.example.first.utility;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Topic topic;

    public Resource() {
    }

    public Resource(String resourceId, String title, String contentUrl, String type, Topic topic) {
        this.resourceId = resourceId;
        this.title = title;
        this.contentUrl = contentUrl;
        this.type = type;
        this.topic = topic;
    }

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
