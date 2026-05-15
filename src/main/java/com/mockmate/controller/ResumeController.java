package com.mockmate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin(origins = "*")
public class ResumeController {

    @PostMapping("/upload")
    public ResponseEntity<?> uploadResume(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(Map.of(
                "score", 85,
                "strengths", new String[]{"Strong technical vocabulary", "Clear measurable impact"},
                "weaknesses", new String[]{"Missing soft skills (leadership)"},
                "skills", new Object[]{
                        Map.of("name", "Java / Spring", "level", 90),
                        Map.of("name", "React", "level", 85)
                }
        ));
    }

    @PostMapping("/analyze")
    public ResponseEntity<?> analyzeResume(@RequestBody Map<String, String> payload) {
        return ResponseEntity.ok(Map.of("status", "success"));
    }
}
