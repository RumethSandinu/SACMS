package com.example.implementation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class AvailableMembers{
    private String memberID;
    private String memberName;
    public static List<ClubMember> members;
    static ObservableList<AvailableMembers> availableMembers = FXCollections.observableArrayList();

    public AvailableMembers(String memberID, String memberName){
        this.memberID = memberID;
        this.memberName = memberName;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public static List<ClubMember> getMembers() {
        return members;
    }

    public static void setMembers(List<ClubMember> members) {
        AvailableMembers.members = members;
    }

    public static ObservableList<AvailableMembers> getAvailableMembers() {
        return availableMembers;
    }

    public static void setAvailableMembers(ObservableList<AvailableMembers> availableMembers) {
        AvailableMembers.availableMembers = availableMembers;
    }

    public static ObservableList<AvailableMembers> setList(){
        for (ClubMember member:members){
            availableMembers.add(new AvailableMembers(member.getId(),member.getFName()));
        }
        return availableMembers;
    }
}
