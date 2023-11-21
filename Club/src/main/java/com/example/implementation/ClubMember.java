package com.example.implementation;

import java.util.ArrayList;
import java.util.Date;

public class ClubMember {
    private String memberId;
    private String fName;
    private String lName;
    private Date dob;
    private Date joinedDate;
    private ArrayList<Club> joinedClubs=new ArrayList<>();
    private String contactNumber;

    public ClubMember(String id, String fName, String contactNumber){
        this.memberId = id;
        this.fName = fName;
        this.contactNumber = contactNumber;
    }
    public ClubMember(String fName){
        this.fName = fName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void viewClubDetails(){}

    @Override
    public String toString() {
        return getFName();
    }

}
