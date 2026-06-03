package com.liz.quiz.a3_quiz.dto;

public class MatchResultDTO {
    private String userId; // Tem de ser String!
    private int correctAnswers;
    private int totalTimeSeconds;

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public int getCorrectAnswers() { return correctAnswers; }
    public void setCorrectAnswers(int correctAnswers) { this.correctAnswers = correctAnswers; }
    public int getTotalTimeSeconds() { return totalTimeSeconds; }
    public void setTotalTimeSeconds(int totalTimeSeconds) { this.totalTimeSeconds = totalTimeSeconds; }

public class LoginDTO {
    private String username;
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
}
