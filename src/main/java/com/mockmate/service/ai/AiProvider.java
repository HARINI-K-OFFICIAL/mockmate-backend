package com.mockmate.service.ai;

public interface AiProvider {
    String generateInterviewQuestions(String jobRole, String difficulty);
    String evaluateAnswer(String question, String answer);
    String generateFeedback(Long interviewId);
    String extractResumeData(String textContent);
}
