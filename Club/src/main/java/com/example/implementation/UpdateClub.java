package com.example.implementation;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class UpdateClub implements Initializable{

    @FXML
    public TextField clubID;
    @FXML
    public TableView<Available> clubsTable;
    @FXML
    public TableColumn<Available,String> clubId;
    @FXML
    public TableColumn<Available,String> clubName;
    public static List<Club> clubs;

    ObservableList<Available> availableClubs = FXCollections.observableArrayList();


    public void getDetails(ActionEvent actionEvent) throws IOException {
        if (clubID.getText().equalsIgnoreCase("Toastmasters Club")) {
            Stage prevStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            prevStage.close();
            Stage updateStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(ClubApplication.class.getResource("Update Club2.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            updateStage.setTitle("Update Club");
            updateStage.setScene(scene);
            updateStage.setResizable(false);
            updateStage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clubId.setCellValueFactory(new PropertyValueFactory<>("clubId"));
        clubName.setCellValueFactory(new PropertyValueFactory<>("clubName"));
        appendList();
        clubsTable.setItems(availableClubs);
    }

    public void appendList(){
        for (Club club: clubs ){
            availableClubs.add(new Available(club.getClubId(),club.getClubName()));
        }
    }
    public void backBtn2(ActionEvent actionEvent) throws IOException {
        Stage currentStage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
        Stage prevStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(ClubApplication.class.getResource("Update Club1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 552, 429);
        prevStage.setTitle("Update Club");
        prevStage.setScene(scene);
        prevStage.setResizable(false);
        prevStage.show();
    }

    public void backBtn1(ActionEvent actionEvent) throws IOException {
        Stage currentStage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
        Stage prevStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(ClubApplication.class.getResource("Club.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 552, 429);
        prevStage.setTitle("Update Club");
        prevStage.setScene(scene);
        prevStage.setResizable(false);
        prevStage.show();
    }
}

class Available{
    private String clubId;
    private String clubName;
     public Available(String clubId, String clubName){
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
}

