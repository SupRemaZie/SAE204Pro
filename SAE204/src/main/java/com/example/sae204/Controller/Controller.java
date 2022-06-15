package com.example.sae204.Controller;

import com.example.sae204.EtudiantAPK;

import com.example.sae204.Modele.Appartenance;
import com.example.sae204.Modele.DAO.*;
import com.example.sae204.Modele.Etudiant;
import com.example.sae204.Modele.Groupe;
import com.example.sae204.Modele.Promotion;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;


public class Controller {



    public void rechercherEtu(){

    }
    public static void GoToPage(String fichier_fxml, String nom) {
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
    public static LinkedList<Etudiant> chercherEtuDansPromo(Promotion promo) throws SQLException, ClassNotFoundException {
        LinkedList<Etudiant> listEtuPromo=new LinkedList<>();
        LinkedList<Etudiant> listEtu= DAOEtudiant.listerEtu();
        for(Etudiant etu : listEtu){
            if(etu.getId_promo().equals(promo.getId_promo())){
                listEtuPromo.add(etu);
            }
        }
        return listEtuPromo;
    }
    public static LinkedList<Etudiant> chercherEtuDansGroupe(Groupe groupe) throws SQLException, ClassNotFoundException {
        LinkedList<Etudiant> listEtuGroupe=new LinkedList<>();
        LinkedList<Etudiant> listEtu= DAOEtudiant.listerEtu();
        LinkedList<Appartenance> listApp= DAOAppartenance.listerAppartenance();
        for(Etudiant etu : listEtu){
            for(Appartenance app : listApp) {
                if (etu.getNum_etu().equals(app.getNum_etu())&&app.getId_groupe()==groupe.getId_grp()) {
                    listEtuGroupe.add(etu);
                    break;
                }
            }
        }
        return listEtuGroupe;
    }

    public static LinkedList<Etudiant> chercherEtuGroupePromo(String nomGroupe) throws SQLException, ClassNotFoundException {
        LinkedList<Promotion> listPromo=DAOPromo.listerPromo();
        LinkedList<Etudiant> listEtuGroupePromo;
        for(Promotion promo : listPromo){
            if(promo.getNiveau().equals(nomGroupe)){
                listEtuGroupePromo=chercherEtuDansPromo(promo);
                return listEtuGroupePromo;
            }
        }
        LinkedList<Groupe> listGroupe= DAOGroupe.listerGrp();
        for(Groupe groupe : listGroupe){
            if(groupe.getNom_grp().equals(nomGroupe)){
                listEtuGroupePromo=chercherEtuDansGroupe(groupe);
                return listEtuGroupePromo;
            }
        }
        return null;
    }


}
