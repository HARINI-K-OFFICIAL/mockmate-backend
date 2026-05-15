package com.mockmate.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "leaderboard")
public class Leaderboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(nullable = false)
    private Integer currentRank = 9999;

    @Column(nullable = false)
    private Integer previousRank = 9999;

    @UpdateTimestamp
    private LocalDateTime lastCalculatedAt;

    public Leaderboard() {}

    public Leaderboard(Long id, User user, Integer currentRank, Integer previousRank, LocalDateTime lastCalculatedAt) {
        this.id = id;
        this.user = user;
        this.currentRank = currentRank;
        this.previousRank = previousRank;
        this.lastCalculatedAt = lastCalculatedAt;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Integer getCurrentRank() { return currentRank; }
    public void setCurrentRank(Integer currentRank) { this.currentRank = currentRank; }

    public Integer getPreviousRank() { return previousRank; }
    public void setPreviousRank(Integer previousRank) { this.previousRank = previousRank; }

    public LocalDateTime getLastCalculatedAt() { return lastCalculatedAt; }
    public void setLastCalculatedAt(LocalDateTime lastCalculatedAt) { this.lastCalculatedAt = lastCalculatedAt; }

    // Builder Pattern
    public static LeaderboardBuilder builder() {
        return new LeaderboardBuilder();
    }

    public static class LeaderboardBuilder {
        private Long id;
        private User user;
        private Integer currentRank = 9999;
        private Integer previousRank = 9999;

        public LeaderboardBuilder id(Long id) { this.id = id; return this; }
        public LeaderboardBuilder user(User user) { this.user = user; return this; }
        public LeaderboardBuilder currentRank(Integer currentRank) { this.currentRank = currentRank; return this; }
        public LeaderboardBuilder previousRank(Integer previousRank) { this.previousRank = previousRank; return this; }

        public Leaderboard build() {
            return new Leaderboard(id, user, currentRank, previousRank, null);
        }
    }
}
