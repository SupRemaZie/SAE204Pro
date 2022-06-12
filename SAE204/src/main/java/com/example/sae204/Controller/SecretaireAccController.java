package com.example.sae204.Controller;

import com.example.sae204.Modele.Groupe;
import com.example.sae204.Modele.Promotion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class SecretaireAccController extends Controller{


    @FXML
    private ListView<Groupe> GroupeList;

    @FXML
    private ListView<Promotion> PromoList;
    @FXML
    void onDisconnectButtonClick(ActionEvent event) {
        GoToPage("Accueil.fxml", "Accueil");

    }

}
