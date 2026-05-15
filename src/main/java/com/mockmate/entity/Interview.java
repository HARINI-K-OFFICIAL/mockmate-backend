package com.mockmate.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "interviews")
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_role_id", nullable = false)
    private JobRole jobRole;

    @Column(nullable = false)
    private String difficulty; // EASY, MEDIUM, HARD

    @Column(nullable = false)
    private String status; // IN_PROGRESS, COMPLETED

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime startedAt;

    private LocalDateTime completedAt;

    @OneToOne(mappedBy = "interview", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Feedback feedback;

    public Interview() {}

    public Interview(Long id, User user, JobRole jobRole, String difficulty, String status, LocalDateTime startedAt, LocalDateTime completedAt) {
        this.id = id;
        this.user = user;
        this.jobRole = jobRole;
        this.difficulty = difficulty;
        this.status = status;
        this.startedAt = startedAt;
        this.completedAt = completedAt;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public JobRole getJobRole() { return jobRole; }
    public void setJobRole(JobRole jobRole) { this.jobRole = jobRole; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getStartedAt() { return startedAt; }
    public void setStartedAt(LocalDateTime startedAt) { this.startedAt = startedAt; }

    public LocalDateTime getCompletedAt() { return completedAt; }
    public void setCompletedAt(LocalDateTime completedAt) { this.completedAt = completedAt; }

    public Feedback getFeedback() { return feedback; }
    public void setFeedback(Feedback feedback) { this.feedback = feedback; }

    // Builder Pattern
    public static InterviewBuilder builder() {
        return new InterviewBuilder();
    }

    public static class InterviewBuilder {
        private Long id;
        private User user;
        private JobRole jobRole;
        private String difficulty;
        private String status;

        public InterviewBuilder id(Long id) { this.id = id; return this; }
        public InterviewBuilder user(User user) { this.user = user; return this; }
        public InterviewBuilder jobRole(JobRole jobRole) { this.jobRole = jobRole; return this; }
        public InterviewBuilder difficulty(String difficulty) { this.difficulty = difficulty; return this; }
        public InterviewBuilder status(String status) { this.status = status; return this; }

        public Interview build() {
            return new Interview(id, user, jobRole, difficulty, status, null, null);
        }
    }
}
