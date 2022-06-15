package com.example.sae204.Modele.DAO;

import com.example.sae204.EtudiantAPK;
import com.example.sae204.Modele.Appartenance;

import java.sql.SQLException;
import java.util.LinkedList;

public class DAOAppartenance {

    public static LinkedList<Appartenance> listerAppartenance() throws SQLException, ClassNotFoundException {
        DAO.connexion();
        LinkedList<Appartenance> listApp= new LinkedList<>();
        String query="SELECT COUNT(DISTINCT num_etu) FROM appartenance;";
        int nbApp=Integer.parseInt(EtudiantAPK.myjdbc.executeReadQuery(query));
        for (int i=0; i<nbApp*2; i+=2){
            query="SELECT num_etu FROM appartenance LIMIT 1 OFFSET "+i+";";
            String num_etu=EtudiantAPK.myjdbc.executeReadQuery(query);
            query="SELECT COUNT(Id_groupe) FROM appartenance WHERE num_etu='"+num_etu+"'";
            int nbEtu=Integer.parseInt(EtudiantAPK.myjdbc.executeReadQuery(query));
            for (int j=0; j<nbEtu; j++){
                query="SELECT id_groupe FROM appartenance WHERE num_etu='"+num_etu+"' LIMIT 1 OFFSET "+j+";";
                int id_groupe= Integer.parseInt(EtudiantAPK.myjdbc.executeReadQuery(query));
                Appartenance app = new Appartenance(num_etu, id_groupe);
                if(!listApp.contains(app)) {
                    listApp.add(app);
                }
            }
        }
        return listApp;
    }
}
