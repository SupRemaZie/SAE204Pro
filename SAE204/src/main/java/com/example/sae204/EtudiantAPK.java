package com.example.sae204;

import com.example.sae204.Controller.MyJDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EtudiantAPK extends Application {
    public static Stage stage;
     public static MyJDBC myjdbc = new MyJDBC("com.mysql.cj.jdbc.Driver", "jdbc:mysql://127.0.0.1/absence?serverTimezone=UTC");
    @Override
    public void start(Stage stage) throws IOException {
        this.stage=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(EtudiantAPK.class.getResource("Accueil.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        this.stage.setTitle("My School Managing +");
        this.stage.setScene(scene);
        this.stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}