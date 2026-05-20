package com.liz.quiz.a3_quiz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "quiz_media")
public class QuizMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "media_type", nullable = false)
    private String mediaType; // "IMAGE", "AUDIO" ou "VIDEO"

    @Column(name = "file_url", nullable = false, length = 512)
    private String fileUrl; // O link do seu Drive

    @Column(name = "is_ai_generated", nullable = false)
    private boolean isAiGenerated; // true ou false

    @Column(columnDefinition = "TEXT")
    private String explanation;

    public QuizMedia() {}

    public QuizMedia(String mediaType, String fileUrl, boolean isAiGenerated, String explanation) {
        this.mediaType = mediaType;
        this.fileUrl = fileUrl;
        this.isAiGenerated = isAiGenerated;
        this.explanation = explanation;
    }

    // Getters e Setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getMediaType() { return mediaType; }
    public void setMediaType(String mediaType) { this.mediaType = mediaType; }
    public String getFileUrl() { return fileUrl; }
    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }
    public boolean isAiGenerated() { return isAiGenerated; }
    public void setAiGenerated(boolean aiGenerated) { this.isAiGenerated = aiGenerated; }
    public String getExplanation() { return explanation; }
    public void setExplanation(String explanation) { this.explanation = explanation; }
}