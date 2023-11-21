package com.example.implementation;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class UpdateMembers extends Storage{
    public TableView<ClubMember> clubMemberTbl;
    public TableColumn<ClubMember,String> memberIdColumn;
    public TableColumn<ClubMember,String> fNameColumn;
    public TableColumn<ClubMember,String> lNameColumn;

    public void initialize(){
        memberIdColumn.setCellValueFactory((new PropertyValueFactory<>("memberId")));
        fNameColumn.setCellValueFactory((new PropertyValueFactory<>("fName")));
        lNameColumn.setCellValueFactory((new PropertyValueFactory<>("lName")));

    }

    public void deleteMember(ActionEvent actionEvent) {
        ClubMember member=clubMemberTbl.getSelectionModel().getSelectedItem();


    }

    public void addMember(ActionEvent actionEvent) {
    }

    public void updateMembers(ActionEvent actionEvent) {
    }
}
