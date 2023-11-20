package com.example.sacms;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ViewMembers {

    @FXML
    private Button backButton;
    @FXML
    private AnchorPane membersAnchor;
    @FXML
    private TableColumn fnameColumn;
    @FXML
    private TableColumn lnameColumn;
    @FXML
    private TableColumn emailColumn;
    @FXML
    private TableColumn dobColumn;


    @FXML
    private void backButton() throws IOException {
        AddMember.backButton(backButton);
    }
}
