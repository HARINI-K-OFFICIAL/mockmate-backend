package com.mockmate.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "job_roles")
public class JobRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    public JobRole() {}

    public JobRole(Long id, String title, String description, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    // Builder Pattern
    public static JobRoleBuilder builder() {
        return new JobRoleBuilder();
    }

    public static class JobRoleBuilder {
        private Long id;
        private String title;
        private String description;

        public JobRoleBuilder id(Long id) { this.id = id; return this; }
        public JobRoleBuilder title(String title) { this.title = title; return this; }
        public JobRoleBuilder description(String description) { this.description = description; return this; }

        public JobRole build() {
            return new JobRole(id, title, description, null);
        }
    }
}
