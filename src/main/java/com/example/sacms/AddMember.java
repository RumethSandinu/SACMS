package com.example.sacms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;

public class AddMember {

    @FXML
    private AnchorPane studentAnchor;
    @FXML
    private TextField studentIdBox;
    @FXML
    private TextField studentPassBox1;
    @FXML
    private ImageView studentLogImage;
    @FXML
    private Button studentRegButton;
    @FXML
    private TextField studentPassBox2;
    @FXML
    private Label studentRegLabel;
    @FXML
    private TextField studentFnameBox;
    @FXML
    private TextField studentLnameBox;
    @FXML
    private TextField studentEmailBox;
    @FXML
    private AnchorPane advisorAnchor;
    @FXML
    private TextField advisorIdBox;
    @FXML
    private TextField advisorPassBox1;
    @FXML
    private ImageView advisorLogImage;
    @FXML
    private Button advisorRegButton;
    @FXML
    private TextField advisorPassBox2;
    @FXML
    private Label advisorRegLabel;
    @FXML
    private TextField advisorFnameBox;
    @FXML
    private TextField advisorLnameBox;
    @FXML
    private TextField advisorEmailBox;
    private String studentId;
    private String studentFirstName;
    private String studentLastName;
    private String studentEmail;
    private String studentPassword;
    private String studentPassTemp;
    protected static List<Student> studentList = new ArrayList<>();



    @FXML
    private void backButton() throws IOException {
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
    private void onStudentRegButtonClicked() throws IOException{
        if (Objects.equals(studentIdBox.getText(), "") || Objects.equals(studentFnameBox.getText(), "") ||
        Objects.equals(studentLnameBox.getText(), "") || Objects.equals(studentEmailBox.getText(), "") ||
        Objects.equals(studentPassBox1.getText(), "") || Objects.equals(studentPassBox2.getText(), "")){
            studentRegLabel.setText("Please fill the above credentials");
        }
        else {
            System.out.println("test");

            try {
                if (!Objects.equals(studentIdBox.getText(), "")){
                    studentId = studentIdBox.getText();
                }else{
                    studentRegLabel.setText("Enter your Student ID");
                }
            }catch (InputMismatchException | NumberFormatException | NullPointerException e1){
                studentRegLabel.setText("Invalid Student ID");
                return;
            }

            try {
                if (!Objects.equals(studentFnameBox.getText(), "")){
                    studentFirstName = studentFnameBox.getText();
                }else{
                    studentRegLabel.setText("Enter your First Name");
                }
            }catch (NullPointerException e2){
                studentRegLabel.setText("Invalid First Name");
                return;
            }

            try {
                if (!Objects.equals(studentLnameBox.getText(), "")){
                    studentLastName = studentLnameBox.getText();
                }else{
                    studentRegLabel.setText("Enter your Last Name");
                }
            }catch (NullPointerException e3){
                studentRegLabel.setText("Invalid Last Name");
                return;
            }

            try {
                if (!Objects.equals(studentEmailBox.getText(), "")){
                    studentEmail = studentEmailBox.getText();
                }else{
                    studentRegLabel.setText("Enter your Email");
                }
            }catch (NullPointerException e4){
                studentRegLabel.setText("Invalid Email");
                return;
            }

            try {
                if (!Objects.equals(studentPassBox1.getText(), "")){
                    studentPassTemp = studentPassBox1.getText();
                }else{
                    studentRegLabel.setText("Enter a password");
                }
            }catch (NullPointerException e5){
                studentRegLabel.setText("Password must not be empty!");
                return;
            }

            try {
                if (!Objects.equals(studentPassBox2.getText(), "")){
                    if (!Objects.equals(studentPassTemp, studentPassBox2.getText())){
                        studentRegLabel.setText("Password Mismatch");
                    }else {
                        studentPassword = studentPassTemp;
                    }
                }else{
                    studentRegLabel.setText("Re-Enter your password");
                }
            }catch (NullPointerException e6){
                studentRegLabel.setText("Password must not be empty!");
                return;
            }

            try {
                Student student = new Student(studentId, studentFirstName, studentLastName, studentEmail, studentPassword);
                studentList.add(student);

                for (Object i: studentList){
                    System.out.println(student.getStudentId());
                    System.out.println(student.getStudentFirstName());
                    System.out.println(student.getStudentLastName());
                    System.out.println(student.getStudentEmail());
                    System.out.println(student.getStudentPassword());
                }

                clearStudentFields();
                studentRegLabel.setText("Registration Complete");
            }catch (Exception e7){
                System.out.println(e7.getMessage());
                studentRegLabel.setText("Error Encountered");
            }

        }
    }

    @FXML
    private void onAdvisorRegButtonClicked(ActionEvent actionEvent) {
    }

    private void clearStudentFields(){
        studentIdBox.clear();
        studentFnameBox.clear();
        studentLnameBox.clear();
        studentEmailBox.clear();
        studentPassBox1.clear();
        studentPassBox2.clear();

    }
}
