package com.example.sae204.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EtudiantController extends  Controller{
    @FXML
    private Button DisconnectButton;

    @FXML
    private Button VisuInfoEtuButton;

    @FXML
    private Button VisuTrombiEtuButton;

    @FXML
    void onDisconnectButtonClick(ActionEvent event) {
        GoToPage("Accueil.fxml", "Accueil");

    }

    @FXML
    void onVisuInfoEtuButtonClick(ActionEvent event) {

    }

    @FXML
    void onVisuTrombiEtuButtonClick(ActionEvent event) {

    }
}

