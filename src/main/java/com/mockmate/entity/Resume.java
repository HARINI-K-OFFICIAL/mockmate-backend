package com.mockmate.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String storageUrl;

    private Integer atsScore;

    @Column(columnDefinition = "TEXT")
    private String extractedSkills;

    @Column(columnDefinition = "TEXT")
    private String strengths;

    @Column(columnDefinition = "TEXT")
    private String weaknesses;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime uploadedAt;

    public Resume() {}

    public Resume(Long id, User user, String fileName, String storageUrl, Integer atsScore, String extractedSkills, String strengths, String weaknesses, LocalDateTime uploadedAt) {
        this.id = id;
        this.user = user;
        this.fileName = fileName;
        this.storageUrl = storageUrl;
        this.atsScore = atsScore;
        this.extractedSkills = extractedSkills;
        this.strengths = strengths;
        this.weaknesses = weaknesses;
        this.uploadedAt = uploadedAt;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getStorageUrl() { return storageUrl; }
    public void setStorageUrl(String storageUrl) { this.storageUrl = storageUrl; }

    public Integer getAtsScore() { return atsScore; }
    public void setAtsScore(Integer atsScore) { this.atsScore = atsScore; }

    public String getExtractedSkills() { return extractedSkills; }
    public void setExtractedSkills(String extractedSkills) { this.extractedSkills = extractedSkills; }

    public String getStrengths() { return strengths; }
    public void setStrengths(String strengths) { this.strengths = strengths; }

    public String getWeaknesses() { return weaknesses; }
    public void setWeaknesses(String weaknesses) { this.weaknesses = weaknesses; }

    public LocalDateTime getUploadedAt() { return uploadedAt; }
    public void setUploadedAt(LocalDateTime uploadedAt) { this.uploadedAt = uploadedAt; }

    // Builder Pattern
    public static ResumeBuilder builder() {
        return new ResumeBuilder();
    }

    public static class ResumeBuilder {
        private Long id;
        private User user;
        private String fileName;
        private String storageUrl;
        private Integer atsScore;
        private String extractedSkills;
        private String strengths;
        private String weaknesses;

        public ResumeBuilder id(Long id) { this.id = id; return this; }
        public ResumeBuilder user(User user) { this.user = user; return this; }
        public ResumeBuilder fileName(String fileName) { this.fileName = fileName; return this; }
        public ResumeBuilder storageUrl(String storageUrl) { this.storageUrl = storageUrl; return this; }
        public ResumeBuilder atsScore(Integer atsScore) { this.atsScore = atsScore; return this; }
        public ResumeBuilder extractedSkills(String extractedSkills) { this.extractedSkills = extractedSkills; return this; }
        public ResumeBuilder strengths(String strengths) { this.strengths = strengths; return this; }
        public ResumeBuilder weaknesses(String weaknesses) { this.weaknesses = weaknesses; return this; }

        public Resume build() {
            return new Resume(id, user, fileName, storageUrl, atsScore, extractedSkills, strengths, weaknesses, null);
        }
    }
}
