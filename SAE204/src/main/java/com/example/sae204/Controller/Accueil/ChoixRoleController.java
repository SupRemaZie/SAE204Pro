package com.example.sae204.Controller.Accueil;

import com.example.sae204.Controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ChoixRoleController extends Controller {



    public static String choixRole; //Utilisé pour connaître le rôle de l'utilisateur (dont Etudiant)

    @FXML
    public void retour(ActionEvent event){
        GoToPage("Accueil.fxml", "Accueil");
    }

    @FXML //Pour se connecter en tant qu'enseignant
    public void bouton_prof(){
        choixRole="Enseignant";
        GoToPage("ConnexionPage.fxml", "Page de Connexion");
    }
    @FXML //Pour se connecter en tant que secrétaire
    public void bouton_sec(){
        choixRole="Secrétariat";
        GoToPage("ConnexionPage.fxml", "Page de Connexion");
    }
}
