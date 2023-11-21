package com.example.implementation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class DisplayClub{
    public Text clubId;
    public Text clubName;
    public Text clubAdvisor;
    public Text maxParticipants;
    public Text currentParticipants;
    public Text createdDate;
    public TableView<ClubMember> membersTbl;
    public TableColumn<ClubMember,String> members;
    ObservableList<ClubMember> membersFX= FXCollections.observableArrayList();


    public void displayDetails(ReportClubs selectedClub){

        clubId.setText(selectedClub.getClubId());
        clubName.setText(selectedClub.getClubName());
        clubAdvisor.setText(selectedClub.getClubAdvisor().getfName());
        maxParticipants.setText(String.valueOf(selectedClub.getMaxParticipants()));
        currentParticipants.setText(String.valueOf(selectedClub.getCurrentParticipants()));
        createdDate.setText(selectedClub.getCreatedDate());
    }
    public void initialize(){
        members.setCellValueFactory(new PropertyValueFactory<>("members"));
        membersFX.addAll(Storage.getAvailableClubMembers());
        membersTbl.setItems(membersFX);

    }
}
