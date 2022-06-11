package com.example.sae204.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AccueilController {

    @FXML
    private Button bouton_etu;

    @FXML
    private Button bouton_per;
    public static String etatButton;

    @FXML
    void bouton_etu(ActionEvent event) {
        if(bouton_etu.isFocused()){
            etatButton="E";
            System.out.println(etatButton);
        }
        ChoixRoleController.choixRole="E";
        Controller.GoToPage("ConnexionPage.fxml","Page de Connexion");
    }

    @FXML
    void bouton_per(ActionEvent event) {
        if(bouton_etu.isFocused()){
            etatButton="P";
            System.out.println(etatButton);
        }
        Controller.GoToPage("ConnexionPage.fxml","Page de Connexion");
    }
}

