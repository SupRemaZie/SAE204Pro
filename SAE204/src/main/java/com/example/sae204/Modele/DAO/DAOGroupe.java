package com.example.sae204.Modele.DAO;

import com.example.sae204.EtudiantAPK;
import com.example.sae204.Modele.Groupe;

import java.sql.SQLException;
import java.util.LinkedList;

public class DAOGroupe extends DAO {
    public static LinkedList<Groupe> listerGrp() throws SQLException, ClassNotFoundException {
        if(DAO.connexion==0){
            connexion();
        }
        LinkedList<Groupe> listGrp= new LinkedList<>();
        String query="SELECT COUNT(Id_groupe) FROM groupe;";
        int nbGrp=Integer.parseInt(EtudiantAPK.myjdbc.executeReadQuery(query));

        for(int i = 0;i<nbGrp;i++){
            query="SELECT Id_groupe FROM groupe LIMIT 1 OFFSET "+i+";";
            int Id_groupe= Integer.parseInt(EtudiantAPK.myjdbc.executeReadQuery(query));

            query="SELECT Nom_groupe FROM groupe WHERE Id_groupe="+Id_groupe+";";
            String Nom_groupe=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT Groupe_parent FROM groupe WHERE Id_groupe="+Id_groupe+";";
            String Grp_parent=EtudiantAPK.myjdbc.executeReadQuery(query);


            Groupe grp=new Groupe(Id_groupe,Nom_groupe,Grp_parent);
            listGrp.add(grp);

        }
        return listGrp;
    }
    public static LinkedList<String> ListGrpAffilGrpParent(String Grp_parent) throws SQLException, ClassNotFoundException {
        String GrpAffilGrpPar = null;

        if (connexion == 0)
            connexion();
        String query = "SELECT COUNT(Nom_groupe) FROM GROUPE WHERE Groupe_parent='"+Grp_parent+"';"; // stockage de la requête
        int nbGrpAffil = Integer.parseInt(EtudiantAPK.myjdbc.executeReadQuery(query)); //On prends le nombre de groupe lié au groupe parent
        for(int i = 0; i < nbGrpAffil;i++){
            query="SELECT Nom_groupe FROM groupe WHERE Groupe_parent='"+Grp_parent+"'LIMIT 1 OFFSET "+i+";";
            GrpAffilGrpPar= EtudiantAPK.myjdbc.executeReadQuery(query);
            listGrpAffilGrpParents.add(GrpAffilGrpPar);


            ListGrpAffilGrpParent(GrpAffilGrpPar);


        }
        return listGrpAffilGrpParents;
    }
    public static  LinkedList<String> ListGrpParent() throws SQLException, ClassNotFoundException {
        if (connexion == 0)
            connexion();
        LinkedList<String> listGrpParents = new LinkedList<String>();
        String query = "SELECT COUNT(DISTINCT groupe_parent) FROM GROUPE;"; // stockage de la requête
        int nbGrpParent = Integer.parseInt(EtudiantAPK.myjdbc.executeReadQuery(query)); //On prends le nombre de personnel
        for (int i = 0; i < nbGrpParent; i++) {
            query = "SELECT DISTINCT Groupe_parent FROM groupe LIMIT 1 OFFSET " + i + ";";
            String GrpParent = EtudiantAPK.myjdbc.executeReadQuery(query);
            listGrpParents.add(GrpParent);

        }
        return listGrpParents;
    }
    public static String getGroupe(String num_etu) throws SQLException { //liste les groupes lié à un étudiant
        String groupe="",groupetemp;
        String query = "select count(Nom_groupe) from groupe join appartenance on appartenance.id_groupe=groupe.Id_groupe join etudiant on etudiant.Num_etu=appartenance.num_etu where etudiant.Num_etu='"+num_etu+"' group by etudiant.Num_etu;";
        int nbgroupe = Integer.parseInt(EtudiantAPK.myjdbc.executeReadQuery(query));
        for(int i=0;i<nbgroupe;i++){
            query = "select Nom_groupe from groupe join appartenance on appartenance.id_groupe=groupe.Id_groupe join etudiant on etudiant.Num_etu=appartenance.num_etu where etudiant.Num_etu='"+num_etu+"' LIMIT 1 OFFSET "+i+";";
            groupetemp = EtudiantAPK.myjdbc.executeReadQuery(query);
            if (i==0)
                groupe+=groupetemp;
            else
                groupe+=", " + groupetemp;
        }
        return groupe;
    }
    public void CreerGroupe(String NomGroupe, String GroupeParent) throws SQLException {

        String query ="SELECT max(Id_groupe) from groupe;";
        int Id=Integer.parseInt(query);
        EtudiantAPK.myjdbc.executeReadQuery(query);
        String  query2="INSERT INTO groupe VALUES('"+Id+"','"+NomGroupe+"','"+GroupeParent+"');";
        int nbGroupe = Integer.parseInt(EtudiantAPK.myjdbc.executeReadQuery(query2));
    }
}
