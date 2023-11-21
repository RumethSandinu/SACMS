package com.example.implementation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewClub extends Storage implements Initializable {

    public TableView<ReportClubs> report;
    public TableColumn<ReportClubs,String> clubId;
    public TableColumn<ReportClubs,String> clubName;
    public TableColumn<ReportClubs,ClubAdvisor> clubAdvisor;
    public TableColumn<ReportClubs,Integer> maxParticipants;
    public TableColumn<ReportClubs,Integer> currentParticipants;
    public TableColumn<ReportClubs,String> createdDate;
    ObservableList<ReportClubs> reportTable= FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clubId.setCellValueFactory(new PropertyValueFactory<>("clubId"));
        clubName.setCellValueFactory(new PropertyValueFactory<>("clubName"));
        clubAdvisor.setCellValueFactory(new PropertyValueFactory<>("clubAdvisor"));
        maxParticipants.setCellValueFactory(new PropertyValueFactory<>("maxParticipants"));
        currentParticipants.setCellValueFactory(new PropertyValueFactory<>("currentParticipants"));
        createdDate.setCellValueFactory(new PropertyValueFactory<>("createdDate"));
        appendList();
        report.setItems(reportTable);
    }

    public void appendList() {
        for (Club club : getAvailableClubs()) {
            club.setClubMembers(getAvailableClubMembers());
            reportTable.add(new ReportClubs(club.getClubId(), club.getClubName(), club.getAdvisor(),
                    club.getMaxNumber(), club.getCurrentNumber(), club.getCreatedDate().toString()));
        }
        showMembers();
    }
    public void showMembers(){

        report.setOnMouseClicked(event ->{
            if (event.getClickCount()==2){
                ReportClubs selectedClub = report.getSelectionModel().getSelectedItem();
                if(selectedClub!=null){
                    report.setOpacity(0.5);
                    showClubMembers(selectedClub);
                }
            }
        });

    }

    public void showClubMembers(ReportClubs selectedClub){
        Stage clubMembersStage = new Stage();
        TableView<ClubMember> membersTable = new TableView<>();
        TableColumn<ClubMember, String> memberColumn = new TableColumn<>("Club Members");
        memberColumn.setCellValueFactory(new PropertyValueFactory<>("fName"));

        membersTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        membersTable.getColumns().add(memberColumn);
        ObservableList<ClubMember> clubMembers = FXCollections.observableArrayList();

        for (Club club:getAvailableClubs()){
            if(selectedClub.getClubId().equals(club.getClubId())){
                clubMembers.addAll(club.getClubMembers());
            }
        }
        membersTable.setItems(clubMembers);

        Scene membersScene = new Scene(membersTable, 200, 300);
        clubMembersStage.setScene(membersScene);
        clubMembersStage.setTitle(selectedClub.getClubName());
        clubMembersStage.show();
        clubMembersStage.setResizable(false);

        report.setOnMouseClicked(mouseEvent -> {
            if (clubMembersStage.isShowing()) {
                clubMembersStage.close();
                report.setOpacity(1);
                showMembers();
            }
        });
        clubMembersStage.setOnCloseRequest(event ->{
            report.setOpacity(1);
            showMembers();
        });

    }

    public void backBtn(ActionEvent actionEvent) throws IOException {
        Stage currentStage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
        Stage reportStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(ClubApplication.class.getResource("Club.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        reportStage.setTitle("Club");
        reportStage.setScene(scene);
        reportStage.setResizable(false);
        reportStage.show();
    }
}
