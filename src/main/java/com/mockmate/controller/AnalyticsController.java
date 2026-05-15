package com.mockmate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
@CrossOrigin(origins = "*")
public class AnalyticsController {

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserAnalytics(@PathVariable String userId) {
        // Mocks proper data extraction
        var progress = List.of(
                Map.of("name", "Mon", "score", 65),
                Map.of("name", "Tue", "score", 70),
                Map.of("name", "Wed", "score", 68),
                Map.of("name", "Thu", "score", 85),
                Map.of("name", "Fri", "score", 82),
                Map.of("name", "Sat", "score", 90),
                Map.of("name", "Sun", "score", 95)
        );

        return ResponseEntity.ok(Map.of(
                "totalInterviews", 14,
                "avgTechScore", 85.0,
                "streak", 5,
                "weeklyProgress", progress
        ));
    }

    @GetMapping("/leaderboard")
    public ResponseEntity<?> getLeaderboard() {
        var leaders = List.of(
                Map.of("rank", 1, "name", "Alex Doe", "role", "Sr. Frontend Eng", "xp", 12450, "streak", 14, "avatar", "https://ui-avatars.com/api/?name=Alex+Doe&background=7C3AED&color=fff"),
                Map.of("rank", 2, "name", "Jordan Smith", "role", "Backend Eng", "xp", 11200, "streak", 8, "avatar", "https://ui-avatars.com/api/?name=Jordan+Smith&background=3B82F6&color=fff"),
                Map.of("rank", 3, "name", "Sarah Connor", "role", "Product Manager", "xp", 10840, "streak", 21, "avatar", "https://ui-avatars.com/api/?name=Sarah+Connor&background=06B6D4&color=fff")
        );
        return ResponseEntity.ok(leaders);
    }
}
