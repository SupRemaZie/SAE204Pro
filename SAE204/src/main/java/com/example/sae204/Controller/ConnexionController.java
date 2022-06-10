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

public class ConnexionController {
    @FXML
    public TextField IDTextField; // champ de l'identifiant

    @FXML
    private TextField PasswordTextField; // champ du password

    @FXML
    private Label loginMessageLabel; // text d'erreur de login

    @FXML
    private Button figma; //bouton temporaire pour passer à la page d'Accueil figma



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


        String query1="SELECT MDP_etu FROM ETUDIANT WHERE Num_etu='" + EnterId + "';" ; // stockage de la requête

        String result1= EtudiantAPK.myjdbc.executeReadQuery(query1);  // execute la requete et stocke le resultat

        if(EnterPwd.equals(result1)){ // verife si le mdp dans la base correspond au mdp entré
            GoToPage("EtudiantView.fxml");
        }
        else {
            loginMessageLabel.setText("Identifiant ou mot de passe invalide");
        }
    }

    private void GoToPage(String s ) throws IOException {
        EtudiantAPK.stage=new Stage();
        FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(EtudiantAPK.class.getResource(s));
        Scene scene = new Scene(fxmlLoader.load());
        EtudiantAPK.stage.setScene(scene);
        EtudiantAPK.stage.setTitle("My School Managing +");
        EtudiantAPK.stage.show();
    }
    @FXML
    void figma(ActionEvent event){
        FXMLLoader fxml= new FXMLLoader(EtudiantAPK.class.getResource("Accueil.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxml.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        EtudiantAPK.stage.setTitle("Accueil");
        EtudiantAPK.stage.setScene(scene);
        EtudiantAPK.stage.show();
    }

}
