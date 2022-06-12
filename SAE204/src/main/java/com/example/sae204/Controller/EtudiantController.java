package com.example.sae204.Controller;


import com.example.sae204.EtudiantAPK;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class EtudiantController extends  Controller {
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

    }

    @FXML
    void onVisuTrombiEtuButtonClick(ActionEvent event) {

    }

}

