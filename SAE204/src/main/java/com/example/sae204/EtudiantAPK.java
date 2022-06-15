package com.example.sae204;

import com.example.sae204.Controller.MyJDBC;
import com.example.sae204.Modele.Appartenance;
import com.example.sae204.Modele.DAO.DAOAppartenance;
import com.example.sae204.Modele.DAO.DAOEtudiant;
import com.example.sae204.Modele.Etudiant;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

public class EtudiantAPK extends Application {
    public static Stage stage;
    public static MyJDBC myjdbc = new MyJDBC("com.mysql.cj.jdbc.Driver", "jdbc:mysql://127.0.0.1/absence?serverTimezone=UTC");



    @Override
    public void start(Stage stage) throws IOException, SQLException, ClassNotFoundException {
        this.stage=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(EtudiantAPK.class.getResource("Accueil.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        this.stage.setTitle("Accueil");
        this.stage.setScene(scene);
        this.stage.show();

        LinkedList<Appartenance> listApp= DAOAppartenance.listerAppartenance();
    }

    public static void main(String[] args) {
        launch();
    }
}