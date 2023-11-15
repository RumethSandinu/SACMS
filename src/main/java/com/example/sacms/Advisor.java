package com.example.sacms;

public class Advisor implements Member {
    private String advisorId;
    private String advisorFirstName;
    private String advisorLastName;
    private String advisorEmail;
    private String advisorPassword;

    public Advisor() {
    }

    public Advisor(String advisorId, String advisorFirstName, String advisorLastName, String advisorEmail, String advisorPassword) {
        this.advisorId = advisorId;
        this.advisorFirstName = advisorFirstName;
        this.advisorLastName = advisorLastName;
        this.advisorEmail = advisorEmail;
        this.advisorPassword = advisorPassword;
    }

    public String getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(String advisorId) {
        this.advisorId = advisorId;
    }

    public String getAdvisorFirstName() {
        return advisorFirstName;
    }

    public void setAdvisorFirstName(String advisorFirstName) {
        this.advisorFirstName = advisorFirstName;
    }

    public String getAdvisorLastName() {
        return advisorLastName;
    }

    public void setAdvisorLastName(String advisorLastName) {
        this.advisorLastName = advisorLastName;
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
