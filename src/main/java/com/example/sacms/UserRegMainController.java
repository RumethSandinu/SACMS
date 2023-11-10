package com.example.sacms;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserRegMainController {

    @FXML
    private AnchorPane consoleAnchor;

    @FXML
    private void studentRegister() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UserRegApplication.class.getResource("UserReg.fxml"));
        Stage newStage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        newStage.setTitle("Registration");
        newStage.setScene(scene);
        newStage.show();
        Stage prevStage = (Stage) consoleAnchor.getScene().getWindow();
        prevStage.close();
    }

    @FXML
    private void advisorRegister() throws IOException {

    }


}