package com.example.sacms;

import com.example.sacms.EventScheduling.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class EventController
{
    @FXML
    private TextField clubID;
    @FXML
    private TextField eventID;
    @FXML
    private TextField eventType;
    @FXML
    private TextField eventYear;
    @FXML
    private TextField eventMonth;
    @FXML
    private TextField eventDay;
    @FXML
    private TextField eventHour;
    @FXML
    private TextField eventMin;
    @FXML
    private TextField eventPlace;
    @FXML
    private TextField eventPlatform;
    @FXML
    private TextField eventLink;









   @FXML
    public void onClickAddEventButton(ActionEvent e) throws Exception {
    Stage newStage = new Stage();
    Stage previousStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
    newStage.initOwner(previousStage);
    Parent root = FXMLLoader.load(getClass().getResource("event-type-selection-ui.fxml"));
    Scene scene = new Scene(root, 400, 73);
    newStage.setScene(scene);
    newStage.setResizable(false);
    newStage.setTitle("Please select the event type");
    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    newStage.setX((primaryScreenBounds.getWidth() - scene.getWidth()) / 2);
    newStage.setY((primaryScreenBounds.getHeight() - scene.getHeight()) / 2);
    newStage.show();
}

    @FXML
    public void onClickExitButton()
    {
        System.exit(0);
    }


@FXML
public void onClickEventMeetingButton(ActionEvent e) throws Exception {
    Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
    Stage previousStage = (Stage) currentStage.getOwner();
    currentStage.close();
    Parent root = FXMLLoader.load(getClass().getResource("create-meeting-ui.fxml"));
    previousStage.setScene(new Scene(root, 800, 600));
    previousStage.show();
}

@FXML
public void onClickCreateMeetingButton(ActionEvent e) throws Exception{
       Meeting newMeeting = new Meeting(clubID.getText(), eventID.getText(), eventYear.getText(), eventMonth.getText(),
            eventDay.getText(), eventHour.getText(), eventMin.getText(), eventType.getText(), eventPlace.getText(),
               eventPlatform.getText(),
            eventLink.getText());
}
}