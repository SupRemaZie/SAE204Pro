package com.example.sae204.Controller;


import com.example.sae204.EtudiantAPK;
import com.example.sae204.Modele.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EtudiantController extends  Controller implements Initializable{
    public static String num_etu;

    @FXML
    private Button DisconnectButton;

    @FXML
    private Button VisuInfoEtuButton;

    @FXML
    private Button VisuTrombiEtuButton;

    @FXML
    private Label adressemaillabel;

    @FXML
    void onDisconnectButtonClick(ActionEvent event) {
        GoToPage("Accueil.fxml", "Accueil");

    }

    @FXML
    void onVisuInfoEtuButtonClick(ActionEvent event) {
        EtudiantsinfoController.num_etu = num_etu;
        GoToPage("Mesinformations.fxml","Information sur l'étudiant");
    }

    @FXML
    void onVisuTrombiEtuButtonClick(ActionEvent event) {
        GoToPage("VisualiserTrombiEtu.fxml", "Visualiser trombinoscope");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String mail = "";
        try {
            mail = DAO.mail(num_etu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        adressemaillabel.setText(mail);

    }
}

