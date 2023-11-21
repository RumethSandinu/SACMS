package com.example.implementation;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static com.example.implementation.UpdateClub1.getUpdList;


public class UpdateProfile extends Storage{

    @FXML
    public TextField clubId;
    @FXML
    public TextField clubName;
    public DatePicker createdDate;
    public ComboBox<String> clubAdvisor;
    public Text errorCall;
    public TextField maxParticipants;
    List<ClubAdvisor> clubAdvisorList;


    public void initialize() {

        clubAdvisorList = getAvailableClubAdvisor();
        for(ClubAdvisor advisor : clubAdvisorList){
            clubAdvisor.getItems().add(advisor.getfName());
        }

    }

    public void updateClub(ActionEvent actionEvent) throws IOException {
        availableClubs.removeIf(club -> club.getClubId().equals(getUpdList().getClubId()));
        if (clubId.getText().equals("")) {
            errorCall.setText("Fill Club ID");
        } else if (clubName.getText().equals("")) {
            errorCall.setText("Fill Club Name");
        } else if(clubAdvisor.getValue()==null) {
            errorCall.setText("Select Club Advisor");
        } else if (maxParticipants.getText().equals("") ) {
            errorCall.setText("Fill maximum participants");
        } else if (createdDate.getValue() == null || createdDate.getValue().isAfter(LocalDate.now())) {
            errorCall.setText("Enter a valid date");
        } else {
            boolean clubExist=availableClubs.stream()
                    .anyMatch(club -> club.getClubId().equals(clubId.getText()) || club.getClubName().equals(clubName.getText()));

            if (clubExist) {
                errorCall.setText("Club ID or Name already exist");

            }else{
                try {
                    if(Integer.parseInt(maxParticipants.getText())>0){
                    errorCall.setText("");
                    availableClubs.add(new Club(clubId.getText(), clubName.getText(), new ClubAdvisor(clubAdvisor.getValue()), 6, createdDate.getValue()));
                    confirmation(actionEvent);
                    }else{
                        errorCall.setText("Enter positive value for maximum participants");
                    }

                }catch (NumberFormatException e){
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
        FXMLLoader fxmlLoader = new FXMLLoader(ClubApplication.class.getResource("Update Selection.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        prevStage.setTitle("Update Club");
        prevStage.setScene(scene);
        prevStage.setResizable(false);
        prevStage.show();
    }

}

