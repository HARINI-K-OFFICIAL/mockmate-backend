package com.mockmate.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "achievements")
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String badgeIcon;

    @Column(nullable = false)
    private Integer xpRewarded;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime unlockedAt;

    public Achievement() {}

    public Achievement(Long id, User user, String title, String badgeIcon, Integer xpRewarded, LocalDateTime unlockedAt) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.badgeIcon = badgeIcon;
        this.xpRewarded = xpRewarded;
        this.unlockedAt = unlockedAt;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getBadgeIcon() { return badgeIcon; }
    public void setBadgeIcon(String badgeIcon) { this.badgeIcon = badgeIcon; }

    public Integer getXpRewarded() { return xpRewarded; }
    public void setXpRewarded(Integer xpRewarded) { this.xpRewarded = xpRewarded; }

    public LocalDateTime getUnlockedAt() { return unlockedAt; }
    public void setUnlockedAt(LocalDateTime unlockedAt) { this.unlockedAt = unlockedAt; }

    // Builder Pattern
    public static AchievementBuilder builder() {
        return new AchievementBuilder();
    }

    public static class AchievementBuilder {
        private Long id;
        private User user;
        private String title;
        private String badgeIcon;
        private Integer xpRewarded;

        public AchievementBuilder id(Long id) { this.id = id; return this; }
        public AchievementBuilder user(User user) { this.user = user; return this; }
        public AchievementBuilder title(String title) { this.title = title; return this; }
        public AchievementBuilder badgeIcon(String badgeIcon) { this.badgeIcon = badgeIcon; return this; }
        public AchievementBuilder xpRewarded(Integer xpRewarded) { this.xpRewarded = xpRewarded; return this; }

        public Achievement build() {
            return new Achievement(id, user, title, badgeIcon, xpRewarded, null);
        }
    }
}
