module com.example.sacms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires com.opencsv;


    opens com.example.sacms to javafx.fxml;
    exports com.example.sacms;
}