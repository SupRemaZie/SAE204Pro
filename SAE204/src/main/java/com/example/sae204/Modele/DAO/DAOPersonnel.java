package com.example.sae204.Modele.DAO;

import com.example.sae204.EtudiantAPK;
import com.example.sae204.Modele.Personnel;

import java.sql.SQLException;
import java.util.LinkedList;

public class DAOPersonnel extends DAO{
    public static LinkedList<Personnel> listerPer() throws SQLException, ClassNotFoundException {
        if(DAO.connexion==0)connexion();
        LinkedList<Personnel> listPer=new LinkedList<Personnel>();
        String query="SELECT COUNT(Harpege) FROM personnel;" ; // stockage de la requête
        int nbPer= Integer.parseInt(EtudiantAPK.myjdbc.executeReadQuery(query)); //On prends le nombre de personnel
        for(int i=0;i<nbPer;i++){
            query="SELECT Harpege FROM personnel LIMIT 1 OFFSET "+i+";" ;
            String Harpege=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT MDP_per FROM personnel WHERE Harpege = '"+Harpege+"';";
            String Mdp_per=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT Nom_per FROM personnel WHERE Harpege = '"+Harpege+"';";
            String Nom_per=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT Prenom_per FROM personnel WHERE Harpege = '"+Harpege+"';";
            String Prenom_per=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT Adresse_mail FROM personnel WHERE Harpege = '"+Harpege+"';";
            String Adresse_mail=EtudiantAPK.myjdbc.executeReadQuery(query);

            Personnel per = new Personnel(Harpege, Mdp_per, Nom_per,Prenom_per,Adresse_mail);
            listPer.add(per);
        }
        return listPer;
    }
}
