package com.example.sacms;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.sql.*;

import java.io.IOException;
import java.util.List;

public class ViewStudents {
    @FXML
    Button backButton;
    @FXML
    private TableColumn<Student, String> studentIdColumn;
    @FXML
    private TableColumn<Student, String> fnameColumn;
    @FXML
    private TableColumn<Student, String> lnameColumn;
    @FXML
    private TableColumn<Student, String> emailColumn;
    @FXML
    private TableColumn<Student, String> dobColumn;

    @FXML
    private TableView<Student> membersTableView;
    @FXML
    private AnchorPane studentViewAnchor;

    @FXML
    private void initialize() {
        studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        fnameColumn.setCellValueFactory(new PropertyValueFactory<>("studentFirstName"));
        lnameColumn.setCellValueFactory(new PropertyValueFactory<>("studentLastName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("studentEmail"));
        dobColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));

        loadDataIntoTableView();
    }

    private void loadDataIntoTableView() {
        try {
            List<Student> studentData = DBConnect.fetchStudentData();

            membersTableView.getItems().clear();

            membersTableView.getItems().addAll(studentData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void backButton() throws IOException {
        AddMember.backButton(backButton);
    }
}
