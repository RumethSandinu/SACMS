package com.example.sacms;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SACMSController_1 {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}