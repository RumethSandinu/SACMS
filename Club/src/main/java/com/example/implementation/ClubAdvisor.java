package com.example.implementation;

import java.util.ArrayList;

public class ClubAdvisor {
    private String fName;
    private String lName;
    private String email;
    private String contactNumber;
    private ArrayList<Club> advisingClubs;

    public ClubAdvisor(String fName, String lName, String contactNumber) {
        this.fName = fName;
        this.lName = lName;
        this.contactNumber = contactNumber;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public ArrayList<Club> getAdvisingClubs() {
        return advisingClubs;
    }

    public void setAdvisingClubs(ArrayList<Club> advisingClubs) {
        this.advisingClubs = advisingClubs;
    }

    public void addClub(Club club){

    }
    public void removeClub(Club club){}
}
