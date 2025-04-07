package com.example.first.dto;

public class PdfResourceRequest {
    private String pdfUrl;
    private Long topicId;

    public PdfResourceRequest() {}

    public PdfResourceRequest(String pdfUrl, Long topicId) {
        this.pdfUrl = pdfUrl;
        this.topicId = topicId;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }
}
