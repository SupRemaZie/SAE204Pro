package com.example.sae204.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ChoixRoleController extends Controller{
    @FXML
    private Button bouton_prof;
    @FXML
    private Button bouton_sec;
    @FXML
    private Button retour;

    public static String choixRole;

    void retour(ActionEvent event){
        GoToPage("Accueil.fxml", "Accueil");
    }
    void setBouton_prof(ActionEvent event){
        choixRole="P";
        GoToPage("ConnexionPage.fxml", "Page de Connexion");
    }
    void setBouton_sec(ActionEvent event){
        choixRole="S";
        GoToPage("ConnexionPage.fxml", "Page de Connexion");
    }
}
