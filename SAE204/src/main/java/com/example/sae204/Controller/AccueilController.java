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

    @FXML
    void bouton_etu(ActionEvent event) throws SQLException, ClassNotFoundException {
        etatButton="E";
        ChoixRoleController.choixRole="E";
        Controller.GoToPage("ConnexionPage.fxml","Page de Connexion");

    }

    @FXML
    void bouton_per(ActionEvent event) {
        etatButton="P";
        Controller.GoToPage("ChoixRole.fxml","Choix du rôle");
    }
}

