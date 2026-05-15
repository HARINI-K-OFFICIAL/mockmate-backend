package com.mockmate.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_id", nullable = false)
    private Interview interview;

    @Column(nullable = false)
    private Integer techScore;

    @Column(nullable = false)
    private Integer commsScore;

    @Column(nullable = false)
    private Integer overallScore;

    @Column(columnDefinition = "TEXT")
    private String aiSummary;

    @Column(columnDefinition = "TEXT")
    private String recommendedTopics;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime generatedAt;

    public Feedback() {}

    public Feedback(Long id, Interview interview, Integer techScore, Integer commsScore, Integer overallScore, String aiSummary, String recommendedTopics, LocalDateTime generatedAt) {
        this.id = id;
        this.interview = interview;
        this.techScore = techScore;
        this.commsScore = commsScore;
        this.overallScore = overallScore;
        this.aiSummary = aiSummary;
        this.recommendedTopics = recommendedTopics;
        this.generatedAt = generatedAt;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Interview getInterview() { return interview; }
    public void setInterview(Interview interview) { this.interview = interview; }

    public Integer getTechScore() { return techScore; }
    public void setTechScore(Integer techScore) { this.techScore = techScore; }

    public Integer getCommsScore() { return commsScore; }
    public void setCommsScore(Integer commsScore) { this.commsScore = commsScore; }

    public Integer getOverallScore() { return overallScore; }
    public void setOverallScore(Integer overallScore) { this.overallScore = overallScore; }

    public String getAiSummary() { return aiSummary; }
    public void setAiSummary(String aiSummary) { this.aiSummary = aiSummary; }

    public String getRecommendedTopics() { return recommendedTopics; }
    public void setRecommendedTopics(String recommendedTopics) { this.recommendedTopics = recommendedTopics; }

    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }

    // Builder Pattern
    public static FeedbackBuilder builder() {
        return new FeedbackBuilder();
    }

    public static class FeedbackBuilder {
        private Long id;
        private Interview interview;
        private Integer techScore;
        private Integer commsScore;
        private Integer overallScore;
        private String aiSummary;
        private String recommendedTopics;

        public FeedbackBuilder id(Long id) { this.id = id; return this; }
        public FeedbackBuilder interview(Interview interview) { this.interview = interview; return this; }
        public FeedbackBuilder techScore(Integer techScore) { this.techScore = techScore; return this; }
        public FeedbackBuilder commsScore(Integer commsScore) { this.commsScore = commsScore; return this; }
        public FeedbackBuilder overallScore(Integer overallScore) { this.overallScore = overallScore; return this; }
        public FeedbackBuilder aiSummary(String aiSummary) { this.aiSummary = aiSummary; return this; }
        public FeedbackBuilder recommendedTopics(String recommendedTopics) { this.recommendedTopics = recommendedTopics; return this; }

        public Feedback build() {
            return new Feedback(id, interview, techScore, commsScore, overallScore, aiSummary, recommendedTopics, null);
        }
    }
}
