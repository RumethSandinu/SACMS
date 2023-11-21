package com.example.implementation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UpdateClub1 extends Storage implements Initializable {
    @FXML
    public TextField clubID;
    @FXML
    public TableView<AvailableClubs> clubsTable;
    @FXML
    public TableColumn<AvailableClubs,String> clubId;
    @FXML
    public TableColumn<AvailableClubs,String> clubName;
    ObservableList<AvailableClubs> availableClubs = FXCollections.observableArrayList();
    public static Club updList;



    public Club getDetails(ActionEvent e) throws IOException {
        String itemCodeUpd = clubID.getText();
        boolean found = false;
        for (Club club : getAvailableClubs()) {
            if (club.getClubId().equals(itemCodeUpd)) {
                found = true;
                updList=club;
                break;
            }
        }
        if (found) {
            Stage prevStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            prevStage.close();
            Stage updateStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(ClubApplication.class.getResource("Update Selection.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 500);
            updateStage.setTitle("Update Club Details");
            updateStage.setScene(scene);
            updateStage.setResizable(false);
            updateStage.show();

        }
        return updList;
    }

    public void backBtn(ActionEvent actionEvent) throws IOException {
        Stage currentStage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
        Stage prevStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(ClubApplication.class.getResource("Club.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        prevStage.setTitle("Club");
        prevStage.setScene(scene);
        prevStage.setResizable(false);
        prevStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clubId.setCellValueFactory(new PropertyValueFactory<>("clubId"));
        clubName.setCellValueFactory(new PropertyValueFactory<>("clubName"));
        getList();
        clubsTable.setItems(availableClubs);
    }

    public void getList(){
        for(Club club: getAvailableClubs()){
            availableClubs.add(new AvailableClubs(club.getClubId(),club.getClubName()));
        }
        clubsTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                AvailableClubs selectedCode = clubsTable.getSelectionModel().getSelectedItem();
                if (selectedCode != null) {
                    clubID.setText(selectedCode.getClubId().toString());
                }
            }
        });
    }
    public static Club getUpdList(){
        return updList;
    }

}
