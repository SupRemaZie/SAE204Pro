package com.example.sae204.Modele;

import com.example.sae204.EtudiantAPK;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DAO {
    public static void connexion() throws SQLException, ClassNotFoundException {
        EtudiantAPK.myjdbc.connect("root",""); // connection a la base
    }
    public static LinkedList<Etudiant> listerEtu() throws SQLException, ClassNotFoundException {
        connexion();
        LinkedList<Etudiant> listEtu=new LinkedList<Etudiant>();
        String query="SELECT COUNT(Num_etu) FROM etudiant;" ; // stockage de la requête
        int nbEtu= Integer.parseInt(EtudiantAPK.myjdbc.executeReadQuery(query)); //On prends le nombre d'étudiant
        for(int i=0;i<nbEtu;i++){
            query="SELECT num_etu FROM etudiant LIMIT 1 OFFSET "+i+";" ;
            String num_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT nom_etu FROM etudiant LIMIT 1 OFFSET "+i+";" ;
            String nom_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT prenom_etu FROM etudiant LIMIT 1 OFFSET "+i+";" ;
            String prenom_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT MDP_etu FROM etudiant LIMIT 1 OFFSET "+i+";" ;
            String MDP_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT adresse_mail_etu FROM etudiant LIMIT 1 OFFSET "+i+";" ;
            String adresse_mail_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT age_etu FROM etudiant LIMIT 1 OFFSET "+i+";" ;
            String age_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT date_etu FROM etudiant LIMIT 1 OFFSET "+i+";" ;
            String date_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT desc_etu FROM etudiant LIMIT 1 OFFSET "+i+";" ;
            String desc_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT photo_etu FROM etudiant LIMIT 1 OFFSET "+i+";" ;
            String photo_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT red_etu FROM etudiant LIMIT 1 OFFSET "+i+";" ;
            String red_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT dem_etu FROM etudiant LIMIT 1 OFFSET "+i+";" ;
            String dem_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT id_promo FROM etudiant LIMIT 1 OFFSET "+i+";" ;
            String id_promo=EtudiantAPK.myjdbc.executeReadQuery(query);

            Etudiant etu =new Etudiant(num_etu, nom_etu, prenom_etu, MDP_etu, adresse_mail_etu, age_etu, date_etu, desc_etu, photo_etu, red_etu, dem_etu, id_promo);
            listEtu.add(etu);
        }
        return listEtu;
    }
}
//SELECT * FROM etudiant LIMIT 1 OFFSET 0;
//SELECT COUNT(Num_etu) FROM etudiant;