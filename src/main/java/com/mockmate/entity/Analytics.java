package com.mockmate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "analytics")
public class Analytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Integer totalInterviews = 0;
    private Double avgTechScore = 0.0;
    private Double avgCommsScore = 0.0;

    @Column(columnDefinition = "TEXT")
    private String weeklyProgressData;

    public Analytics() {}

    public Analytics(Long id, User user, Integer totalInterviews, Double avgTechScore, Double avgCommsScore, String weeklyProgressData) {
        this.id = id;
        this.user = user;
        this.totalInterviews = totalInterviews;
        this.avgTechScore = avgTechScore;
        this.avgCommsScore = avgCommsScore;
        this.weeklyProgressData = weeklyProgressData;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Integer getTotalInterviews() { return totalInterviews; }
    public void setTotalInterviews(Integer totalInterviews) { this.totalInterviews = totalInterviews; }

    public Double getAvgTechScore() { return avgTechScore; }
    public void setAvgTechScore(Double avgTechScore) { this.avgTechScore = avgTechScore; }

    public Double getAvgCommsScore() { return avgCommsScore; }
    public void setAvgCommsScore(Double avgCommsScore) { this.avgCommsScore = avgCommsScore; }

    public String getWeeklyProgressData() { return weeklyProgressData; }
    public void setWeeklyProgressData(String weeklyProgressData) { this.weeklyProgressData = weeklyProgressData; }

    // Builder Pattern
    public static AnalyticsBuilder builder() {
        return new AnalyticsBuilder();
    }

    public static class AnalyticsBuilder {
        private Long id;
        private User user;
        private Integer totalInterviews = 0;
        private Double avgTechScore = 0.0;
        private Double avgCommsScore = 0.0;
        private String weeklyProgressData;

        public AnalyticsBuilder id(Long id) { this.id = id; return this; }
        public AnalyticsBuilder user(User user) { this.user = user; return this; }
        public AnalyticsBuilder totalInterviews(Integer totalInterviews) { this.totalInterviews = totalInterviews; return this; }
        public AnalyticsBuilder avgTechScore(Double avgTechScore) { this.avgTechScore = avgTechScore; return this; }
        public AnalyticsBuilder avgCommsScore(Double avgCommsScore) { this.avgCommsScore = avgCommsScore; return this; }
        public AnalyticsBuilder weeklyProgressData(String weeklyProgressData) { this.weeklyProgressData = weeklyProgressData; return this; }

        public Analytics build() {
            return new Analytics(id, user, totalInterviews, avgTechScore, avgCommsScore, weeklyProgressData);
        }
    }
}
