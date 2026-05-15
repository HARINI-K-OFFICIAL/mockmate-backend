package com.mockmate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/interview")
@CrossOrigin(origins = "*")
public class InterviewController {

    @PostMapping("/generateQuestions")
    public ResponseEntity<?> generateQuestions(@RequestParam(required = false) String role, @RequestParam(required = false) String difficulty) {
        return ResponseEntity.ok(Map.of(
                "question", "Can you describe a time when you had to design a highly scalable microservice architecture? What were the key challenges and how did you overcome them?"
        ));
    }

    @PostMapping("/evaluateAnswer")
    public ResponseEntity<?> evaluateAnswer(@RequestBody Map<String, String> payload) {
        return ResponseEntity.ok(Map.of(
                "feedback", "That's a solid answer. You clearly identified the single point of failure and introduced a message queue effectively. For the next question: How do you handle distributed transactions?"
        ));
    }
}
