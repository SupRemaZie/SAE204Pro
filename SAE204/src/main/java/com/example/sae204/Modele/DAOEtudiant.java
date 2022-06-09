package com.example.sae204.Modele;

import com.example.sae204.Controller.EtudiantController;
import com.example.sae204.EtudiantAPK;

import java.sql.SQLException;


public class DAOEtudiant {
    private String IdEtu = "1ETU";
    private String sqlQuery;

    public String getNomEtudiant() throws SQLException {
       sqlQuery= "SELECT Nom_etu FROM etudiant WHERE Num_etu = "+IdEtu+";";
        String nom = EtudiantAPK.myjdbc.executeReadQuery(sqlQuery);
        return nom;
    }
    public String getPrenomEtudiant() throws SQLException
    {
        sqlQuery="SELECT Prenom_etu FROM etudiant WHERE Num_etu="+IdEtu+";";
        String prenom=EtudiantAPK.myjdbc.executeReadQuery(sqlQuery);
        return prenom;
    }

}
