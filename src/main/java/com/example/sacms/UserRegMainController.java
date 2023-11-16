package com.example.sacms;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import static com.example.sacms.AddMember.studentList;
import static com.example.sacms.AddMember.advisorList;

public class UserRegMainController {

    @FXML
    private AnchorPane consoleAnchor;
    @FXML
    private AnchorPane membersAnchor;

    @FXML
    private void studentRegister() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UserRegApplication.class.getResource("student-reg.fxml"));
        Stage newStage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 950, 600);
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
        Scene scene = new Scene(fxmlLoader.load(), 950, 600);
        newStage.setTitle("Advisor Sign In");
        newStage.setScene(scene);
        newStage.show();
        Stage prevStage = (Stage) consoleAnchor.getScene().getWindow();
        prevStage.close();
    }

    @FXML
    protected void loadStudentsFromFile() throws IOException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("StudentDetails.ser"))) {
            studentList = (List<Student>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void loadAdvisorsFromFile() throws IOException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("AdvisorDetails.ser"))) {
            advisorList = (List<Advisor>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
