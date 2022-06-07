package com.example.sae204;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EtudiantAPK extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EtudiantAPK.class.getResource("ConnexionPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("My School Managing +");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}