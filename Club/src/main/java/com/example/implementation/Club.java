package com.example.implementation;

import javafx.scene.control.Button;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Club {
    private String clubId;
    private String clubName;
    private ClubAdvisor advisor;
    private int maxNumber;
    private int currentNumber;
    private Button showMembers;
    private LocalDate createdDate;

    private List<ClubMember> clubMembers;

    public Club(String clubId, String clubName,ClubAdvisor advisor,int maxNumber, LocalDate createdDate ) {
        this.clubId = clubId;
        this.clubName = clubName;
        this.advisor = advisor;
        this.maxNumber=maxNumber;
        this.createdDate = createdDate;

    }

    public Button getShowMembers() {
        return showMembers;
    }

    public void setShowMembers(Button showMembers) {
        this.showMembers = showMembers;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public ClubAdvisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(ClubAdvisor advisor) {
        this.advisor = advisor;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public int getCurrentNumber() {
        return clubMembers.size();
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public List<ClubMember> getClubMembers() {
        return clubMembers;
    }

    public void setClubMembers(List<ClubMember> clubMembers) {
        this.clubMembers = clubMembers;
    }
}
