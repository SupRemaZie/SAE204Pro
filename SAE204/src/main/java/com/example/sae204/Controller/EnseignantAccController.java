package com.example.sae204.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class EnseignantAccController extends Controller {

    @FXML
    void onDisconnectButtonClick(ActionEvent event) {
        GoToPage("Accueil.fxml", "Accueil");
    }
}
