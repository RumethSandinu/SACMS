package com.example.sacms;

public class Advisor {
    private String advisorId;
    private String advisorName;
    private String advisorEmail;
    private String advisorPassword;

    public Advisor(String advisorId, String advisorName, String advisorEmail, String advisorPassword) {
        this.advisorId = advisorId;
        this.advisorName = advisorName;
        this.advisorEmail = advisorEmail;
        this.advisorPassword = advisorPassword;
    }

    public Advisor() {
    }

    public String getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(String advisorId) {
        this.advisorId = advisorId;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

    public String getAdvisorEmail() {
        return advisorEmail;
    }

    public void setAdvisorEmail(String advisorEmail) {
        this.advisorEmail = advisorEmail;
    }

    public String getAdvisorPassword() {
        return advisorPassword;
    }

    public void setAdvisorPassword(String advisorPassword) {
        this.advisorPassword = advisorPassword;
    }
}
