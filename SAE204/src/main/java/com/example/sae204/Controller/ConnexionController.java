package com.example.sae204.Controller;

import com.example.sae204.EtudiantAPK;
import com.example.sae204.Modele.DAO;
import com.example.sae204.Modele.Etudiant;
import com.example.sae204.Modele.Personnel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import javafx.scene.control.Button;

public class ConnexionController extends Controller{
    @FXML
    public TextField IDTextField; // champ de l'identifiant

    @FXML
    private TextField PasswordTextField; // champ du password

    @FXML
    private Label loginMessageLabel; // text d'erreur de login



    public void onMdpforgetButtonClick(){
        GoToPage("MotDePasseOubliee.fxml","Mot de passe oubliee");
    }

    public void onConnexionButtonClick() throws SQLException, IOException, ClassNotFoundException {

        String EnterId=IDTextField.getText();// stockage de l'id entré
        String EnterPwd=PasswordTextField.getText(); // stockage du password entré
        String result1="", result2="";
        LinkedList<Etudiant> listEtu=DAO.listerEtu();
        LinkedList<Personnel> listPer=DAO.listerPer();

        if(EnterId.equals("") && EnterPwd.equals("")) {
            loginMessageLabel.setText("Veuillez entrez un identifiant et mot de passe "); // si les 2 sont vides alors msg erreur
        }
        else if (EnterId.equals("")) {
           loginMessageLabel.setText("Veuillez entrez un Identifiant"); // si l' ID est vide alors msg erreur
        }
        else if (EnterPwd.equals("")){
           loginMessageLabel.setText("Veuillez entez un mot de passe "); // si le mdp est vide alors msg erreur
        }

        else if(AccueilController.etatButton=="E"){
            for (Etudiant etu : listEtu) {
                if(etu.getNum_etu().equals(EnterId)) {
                    result1 = etu.getMdp_etu();
                }
            }
        }
        else if(AccueilController.etatButton=="P"){
            for (Personnel per : listPer) {
                if(per.getHarpege().equals(EnterId)) {
                    result2 = per.getMdp_per();
                }
            }
        }

              // execute la requete et stocke le resultat

        if(EnterPwd.equals(result1) && !EnterId.equals("") && !EnterPwd.equals("")){ // verife si le mdp dans la base correspond au mdp entré
            EtudiantController.num_etu = EnterId;
            GoToPage("EtudiantView.fxml", "Etudiant_Connexion");
        }
        else if(EnterPwd.equals(result2) && !EnterId.equals("") && !EnterPwd.equals("")){
            System.out.println(EnterId);
            System.out.println(ChoixRoleController.choixRole);
            if (DAO.verif(EnterId, ChoixRoleController.choixRole) && ChoixRoleController.choixRole.equals("Enseignant")){
                GoToPage("EnseignantAcc.fxml","Acceuil enseignant");// page pour le personnel
            }

            else if (DAO.verif(EnterId, ChoixRoleController.choixRole)&& ChoixRoleController.choixRole.equals("Secrétariat")){
                GoToPage("SecretaireAcc.fxml","Acceuil secrétaire");// page pour le personnel
            }
            else{
                loginMessageLabel.setText("Identifiant ou mot de passe invalide avec le role choisi");
            }
        }
        else if (!EnterId.equals(("")) && !EnterPwd.equals("")){
            loginMessageLabel.setText("Identifiant ou mot de passe invalide");
        }
    }
    public void retour(ActionEvent event){
        if(ChoixRoleController.choixRole.equals("E")){
            GoToPage("Accueil.fxml", "Accueil");
        }
        else{
            GoToPage("ChoixRole.fxml", "Choix du rôle");
        }
    }

}
