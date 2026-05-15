package com.mockmate.service.ai.impl;

import com.mockmate.service.ai.AiProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("GEMINI")
public class GeminiProviderImpl implements AiProvider {

    @Value("${mockmate.ai.api-key.gemini}")
    private String apiKey;

    @Override
    public String generateInterviewQuestions(String jobRole, String difficulty) {
        // TODO: Implement actual RestTemplate/WebClient call to Gemini API
        return "{\"questions\": [\"Mock Gemini Question 1\", \"Mock Gemini Question 2\"]}";
    }

    @Override
    public String evaluateAnswer(String question, String answer) {
        return "{\"score\": 85, \"feedback\": \"Good answer using STAR method.\"}";
    }

    @Override
    public String generateFeedback(Long interviewId) {
        return "{\"techScore\": 90, \"commsScore\": 85, \"overallScore\": 88, \"summary\": \"Excellent performance.\"}";
    }

    @Override
    public String extractResumeData(String textContent) {
        return "{\"atsScore\": 82, \"skills\": [\"Java\", \"Spring Boot\"]}";
    }
}
