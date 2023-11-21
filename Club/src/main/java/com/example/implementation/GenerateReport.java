package com.example.implementation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GenerateReport extends Storage implements Initializable {

    public TableView<ReportClubs> report;
    public TableColumn<ReportClubs,String> clubId;
    public TableColumn<ReportClubs,String> clubName;
    public TableColumn<ReportClubs,ClubAdvisor> clubAdvisor;
    public TableColumn<ReportClubs,Integer> maxParticipants;
    public TableColumn<ReportClubs,Integer> currentParticipants;
    public TableColumn<ReportClubs,String> createdDate;
    List<Club> reportClubs = new ArrayList<>(List.of());
    ObservableList<ReportClubs> reportTable= FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clubId.setCellValueFactory(new PropertyValueFactory<>("clubId"));
        clubName.setCellValueFactory(new PropertyValueFactory<>("clubName"));
        clubAdvisor.setCellValueFactory(new PropertyValueFactory<>("clubAdvisor"));
        maxParticipants.setCellValueFactory(new PropertyValueFactory<>("maxParticipants"));
        currentParticipants.setCellValueFactory(new PropertyValueFactory<>("currentParticipants"));
        createdDate.setCellValueFactory(new PropertyValueFactory<>("createdDate"));
        appendList();
        report.setItems(reportTable);
    }

    public void appendList(){
        for (Club club:getAvailableClubs()){
            reportTable.add(new ReportClubs(club.getClubId(),club.getClubName(),club.getAdvisor(),
                    club.getMaxNumber(),club.getCurrentNumber(),club.getCreatedDate().toString()));
        }
    }

    public void backBtn(ActionEvent actionEvent) throws IOException {
        Stage currentStage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
        Stage reportStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(ClubApplication.class.getResource("Club.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        reportStage.setTitle("Club");
        reportStage.setScene(scene);
        reportStage.setResizable(false);
        reportStage.show();
    }
}
