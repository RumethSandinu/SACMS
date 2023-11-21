package com.example.implementation;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateSelection {
    public void updateProfile(ActionEvent actionEvent) throws IOException {
        Stage prevStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        prevStage.close();
        Stage updateStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(ClubApplication.class.getResource("Update Profile.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        updateStage.setTitle("Update Club Profile");
        updateStage.setScene(scene);
        updateStage.setResizable(false);
        updateStage.show();

    }

    public void updateMembers(ActionEvent actionEvent) {

    }

    public void backBtn(ActionEvent actionEvent) throws IOException {
        Stage currentStage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
        Stage prevStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(ClubApplication.class.getResource("Update Club1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        prevStage.setTitle("Club");
        prevStage.setScene(scene);
        prevStage.setResizable(false);
        prevStage.show();
    }
}
