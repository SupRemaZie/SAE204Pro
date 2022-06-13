package com.example.sae204.Modele;

import com.example.sae204.Controller.ChoixRoleController;
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
    private static  LinkedList<String> listGrpAffilGrpParents= new LinkedList<>();


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
        if (role.equals(choixRole)){
            return true;
        }
        return false;
    }

    public static String mail(String ident) throws SQLException {

        System.out.println(ChoixRoleController.choixRole);
        String mail="";
        if (ChoixRoleController.choixRole.equals("E")){
            String query="SELECT prenom_etu FROM etudiant WHERE num_etu = '"+ident+"';";
            String prenom_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT nom_etu FROM etudiant WHERE num_etu = '"+ident+"';";
            String nom_etu=EtudiantAPK.myjdbc.executeReadQuery(query);

            mail = prenom_etu+"."+nom_etu+".Etu@univ-lemans.fr";
        }
        else if (ChoixRoleController.choixRole.equals(("Enseignant")) || ChoixRoleController.choixRole.equals("Secrétariat")){

            String query="SELECT Prenom_per FROM personnel WHERE Harpege = '"+ident+"';";
            String Prenom_per=EtudiantAPK.myjdbc.executeReadQuery(query);

            query="SELECT Nom_per FROM personnel WHERE Harpege = '"+ident+"';";
            String Nom_per=EtudiantAPK.myjdbc.executeReadQuery(query);

                mail=Prenom_per+"."+Nom_per+"@univ-lemans.fr";

        }
        return mail;
    }

    public static String getNomPromo(String num_etu) throws SQLException {
        String query ="select niveau from promotion join etudiant on etudiant.Id_promo=promotion.Id_promo where num_etu='"+num_etu+"';";
        String promo = EtudiantAPK.myjdbc.executeReadQuery(query);
        return promo;
    }

    public static String getAmenagement(String num_etu) throws SQLException {
        String amenagement="";
        String query ="select Dem_etu from etudiant where Num_etu='"+num_etu+"';";
        String dem = EtudiantAPK.myjdbc.executeReadQuery(query);
        if (dem.equals("0"))
            amenagement+= "non ";
        amenagement+="démissionnaire, ";
        query ="select Red_etu from etudiant where Num_etu='"+num_etu+"';";
        String red = EtudiantAPK.myjdbc.executeReadQuery(query);
        if (red.equals("0"))
            amenagement+= "non ";
        amenagement+="redoublant";
        return amenagement;
    }

    public static String getGroupe(String num_etu) throws SQLException {
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

    public static String getPhoto(String num_etu) throws SQLException {
        String query = "select Photo_etu from etudiant where Num_etu='"+num_etu+"';";
        String photo = EtudiantAPK.myjdbc.executeReadQuery(query);
        return photo;
    }
}
//SELECT * FROM etudiant LIMIT 1 OFFSET 0;
//SELECT COUNT(Num_etu) FROM etudiant;