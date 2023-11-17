package com.example.implementation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Club {
    private String clubId;
    private String clubName;
    private String createdDate;
    private ClubAdvisor advisor;
    private ArrayList<Event> events=new ArrayList<>();
    private ArrayList<ClubMember> clubMembers=new ArrayList<>();

    public Club(String clubId, String clubName, String createdDate, ClubAdvisor advisor) {
        this.clubId = clubId;
        this.clubName = clubName;
        this.createdDate = createdDate;
        this.advisor = advisor;
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void onClubClick(ActionEvent actionEvent) throws IOException {
        Stage prevStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        prevStage.close();
        Stage aidStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(ClubApplication.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 800);
        aidStage.setTitle("Add Item");
        aidStage.setScene(scene);
        aidStage.setResizable(false);
        aidStage.show();

    }
}
