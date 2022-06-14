package com.example.sae204.Controller;

import com.example.sae204.EtudiantAPK;

import com.example.sae204.Modele.DAO.DAOEtudiant;
import com.example.sae204.Modele.DAO.DAOPersonnel;
import com.example.sae204.Modele.DAO.DAOPromo;
import com.example.sae204.Modele.Etudiant;
import com.example.sae204.Modele.Promotion;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TextField;



import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;


public class Controller {



    static void GoToPage(String fichier_fxml, String nom) {
        FXMLLoader fxml = new FXMLLoader(EtudiantAPK.class.getResource(fichier_fxml));
        Scene scene = null;
        try {
            scene = new Scene(fxml.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        EtudiantAPK.stage.setResizable(false);
        EtudiantAPK.stage.setTitle(nom);
        EtudiantAPK.stage.setScene(scene);
        EtudiantAPK.stage.show();
    }
    public LinkedList<Etudiant> chercherEtuDansPromo(Promotion promo) throws SQLException, ClassNotFoundException {
        LinkedList<Etudiant> listEtuPromo=new LinkedList<>();
        LinkedList<Etudiant> listEtu= DAOEtudiant.listerEtu();
        for(Etudiant etu : listEtu){
            if(etu.getId_promo().equals(promo.getId_promo())){
                listEtuPromo.add(etu);
            }
        }
        return listEtuPromo;
    }
    public LinkedList<Etudiant> chercherEtuGroupePromo(String nomGroupe) throws SQLException, ClassNotFoundException {
        LinkedList<Promotion> listPromo=DAOPromo.listerPromo();
        LinkedList<Etudiant> listEtuGroupePromo;
        for(Promotion promo : listPromo){
            if(promo.getNiveau().equals(nomGroupe)){
                listEtuGroupePromo=chercherEtuDansPromo(promo);
                return listEtuGroupePromo;
            }
        }
        return null;
    }


}
