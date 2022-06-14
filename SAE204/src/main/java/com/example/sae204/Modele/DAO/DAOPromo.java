package com.example.sae204.Modele.DAO;

import com.example.sae204.EtudiantAPK;
import com.example.sae204.Modele.Etudiant;
import com.example.sae204.Modele.Promotion;

import java.sql.SQLException;
import java.util.LinkedList;

public class DAOPromo {
    public static String getNomPromo(String num_etu) throws SQLException {
        String query ="select niveau from promotion join etudiant on etudiant.Id_promo=promotion.Id_promo where num_etu='"+num_etu+"';";
        String promo = EtudiantAPK.myjdbc.executeReadQuery(query);
        return promo;
    }

    public static LinkedList<Promotion> listerPromo() throws SQLException {
        LinkedList<Promotion> listPromo= new LinkedList<>();
        String query = "select count(Niveau) FROM promotion;";
        int nbPromo = Integer.parseInt(EtudiantAPK.myjdbc.executeReadQuery(query));
        for (int i = 0; i < nbPromo; i++){

            query = "select id_promo from promotion LIMIT 1 OFFSET "+i+";";
            String id_promo = EtudiantAPK.myjdbc.executeReadQuery(query);
            query = "select Niveau from promotion LIMIT 1 OFFSET "+i+";";
            String niveau = EtudiantAPK.myjdbc.executeReadQuery(query);
            query = "select Annee_debut from promotion LIMIT 1 OFFSET "+i+";";
            String annee_debut = EtudiantAPK.myjdbc.executeReadQuery(query);
            query = "select Annee_fin from promotion LIMIT 1 OFFSET "+i+"";
            String annee_fin = EtudiantAPK.myjdbc.executeReadQuery(query);

            Promotion promo = new Promotion(id_promo, niveau, annee_debut, annee_fin);
            listPromo.add(promo);
        }
        return listPromo;
    }

}
