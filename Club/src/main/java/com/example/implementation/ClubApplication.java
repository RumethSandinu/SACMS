package com.example.implementation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ClubApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ClubApplication.class.getResource("Club.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 513, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        ClubAdvisor ca=new ClubAdvisor("Harry","Potter","054356543");
        Club c1=new Club("c001","clubA","2023-11-01",ca);
        Club c2=new Club("c002","clubB","2023-11-01",ca);
        Club c3=new Club("c003","clubC","2023-11-01",ca);
        Club c4=new Club("c004","clubD","2023-11-01",ca);

        clubs
        launch();
    }
}