package com.example.sacms;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ViewMembers {

    private Button backButton;
    @FXML
    private AnchorPane membersAnchor;

    @FXML
    private void backButton() throws IOException {
        AddMember.backButton(backButton);
    }
}
