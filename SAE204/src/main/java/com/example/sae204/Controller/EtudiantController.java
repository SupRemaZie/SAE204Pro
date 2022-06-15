package com.example.sae204.Controller;


import com.example.sae204.Modele.DAO.DAO;
import com.example.sae204.Modele.DAO.DAOEtudiant;
import com.example.sae204.Modele.DAO.DAOPromo;
import com.example.sae204.Modele.Etudiant;
import com.example.sae204.Modele.Promotion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class EtudiantController extends  Controller implements Initializable{
    public static String num_etu;

    @FXML
    private Label adressemaillabel;
    public static Etudiant etudiantActuel;

    @FXML
    void onDisconnectButtonClick(ActionEvent event) {
        GoToPage("Accueil.fxml", "Accueil");

    }

    @FXML
    void onVisuInfoEtuButtonClick(ActionEvent event) {
        EtudiantsinfoController.num_etu = num_etu;
        GoToPage("Mesinformations.fxml","Information sur l'étudiant");
    }

    @FXML
    void onVisuTrombiEtuButtonClick(ActionEvent event) {
        EtudiantTrombiController.num_etu = num_etu;
        GoToPage("EtudiantTrombi.fxml", "Visualiser trombinoscope");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String mail = "";
        try {
            mail = DAO.mail(num_etu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        adressemaillabel.setText(mail);

    }
    public static Etudiant trouverEtu(String num_etu) throws SQLException, ClassNotFoundException {
        LinkedList<Etudiant> listEtu=DAOEtudiant.listerEtu();
        for(Etudiant etu : listEtu){
            if(etu.getNum_etu().equals(num_etu)){
                return etu;
            }
        }
        System.out.println("ERREUR pas d'étudiant trouvé avec cet id");
        return  null;
    }
    public static Promotion trouverPromo(Etudiant etu) throws SQLException {
        LinkedList<Promotion> listPromo= DAOPromo.listerPromo();
        for(Promotion promo : listPromo){
            if(etu.getId_promo().equals(promo.getId_promo())){
                return promo;
            }
        }
        System.out.println("ERREUR pas de promotion trouvé avec cet étudiant");
        return  null;
    }
}

