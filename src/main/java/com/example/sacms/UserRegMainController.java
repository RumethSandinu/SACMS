package com.example.sacms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserRegMainController {

    @FXML
    private AnchorPane consoleAnchor;
    @FXML
    private AnchorPane studentAnchor;
    @FXML
    private TextField advisorIdBox;
    @FXML
    private TextField advisorPassBox1;
    @FXML
    private TextField advisorPassBox2;
    @FXML
    private ImageView studentLogImage;
    @FXML
    private Button advisorLoginButton;
    @FXML
    private Button studentLoginButton;
    @FXML
    private TextField studentPassBox1;
    @FXML
    private TextField studentPassBox2;
    @FXML
    private TextField studentIdBox;
    @FXML
    private ImageView advisorLogImage;
    @FXML
    private Label advisorRegLabel;
    @FXML
    private AnchorPane advisorAnchor;
    @FXML
    private TextField advisorFnameBox;
    @FXML
    private TextField advisorLnameBox;
    @FXML
    private TextField advisorEmailBox;
    @FXML
    private Label errorRegLabel;
    @FXML
    private Label studentRegLabel;
    @FXML
    private TextField studentFnameBox;
    @FXML
    private TextField studentLnameBox;
    @FXML
    private TextField studentEmailBox;

    @FXML
    private void studentRegister() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UserRegApplication.class.getResource("student-reg.fxml"));
        Stage newStage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        newStage.setTitle("Student Sign In");
        newStage.setScene(scene);
        newStage.show();
        Stage prevStage = (Stage) consoleAnchor.getScene().getWindow();
        prevStage.close();
    }

    @FXML
    private void advisorRegister() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UserRegApplication.class.getResource("advisor-reg.fxml"));
        Stage newStage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        newStage.setTitle("Advisor Sign In");
        newStage.setScene(scene);
        newStage.show();
        Stage prevStage = (Stage) consoleAnchor.getScene().getWindow();
        prevStage.close();
    }

    @FXML
    private void backButton() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(UserRegApplication.class.getResource("UserReg.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        mainStage.setTitle("Registration");
        mainStage.setScene(scene);
        mainStage.show();
        Stage prevStage = (Stage) studentAnchor.getScene().getWindow();
        prevStage.close();
    }

    @FXML
    private void onAdvisorLoginButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    private void onStudentLoginButtonClicked(ActionEvent actionEvent) {
    }
}