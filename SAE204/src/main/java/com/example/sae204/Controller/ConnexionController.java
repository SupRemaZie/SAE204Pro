package com.example.sae204.Controller;

import com.example.sae204.Modele.DAO.DAO;
import com.example.sae204.Modele.DAO.DAOEtudiant;
import com.example.sae204.Modele.DAO.DAOPersonnel;
import com.example.sae204.Modele.Etudiant;
import com.example.sae204.Modele.Personnel;

import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.sql.SQLException;
import java.util.LinkedList;

public class ConnexionController extends Controller{
    @FXML
    public TextField IDTextField; // champ de l'identifiant

    @FXML
    private TextField PasswordTextField; // champ du password

    @FXML
    private Label loginMessageLabel; // text d'erreur de login

    public static String Harpege;

    @FXML //Redirige vers la page d'oublie de mot de passe
    public void onMdpforgetButtonClick(){

        GoToPage("MotDePasseOubliee.fxml","Mot de passe oublié");
    }

    @FXML
    public void onConnexionButtonClick() throws SQLException, ClassNotFoundException {

        String EnterId=IDTextField.getText();// stockage de l'id entré
        String EnterPwd=PasswordTextField.getText(); // stockage du password entré
        String result1="", result2="";
        LinkedList<Etudiant> listEtu= DAOEtudiant.listerEtu();
        LinkedList<Personnel> listPer= DAOPersonnel.listerPer();

        if(EnterId.equals("") && EnterPwd.equals("")) {
            loginMessageLabel.setText("Veuillez entrez un identifiant et mot de passe "); // si les 2 sont vides alors msg erreur
        }
        else if (EnterId.equals("")) {
           loginMessageLabel.setText("Veuillez entrez un Identifiant"); // si l' ID est vide alors msg erreur
        }
        else if (EnterPwd.equals("")){
           loginMessageLabel.setText("Veuillez entez un mot de passe "); // si le mdp est vide alors msg erreur
        }

        else if(AccueilController.etatButton.equals("E")){ //Si l'utilisateur est un étudiant
            for (Etudiant etu : listEtu) {
                if(etu.getNum_etu().equals(EnterId)) { //On cherche un étudiant qui a pour ID celui entré par l'utilisateur
                    result1 = etu.getMdp_etu();        //Quand on en trouve un, on stocke le mot de passe assigné à cet étudiant
                }
            }
        }
        else if(AccueilController.etatButton.equals("P")){ //Si l'utilisateur est un membre du personnel
            for (Personnel per : listPer) {
                if(per.getHarpege().equals(EnterId)) {  //On cherche un étudiant qui a pour ID celui entré par l'utilisateur
                    result2 = per.getMdp_per();         //Quand on en trouve un, on stocke le mot de passe assigné à ce membre du personnel
                }
            }
        }

              // execute la requete et stocke le resultat

        if(EnterPwd.equals(result1) && !EnterId.equals("") && !EnterPwd.equals("")){ // Vérifie que le mdp dans la base correspond au mdp entré
            EtudiantController.num_etu = EnterId;
            EtudiantController.etudiantActuel=EtudiantController.trouverEtu(EnterId);
            GoToPage("EtudiantView.fxml", "Accueil etudiant");         //L'étudiant se connecte
        }
        else if(EnterPwd.equals(result2) && !EnterId.equals("") && !EnterPwd.equals("")){ // Vérifie que le mdp dans la base correspond au mdp entré
            if (DAO.verif(EnterId, ChoixRoleController.choixRole) && ChoixRoleController.choixRole.equals("Enseignant")){// Regarde si l'utilisateur est un enseignant
                Harpege = EnterId;

                GoToPage("EnseignantAcc.fxml","Acceuil enseignant");//L'enseignant se connecte
            }

            else if (DAO.verif(EnterId, ChoixRoleController.choixRole)&& ChoixRoleController.choixRole.equals("Secrétariat")){// Regarde si l'utilisateur est une secrétaire
                Harpege = EnterId;
                GoToPage("SecretaireAcc.fxml","Acceuil secrétaire");//La secrétaire se connecte
            }
            else{
                loginMessageLabel.setText("Identifiant ou mot de passe invalide avec le role choisi");
            }
        }
        else if (!EnterId.equals(("")) && !EnterPwd.equals("")){
            loginMessageLabel.setText("Identifiant ou mot de passe invalide");
        }
    }
    public void retour(){
        if(ChoixRoleController.choixRole.equals("E")){ //Si l'utilisateur est un étudiant
            GoToPage("Accueil.fxml", "Accueil");
        }
        else{
            GoToPage("ChoixRole.fxml", "Choix du rôle");
        }
    }

}
