package com.example.sae204.Controller;

import com.example.sae204.EtudiantAPK;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import javafx.scene.control.Button;

public class ConnexionController extends Controller{
    @FXML
    public TextField IDTextField; // champ de l'identifiant

    @FXML
    private TextField PasswordTextField; // champ du password

    @FXML
    private Label loginMessageLabel; // text d'erreur de login





    public void onConnexionButtonClick() throws SQLException, IOException, ClassNotFoundException {

        String EnterId=IDTextField.getText();// stockage de l'id entré
        String EnterPwd=PasswordTextField.getText(); // stockage du password entré

       if (EnterId.equals("")) {
           loginMessageLabel.setText("Veuillez entrez un Identifiant"); // si l' ID est vide alors msg erreur
       }
       if (EnterPwd.equals("")){
           loginMessageLabel.setText("Veuillez entez un mot de passe "); // si le mdp est vide alors msg erreur
       }
        if(EnterId.equals("") && EnterPwd.equals("")) {
           loginMessageLabel.setText("Veuillez entrez un identifiant et mot de passe "); // si les 2 sont vides alors msg erreur
        }


        EtudiantAPK.myjdbc.connect("root",""); // connection a la base
        String result1="";
        String result2="";
        if(AccueilController.etatButton=="E"){
            String query1="SELECT MDP_etu FROM ETUDIANT WHERE Num_etu='" + EnterId + "';" ; // stockage de la requête
             result1= EtudiantAPK.myjdbc.executeReadQuery(query1);
        }
        else if(AccueilController.etatButton=="P"){
           String  query2="SELECT MDP_per FROM PERSONNEL WHERE Harpege='" + EnterId + "';" ;
             result2= EtudiantAPK.myjdbc.executeReadQuery(query2);// stockage de la requête
        }

              // execute la requete et stocke le resultat

        if(EnterPwd.equals(result1)){ // verife si le mdp dans la base correspond au mdp entré
            GoToPage("EtudiantView.fxml", "Etudiant_Connexion");
        }
        else if(EnterPwd.equals(result2)){
            GoToPage("","");// page pour le personnel
        }
        else {
            loginMessageLabel.setText("Identifiant ou mot de passe invalide");
        }
    }

}
