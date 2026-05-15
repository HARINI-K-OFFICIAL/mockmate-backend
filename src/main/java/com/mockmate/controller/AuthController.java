package com.mockmate.controller;

import com.mockmate.entity.Analytics;
import com.mockmate.entity.Leaderboard;
import com.mockmate.entity.User;
import com.mockmate.repository.AnalyticsRepository;
import com.mockmate.repository.LeaderboardRepository;
import com.mockmate.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") 
public class AuthController {

    private final UserRepository userRepository;
    private final AnalyticsRepository analyticsRepository;
    private final LeaderboardRepository leaderboardRepository;

    public AuthController(UserRepository userRepository, AnalyticsRepository analyticsRepository, LeaderboardRepository leaderboardRepository) {
        this.userRepository = userRepository;
        this.analyticsRepository = analyticsRepository;
        this.leaderboardRepository = leaderboardRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> payload) {
        String uid = payload.get("uid");
        String email = payload.get("email");
        String displayName = payload.get("displayName");
        String photoUrl = payload.get("photoURL");

        Optional<User> existingUser = userRepository.findByFirebaseUid(uid);
        
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            // Update profile info if missing
            if (displayName != null && !displayName.equals(user.getFullName())) {
                user.setFullName(displayName);
            }
            if (photoUrl != null && !photoUrl.equals(user.getAvatarUrl())) {
                user.setAvatarUrl(photoUrl);
            }
            userRepository.save(user);
            return ResponseEntity.ok(Map.of("status", "success", "user", user));
        }

        // New Registration Sync
        User newUser = User.builder()
                .firebaseUid(uid)
                .email(email != null ? email : "")
                .fullName(displayName != null ? displayName : "MockMate User")
                .avatarUrl(photoUrl)
                .build();
                
        userRepository.save(newUser);

        // Map baseline structures
        Analytics analytics = Analytics.builder().user(newUser).build();
        analyticsRepository.save(analytics);
        
        Leaderboard leaderboard = Leaderboard.builder().user(newUser).currentRank(9999).previousRank(9999).build();
        leaderboardRepository.save(leaderboard);

        return ResponseEntity.ok(Map.of("status", "created", "user", newUser));
    }
}

