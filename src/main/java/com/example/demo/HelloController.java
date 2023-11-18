package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class HelloController {

    @FXML
    private TextField firstName;

    @FXML
    private TextField Stu_ID;

    @FXML
    private DatePicker dobDatePicker;

    @FXML
    private DatePicker joinedDatePicker;

    @FXML
    private TextField gradeTextField;

    @FXML
    private TextField eventName;

    @FXML
    private Button saveButton;

    @FXML
    private TextField clubNameTextField;

    @FXML
    private TextField deleteNameTextField;

    @FXML
    private TextField deleteStuIdTextField;

    @FXML
    private TextField deleteClubNameTextField;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField markNameTextField;

    @FXML
    private TextField markStuIdTextField;

    @FXML
    private TextField markClubNameTextField;

    @FXML
    private ComboBox<String> Eventlist;

    @FXML
    private RadioButton absentRadioButton;

    @FXML
    private RadioButton presentRadioButton;

    @FXML
    private Button submitButton;

    @FXML
    private TextField markT_NameTextField;

    @FXML
    private TextField markTeaIdTextField;

    @FXML
    private TextField markTeaClubNameTextField;

    @FXML
    private ComboBox<String> T_Eventlist;

    @FXML
    private RadioButton T_absentRadioButton;

    @FXML
    private RadioButton T_presentRadioButton;

    @FXML
    private TextArea T_note;

    @FXML
    private Button T_submitButton;

    // Event handler for the ADD button
    @FXML
    void AddButton(ActionEvent event) {
        try {
            String name = firstName.getText();
            String studentId = Stu_ID.getText();
            LocalDate selectedDate = dobDatePicker.getValue();
            LocalDate joinDate = joinedDatePicker.getValue();
            String Grade = gradeTextField.getText();
            String nameofclub = clubNameTextField.getText();
            String nameofevent = eventName.getText();
            // Get other input values as needed
            // To Perform actions with the input, e.g., save to a database
            System.out.println("Added: Name - " + name + ", Student ID - " + studentId + ", Selected Date: " + selectedDate + " , Joined Date: " + joinDate + "," + Grade + "," + nameofclub + "," +nameofevent);

            // Display a success alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Record Saved");
            alert.setHeaderText(null);
            alert.setContentText("The record was added successfully.");
            alert.showAndWait();

            // Clear the input fields
            firstName.clear();
            Stu_ID.clear();
            dobDatePicker.setValue(null);
            joinedDatePicker.setValue(null);
            gradeTextField.clear();
            clubNameTextField.clear();
            eventName.clear();

        }
        catch(NumberFormatException e) {
            // Display an error alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while saving the record.");
            alert.showAndWait();
        }
    }

    // Event handler for the DELETE button
    @FXML
    private void handleDeleteButton() {
        try {
            String deleteName = deleteNameTextField.getText();
            String deleteStudentId = deleteStuIdTextField.getText();
            String deleteNameofClub = deleteClubNameTextField.getText();
            // Perform actions with the input, e.g., delete from a database
            System.out.println("Deleted: Name - " + deleteName + ", Student ID - " + deleteStudentId + "," + deleteNameofClub);

            // Display a success alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Record Deleted");
            alert.setHeaderText(null);
            alert.setContentText("The record was deleted successfully.");
            alert.showAndWait();

            // Clear the input fields
            deleteNameTextField.clear();
            deleteStuIdTextField.clear();
            deleteClubNameTextField.clear();

        }catch (NumberFormatException e) {
            // Display an error alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while saving the record.");
            alert.showAndWait();
        }
    }

    // Event handler for the SUBMIT button
    @FXML
    private void handleSubmitButton() {
        try {
            String Name = markNameTextField.getText();
            String markStudentId = markStuIdTextField.getText();
            String markClubName = markClubNameTextField.getText();
            ObservableList<String> list = FXCollections.observableArrayList("Event_01","Event_02","Event_03");
            Eventlist.setItems(list);
            String selectedEvent = Eventlist.getValue();
            String status = absentRadioButton.isSelected() ? "Absent" : "Present";
            // Perform actions with the input, e.g., update status in a database
            System.out.println("Marked: Name - " + Name+  ", Student ID - " + markStudentId +
                ", Club Name - " + markClubName + ", Status - " + status + "," + selectedEvent);

            // Display a success alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Record Marked");
            alert.setHeaderText(null);
            alert.setContentText("The record was marked successfully.");
            alert.showAndWait();

            // Clear the input fields
            markNameTextField.clear();
            markStuIdTextField.clear();
            markClubNameTextField.clear();
            absentRadioButton.setSelected(false);
            presentRadioButton.setSelected(false);
            Eventlist.getSelectionModel().clearSelection();

        }catch (NumberFormatException e) {
            // Display an error alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while saving the record.");
            alert.showAndWait();
        }
    }

    // Event handler for the SUBMIT button
    @FXML
    private void T_handleSubmitButton() {
        try {
            String T_markName = markT_NameTextField.getText();
            String markTeaId = markTeaIdTextField.getText();
            String markTeaClubName = markTeaClubNameTextField.getText();
            ObservableList<String> list_2 = FXCollections.observableArrayList("Event_01","Event_02","Event_03");
            T_Eventlist.setItems(list_2);
            String selectedEvent_2 = T_Eventlist.getValue();
            String T_status = T_absentRadioButton.isSelected() ? "Absent" : "Present";
            // Perform actions with the input, e.g., update status in a database
            System.out.println("Marked: Name - " + T_markName + ", Teacher ID - " + markTeaId +
                    ", Club Name - " + markTeaClubName + ", Status - " + T_status + "," + selectedEvent_2);

            // Display a success alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Record Marked");
            alert.setHeaderText(null);
            alert.setContentText("The record was marked successfully.");
            alert.showAndWait();

            // Clear the input fields
            markT_NameTextField.clear();
            markTeaIdTextField.clear();
            markTeaClubNameTextField.clear();
            T_absentRadioButton.setSelected(false);
            T_presentRadioButton.setSelected(false);
            T_Eventlist.getSelectionModel().clearSelection();
            T_note.clear();

        }catch (NumberFormatException e) {
            // Display an error alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while saving the record.");
            alert.showAndWait();
        }
    }


}