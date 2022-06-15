package com.example.sae204.Modele.DAO;

import com.example.sae204.Controller.Controller;
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
    public static String getGroupeParent(String Groupe) throws SQLException {
        String query ="select Groupe_parent FROM groupe WHERE Nom_groupe ='"+Groupe+"';";
       String  GroupeParentGrp=EtudiantAPK.myjdbc.executeReadQuery(query);
        return GroupeParentGrp;
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
    public static void CreerGroupe(String NomGroupe, String GroupeParent) throws SQLException {

        String query ="SELECT max(Id_groupe) from groupe;";
        int Id = Integer.parseInt(EtudiantAPK.myjdbc.executeReadQuery(query));
        Id+=1;
        query="INSERT INTO groupe VALUES('"+Id+"','"+NomGroupe+"','"+GroupeParent+"');";
        EtudiantAPK.myjdbc.executeWriteQuery(query);
    }

    public static void RetirerGroupe(String NomGroupe) throws SQLException, ClassNotFoundException {
        String query = "delete from appartenance where Id_groupe = (select Id_groupe from groupe where Nom_groupe='"+NomGroupe+"');";
        EtudiantAPK.myjdbc.executeWriteQuery(query);
        System.out.println(Controller.chercherEtuGroupePromo(NomGroupe));
        query = "delete from groupe where Nom_groupe='"+NomGroupe+"';";
        EtudiantAPK.myjdbc.executeWriteQuery(query);
    }

    public static void ModifierGroupe(String nom_groupe,String nouv_nom_groupe, String nouv_nom_groupe_parent) throws SQLException {
        String query = "select id_groupe FROM groupe where Nom_groupe='"+nom_groupe+"';";
        int id_groupe = Integer.parseInt(EtudiantAPK.myjdbc.executeReadQuery(query));
        query = "UPDATE groupe SET Nom_groupe = '"+nouv_nom_groupe+"', Groupe_parent = '"+nouv_nom_groupe_parent+"' WHERE groupe.Id_groupe = "+id_groupe+";";
        EtudiantAPK.myjdbc.executeWriteQuery(query);
    }

    public static boolean isVide(String nom_groupe){
        return true;
    }

}
