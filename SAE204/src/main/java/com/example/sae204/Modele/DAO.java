package com.example.sae204.Modele;

import com.example.sae204.Controller.ConnexionController;
import com.example.sae204.EtudiantAPK;
import javafx.collections.ObservableArray;

import java.sql.SQLException;
import java.util.LinkedList;

public class DAO {
    private static int connexion =0;
    public static void connexion() throws SQLException, ClassNotFoundException {
        EtudiantAPK.myjdbc.connect("root", ""); // connection a la base
        connexion=1;
    }


    public static LinkedList<Etudiant> listerEtu() throws SQLException, ClassNotFoundException {
        if (connexion ==0)
            connexion();
        LinkedList<Etudiant> listEtu=new LinkedList<Etudiant>();
        String query="SELECT COUNT(Num_etu) FROM etudiant;" ; // stockage de la requête
        int nbEtu= Integer.parseInt(EtudiantAPK.myjdbc.executeReadQuery(query)); //On prends le nombre d'étudiant
        for(int i=0;i<nbEtu;i++){
            query="SELECT num_etu FROM etudiant LIMIT 1 OFFSET "+i+";" ;
            String num_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT nom_etu FROM etudiant WHERE num_etu = '"+num_etu+"';";
            String nom_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT prenom_etu FROM etudiant WHERE num_etu = '"+num_etu+"';";
            String prenom_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT MDP_etu FROM etudiant WHERE num_etu = '"+num_etu+"';";
            String MDP_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT adresse_mail_etu FROM etudiant WHERE num_etu = '"+num_etu+"';";
            String adresse_mail_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT age_etu FROM etudiant WHERE num_etu = '"+num_etu+"';";
            String age_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT date_etu FROM etudiant WHERE num_etu = '"+num_etu+"';";
            String date_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT desc_etu FROM etudiant WHERE num_etu = '"+num_etu+"';";
            String desc_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT photo_etu FROM etudiant WHERE num_etu = '"+num_etu+"';";
            String photo_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT red_etu FROM etudiant WHERE num_etu = '"+num_etu+"';";
            String red_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT dem_etu FROM etudiant WHERE num_etu = '"+num_etu+"';";
            String dem_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT id_promo FROM etudiant WHERE num_etu = '"+num_etu+"';";
            String id_promo=EtudiantAPK.myjdbc.executeReadQuery(query);

            Etudiant etu =new Etudiant(num_etu, nom_etu, prenom_etu, MDP_etu, adresse_mail_etu, age_etu, date_etu, desc_etu, photo_etu, red_etu, dem_etu, id_promo);
            listEtu.add(etu);
        }
        return listEtu;
    }
    public static LinkedList<Groupe> listerGrp() throws SQLException, ClassNotFoundException {
        if (connexion ==0)
            connexion();
        LinkedList<Groupe> listGrp= new LinkedList<>();
        String query="SELECT COUNT(Id_groupe) FROM groupe;";
        int nbGrp=Integer.parseInt(EtudiantAPK.myjdbc.executeReadQuery(query));

        for(int i = 0;i<nbGrp;i++){
            query="SELECT Id_groupe FROM groupe LIMIT 1 OFFSET "+i+";";
            String Id_groupe=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT Nom_groupe FROM groupe WHERE Id_groupe="+Id_groupe+";";
            String Nom_groupe=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT Groupe_parent FROM groupe LIMIT 1 OFFSET "+Id_groupe+";";
            String Grp_parent=EtudiantAPK.myjdbc.executeReadQuery(query);

            Groupe grp=new Groupe(Id_groupe,Nom_groupe,Grp_parent);
            listGrp.add(grp);

        }
        return listGrp;
    }
    public static LinkedList<Promotion> listerPromo() throws  SQLException, ClassNotFoundException{
        if (connexion ==0)
            connexion();
        LinkedList<Promotion> listPromo = new LinkedList<>();
        String query="SELECT COUNT(Id_promo) FROM promotion;";
        int nbPromo = Integer.parseInt(EtudiantAPK.myjdbc.executeReadQuery(query));
        for(int i=0; i<nbPromo; i++){
            query ="SElECT Id_promo FROM promotion LIMIT 1 OFFSET"+i+";";
            String Id_promo =EtudiantAPK.myjdbc.executeReadQuery(query);

            query ="SElECT Annee_debut FROM promotion WHERE Id_promo="+Id_promo+";";
            String Annee_debut =EtudiantAPK.myjdbc.executeReadQuery(query);

            query ="SElECT Annee_fin FROM promotion WHERE Id_promo="+Id_promo+";";
            String Annee_fin =EtudiantAPK.myjdbc.executeReadQuery(query);

            query ="SElECT Niveau FROM promotion WHERE Id_promo="+Id_promo+";";
            String Niveau =EtudiantAPK.myjdbc.executeReadQuery(query);

            Promotion promo=new Promotion(Id_promo,Annee_debut,Annee_fin,Niveau);
            listPromo.add(promo);
        }
        return listPromo;
    }


    public static LinkedList<Personnel> listerPer() throws SQLException, ClassNotFoundException {
        if (connexion ==0)
            connexion();
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


    public static boolean verif(String enterId, String choixRole) throws SQLException {
        String query= "select Nom_role from roles join assignation on roles.Id_role=assignation.Id_role join personnel on personnel.Harpege=assignation.Harpege where personnel.Harpege='"+enterId+"' AND Nom_role LIKE 'E%';";
        String role=EtudiantAPK.myjdbc.executeReadQuery(query);
        if (role.equals(choixRole)){
            return true;
        }
        query= "select Nom_role from roles join assignation on roles.Id_role=assignation.Id_role join personnel on personnel.Harpege=assignation.Harpege where personnel.Harpege='"+enterId+"' AND Nom_role LIKE 'S%';";
        role=EtudiantAPK.myjdbc.executeReadQuery(query);
        System.out.println("------------------------");
        System.out.println(role);
        System.out.println(choixRole);
        if (role.equals(choixRole)){
            return true;
        }
        return false;
    }
}
//SELECT * FROM etudiant LIMIT 1 OFFSET 0;
//SELECT COUNT(Num_etu) FROM etudiant;