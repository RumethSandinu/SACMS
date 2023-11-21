package com.example.implementation;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class CreateClub extends ClubApplication {
    public TextField clubId;
    public TextField clubName;
    public ComboBox<String> clubAdvisor;
    public DatePicker createdDate;
    public Text errorCall;
    public TextField maxParticipants;
    Club list;
    List<ClubAdvisor> clubAdvisorList;
    List<Club> clubList;

    public void initialize() {
        clubAdvisorList = Storage.getAvailableClubAdvisor();
        for(ClubAdvisor advisor : clubAdvisorList){
            clubAdvisor.getItems().add(advisor.getfName());
        }
    }


    public void createClub(ActionEvent CreateClub) throws IOException {
        clubList=Storage.getAvailableClubs();

        if (clubId.getText().equals("")) {
            errorCall.setText("Fill Club ID");
        } else if (clubName.getText().equals("")) {
            errorCall.setText("Fill Club Name");
        } else if(clubAdvisor.getValue()==null){
            errorCall.setText("Select Club Advisor");
        } else if (createdDate.getValue() == null || createdDate.getValue().isAfter(LocalDate.now())) {
            errorCall.setText("Enter a valid date");
        } else {
            boolean clubExist=clubList.stream()
                    .anyMatch(club -> club.getClubId().equals(clubId.getText()) || club.getClubName().equals(clubName.getText()));

                if (clubExist) {
                    errorCall.setText("Club ID or Name already exist");
                }else{
                    try{
                        if(Integer.parseInt(maxParticipants.getText())>0){
                    list = new Club(clubId.getText(), clubName.getText(),new ClubAdvisor(clubAdvisor.getValue()),Integer.parseInt(maxParticipants.getText()), LocalDate.parse(createdDate.getValue().toString()));
                    clubList.add(list);
                    errorCall.setText("");

                    confirmation(CreateClub);
                        }else{
                            errorCall.setText("Enter positive value");
                        }
                    }catch(Exception e){
                        errorCall.setText("Enter integer value for maximum participants");
                    }
                }
            }
        }
    public void confirmation(ActionEvent event) throws IOException {

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Save the current data");
        confirm.setContentText("Do you want to add another item to the list? ");

        if (confirm.showAndWait().get() == ButtonType.OK) {
            clubId.clear();
            clubName.clear();
            clubAdvisor.setValue(null);
            createdDate.setValue(null);

        } else {
            event.consume();
            Stage prevStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            prevStage.close();
            FXMLLoader homeFXML = new FXMLLoader(ClubApplication.class.getResource("Club.fxml"));
            Scene scene1 = new Scene(homeFXML.load(), 800, 500);
            Stage homePage = new Stage();
            homePage.setScene(scene1);
            homePage.show();
            homePage.centerOnScreen();
        }
    }

    public void backBtn(ActionEvent actionEvent) throws IOException {
        Stage currentStage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
        Stage prevStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(ClubApplication.class.getResource("Club.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        prevStage.setTitle("Club");
        prevStage.setScene(scene);
        prevStage.setResizable(false);
        prevStage.show();
    }


}