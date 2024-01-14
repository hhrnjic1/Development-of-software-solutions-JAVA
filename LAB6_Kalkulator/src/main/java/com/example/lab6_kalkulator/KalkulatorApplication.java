package com.example.lab6_kalkulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class KalkulatorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(KalkulatorApplication.class.getResource("Kalkulator-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Kalkulator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}