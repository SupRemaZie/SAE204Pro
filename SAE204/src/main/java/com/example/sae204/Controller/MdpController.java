package com.example.sae204.Controller;

import com.example.sae204.Modele.DAO;
import com.example.sae204.Modele.Etudiant;
import com.example.sae204.Modele.Personnel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

public class MdpController extends Controller{

    @FXML
    TextField Enterid;
    @FXML
    TextField Entermail;
    @FXML
    Label erreur;


    public void onSubmitButtonClick() throws SQLException, IOException, ClassNotFoundException {
        String EnterId=Enterid.getText();
        String EnterMail=Entermail.getText();


        if(EnterId.equals("") && EnterMail.equals("")) {
            erreur.setText("Veuillez entrez un identifiant et une adresse mail "); // si les 2 sont vides alors msg erreur
        }
        else if (EnterId.equals("")) {
            erreur.setText("Veuillez entrez un Identifiant"); // si l' ID est vide alors msg erreur
        }
        else if (EnterMail.equals("")){
            erreur.setText("Veuillez entez une adresse mail "); // si le mdp est vide alors msg erreur
        }

        else if (AccueilController.etatButton=="E"){
            LinkedList<Etudiant> listEtu=DAO.listerEtu();
            for (Etudiant etu : listEtu) {
                if(etu.getNum_etu().equals(EnterId) && etu.getAdresse_mail_etu().equals(EnterMail))
                    Controller.GoToPage("MotDePasseOubliee2.fxml","Confirmation de l'envoi");
            }
            erreur.setText("Identifiant ou mot de passe invalide");
        }
        else if (AccueilController.etatButton=="P"){
            LinkedList<Personnel> listPer=DAO.listerPer();
            for (Personnel per : listPer) {
                if(per.getHarpege().equals(Enterid.getText()) && per.getAdresse_mail().equals(Entermail.getText()))
                    Controller.GoToPage("MotDePasseOubliee2.fxml","Confirmation de l'envoi");
            }
            erreur.setText("Identifiant ou adresse mail invalide");
        }
    }
    public void retour(){
        Controller.GoToPage("ConnexionPage.fxml","Page de Connexion");
    }
}
