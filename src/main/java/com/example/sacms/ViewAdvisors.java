package com.example.sacms;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ViewAdvisors {

    @FXML
    private AnchorPane advisorViewAnchor;
    @FXML
    private Button backButton;
    @FXML
    private TableColumn<Advisor, String> adfnameColumn;
    @FXML
    private TableColumn<Advisor, String> adlnameColumn;
    @FXML
    private TableColumn<Advisor, String> ademailColumn;
    @FXML
    private TableColumn<Advisor, String> addobColumn;
    @FXML
    private TableColumn<Advisor, String> advisorIdColumn;
    @FXML
    private TableView<Advisor> advisorTableView;


    @FXML
    private void initialize() {
        advisorIdColumn.setCellValueFactory(new PropertyValueFactory<>("advisorId"));
        adfnameColumn.setCellValueFactory(new PropertyValueFactory<>("advisorFirstName"));
        adlnameColumn.setCellValueFactory(new PropertyValueFactory<>("advisorLastName"));
        ademailColumn.setCellValueFactory(new PropertyValueFactory<>("advisorEmail"));
        addobColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));

        loadDataIntoTableView();
    }

    private void loadDataIntoTableView() {
        try {
            List<Advisor> advisorData = DBConnect.fetchAdvisorData();

            advisorTableView.getItems().clear();

            advisorTableView.getItems().addAll(advisorData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void backButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UserRegApplication.class.getResource("view-members.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 950, 600);
        mainStage.setTitle("Members Enrolled");
        mainStage.setScene(scene);
        mainStage.show();
        Stage prevStage = (Stage) backButton.getScene().getWindow();
        prevStage.close();
    }
}
