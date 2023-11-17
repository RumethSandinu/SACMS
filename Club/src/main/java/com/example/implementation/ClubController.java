package com.example.implementation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ClubController {


    public void createClub(ActionEvent actionEvent) throws IOException {
        Stage currentStage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
        Stage prevStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(ClubApplication.class.getResource("Create Club.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        prevStage.setTitle("Create Club");
        prevStage.setScene(scene);
        prevStage.setResizable(false);
        prevStage.show();
    }

    public void updateClub(ActionEvent actionEvent) throws IOException {
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

    public void deleteClub(ActionEvent actionEvent) throws IOException {
        Stage currentStage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
        Stage prevStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(ClubApplication.class.getResource("Delete Club.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        prevStage.setTitle("Club");
        prevStage.setScene(scene);
        prevStage.setResizable(false);
        prevStage.show();
    }

    public void generateReports(ActionEvent actionEvent) throws IOException {
        Stage currentStage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
        Stage prevStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Generate Reports.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        prevStage.setTitle("Generated Reports");
        prevStage.setScene(scene);
        prevStage.setResizable(false);
        prevStage.show();
    }

    public void addMember(ActionEvent actionEvent) {
    }
}