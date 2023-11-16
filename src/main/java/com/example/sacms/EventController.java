package com.example.sacms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class EventController
{
   @FXML
    public void onClickAddEventButton(ActionEvent e) throws Exception {
    Stage newStage = new Stage();
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

}