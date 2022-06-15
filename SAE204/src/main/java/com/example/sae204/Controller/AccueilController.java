package com.example.sae204.Controller;



import com.example.sae204.Modele.DAO.DAOGroupe;
import com.example.sae204.Modele.Groupe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.sql.SQLException;

public class AccueilController {

    @FXML
    private Button bouton_etu;

    @FXML
    private Button bouton_per;
    public static String etatButton;

    @FXML //Pour se connecter en tant qu'étudiant
    void bouton_etu() throws SQLException, ClassNotFoundException {
        if(bouton_etu.isFocused()){
            etatButton="E";
            System.out.println(etatButton);
        }
        ChoixRoleController.choixRole="E";
        Controller.GoToPage("ConnexionPage.fxml","Page de Connexion");

    }

    @FXML //Pour se connecter en tant que membre du personnel
    void bouton_per(ActionEvent event) {
        if(bouton_per.isFocused()){
            etatButton="P";
            System.out.println(etatButton);
        }
        Controller.GoToPage("ChoixRole.fxml","Choix du rôle");
    }
}

