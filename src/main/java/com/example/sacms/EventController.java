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
import java.sql.*;

public class EventController
{

    String url = "jdbc:mysql://localhost:3306/SACMS";
    String user = "root";
    String password = "root";

    @FXML
    protected TextField clubID;
    @FXML
    protected TextField eventID;
    @FXML
    protected TextField eventType;
    @FXML
    protected TextField eventYear;
    @FXML
    protected TextField eventMonth;
    @FXML
    protected TextField eventDay;
    @FXML
    protected TextField startHour;
    @FXML
    protected TextField startMin;
    @FXML
    protected TextField endHour;
    @FXML
    protected TextField endMin;
    @FXML
    protected TextField eventPlace;
    @FXML
    protected TextField eventPlatform;
    @FXML
    protected TextField eventLink;
    @FXML
    protected TextField meetingNum;

    private int validPoints;





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
public void onClickEventMeetingButton(ActionEvent e) throws Exception
{
    Stage currentStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
    Stage previousStage = (Stage) currentStage.getOwner();
    currentStage.close();
    Parent root = FXMLLoader.load(getClass().getResource("create-meeting-ui.fxml"));
    previousStage.setScene(new Scene(root, 800, 600));
    previousStage.show();
}

    @FXML
    public void onClickCreateMeetingButton(ActionEvent e) throws Exception {

        Meeting newMeeting = new Meeting(clubID.getText(), eventID.getText(), eventYear.getText(), eventMonth.getText(),
                eventDay.getText(), startHour.getText(), startMin.getText(), endHour.getText(), endMin.getText(),
                meetingNum.getText(), eventPlatform.getText(), eventLink.getText());
        newMeeting.createEvent();
        newMeeting.values = new String[8];
        validPoints = 0;
        if(EventValidator.isValidClubID())
        {
            newMeeting.values[0] = clubID.getText();
            validPoints++;
        } else
        {
            clubID.clear();
        }
        if(EventValidator.isValidEventID())
        {
            newMeeting.values[1] = eventID.getText();
            validPoints++;
        }
        else
        {
            eventID.clear();
        }
        if(EventValidator.isValidYear() && EventValidator.isValidMonth() && EventValidator.isValidDay())
        {
            newMeeting.values[2] = eventYear.getText() + "/" + eventMonth.getText() + "/" + eventDay.getText();
            validPoints++;
        }
        else
        {
            eventYear.clear();
            eventMonth.clear();
            eventDay.clear();
        }
        if(EventValidator.isValidStartHour() && EventValidator.isValidStartMin())
        {
            newMeeting.values[3] = startHour.getText() + ":" + startMin.getText();
            validPoints++;
        }
        else
        {
            startHour.clear();
            startMin.clear();
        }

        if(EventValidator.isValidEndHour() && EventValidator.isValidEndMin())
        {
            if(Integer.parseInt(startHour.getText()) < Integer.parseInt(endHour.getText()) ||
                    (Integer.parseInt(startHour.getText()) == Integer.parseInt(endHour.getText()) &&
                    (Integer.parseInt(startMin.getText()) < Integer.parseInt(endMin.getText()))))
            {
                newMeeting.values[4] = endHour.getText() + ":" + endMin.getText();
                validPoints++;
            }
            else
            {
                endHour.clear();
                endMin.clear();
            }
        }
        else
        {
            endHour.clear();
            endMin.clear();
        }
        if(EventValidator.isValidMeetingNum())
        {
            newMeeting.values[5] = meetingNum.getText();
            validPoints++;
        }
        else
        {
            meetingNum.clear();
        }
        if(EventValidator.isValidPlatform())
        {
            newMeeting.values[6] = eventPlatform.getText();
            validPoints++;
        }
        else
        {
            eventPlatform.clear();
        }
        if(EventValidator.isValidLink())
        {
            newMeeting.values[7] = eventLink.getText();
            validPoints++;
        }
        else
        {
            eventLink.clear();
        }
        if (validPoints == 8) {
        String query = "INSERT INTO Meeting VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (int i = 0; i < 8; i++) {
                preparedStatement.setString(i + 1, newMeeting.values[i]);
            }

            preparedStatement.executeUpdate();
            System.out.println("Meeting data inserted successfully.");

        } catch (SQLException edb) {
            edb.printStackTrace(); // Handle the exception appropriately in your application
        }
    }
    }
}