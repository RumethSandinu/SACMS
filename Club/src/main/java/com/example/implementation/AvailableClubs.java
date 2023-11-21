package com.example.implementation;

import java.util.List;

public class AvailableClubs {
    private String clubId;
    private String clubName;
    public static List<Club> clubs;

    public AvailableClubs(String clubId, String clubName) {
        this.clubId = clubId;
        this.clubName = clubName;
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

    public static List<Club> getClubs() {
        return clubs;
    }

    public static void setClubs(List<Club> clubs) {
        AvailableClubs.clubs = clubs;
    }



}
