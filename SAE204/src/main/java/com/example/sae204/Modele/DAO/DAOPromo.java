package com.example.sae204.Modele.DAO;

import com.example.sae204.EtudiantAPK;

import java.sql.SQLException;

public class DAOPromo {
    public static String getNomPromo(String num_etu) throws SQLException {
        String query ="select niveau from promotion join etudiant on etudiant.Id_promo=promotion.Id_promo where num_etu='"+num_etu+"';";
        String promo = EtudiantAPK.myjdbc.executeReadQuery(query);
        return promo;
    }

}
