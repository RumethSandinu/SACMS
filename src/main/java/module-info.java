module com.example.sacms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.sacms to javafx.fxml;
    exports com.example.sacms;
    exports com.example.sacms.EventScheduling;
    opens com.example.sacms.EventScheduling to javafx.fxml;
}