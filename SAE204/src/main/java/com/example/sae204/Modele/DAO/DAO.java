package com.example.sae204.Modele.DAO;

import com.example.sae204.Controller.ChoixRoleController;
import com.example.sae204.Controller.ConnexionController;
import com.example.sae204.EtudiantAPK;
import com.example.sae204.Modele.Etudiant;
import com.example.sae204.Modele.Groupe;
import com.example.sae204.Modele.Personnel;
import javafx.collections.ObservableArray;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Objects;

public class DAO {
    public static int connexion =0;
    public static void connexion() throws SQLException, ClassNotFoundException {

        //connexion à un serveur local
        EtudiantAPK.myjdbc.connect("root", ""); // connection a la base
        connexion=1;
    }
    public static  LinkedList<String> listGrpAffilGrpParents= new LinkedList<>();



    public static  LinkedList<Etudiant> listerAppEtu(String nom_groupe) throws SQLException, ClassNotFoundException {
        LinkedList<Etudiant> listAppEtu = new LinkedList<Etudiant>();
        String num_etu=" ";
        String query = "select count(Niveau) from promotion;";
        int nbniveau = Integer.parseInt(EtudiantAPK.myjdbc.executeReadQuery(query));
        for (int i = 0; i < nbniveau; i++){ //on parcours toutes les promotions existantes
            query = "SELECT Niveau FROM promotion LIMIT 1 OFFSET "+i+";";
            String nom_promo = EtudiantAPK.myjdbc.executeReadQuery(query);

            //Si le groupe choisi est une promotion
            if (Objects.equals(nom_groupe, nom_promo)){
                query ="select count(num_etu) from etudiant join promotion on promotion.Id_promo=etudiant.Id_promo where Niveau = '"+nom_groupe+"';";
                int nbEtu = Integer.parseInt(EtudiantAPK.myjdbc.executeReadQuery(query));
                for (int j = 0; j < nbEtu; j++) { //On parcours tous les étudiants appartenant à la promotion
                    query ="select num_etu from promotion join etudiant on etudiant.Id_promo=promotion.Id_promo where Niveau='"+nom_groupe+"' LIMIT 1 OFFSET "+j+";";
                    num_etu = EtudiantAPK.myjdbc.executeReadQuery(query);
                    LinkedList<Etudiant> listEtu=DAOEtudiant.listerEtu();
                    System.out.println("liste etu "+ DAOEtudiant.listerEtu());
                    System.out.println("num etu "+ num_etu);
                    for(Etudiant etu : listEtu) {
                        if (etu.getNum_etu().equals(num_etu)) {
                            listAppEtu.add(etu);
                            break;
                        }
                    }
                }return listAppEtu;
            }

        }//else(){}

        //requete groupe
        /*String query = "select count(appartenance.num_etu) from groupe join appartenance on appartenance.id_groupe=groupe.Id_groupe join etudiant on etudiant.Num_etu=appartenance.num_etu where groupe.Nom_groupe='"+nom_groupe+"';";
        int nbEtu = Integer.parseInt(EtudiantAPK.myjdbc.executeReadQuery(query));



        for (int i = 0; i < nbEtu; i++) {
            query = "select appartenance.num_etu from groupe join appartenance on appartenance.id_groupe=groupe.Id_groupe join etudiant on etudiant.Num_etu=appartenance.num_etu where groupe.Id_groupe='" + nom_groupe + "' LIMIT 1 OFFSET " + i + ";";
            num_etu = EtudiantAPK.myjdbc.executeReadQuery(query);
            LinkedList<Etudiant> listEtu=listerEtu();
            for(Etudiant etu : listEtu){
                if(etu.getNum_etu()==num_etu){
                    listAppEtu.add(etu);
                }
            }
        }

         */
        return listAppEtu;
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
}
//SELECT * FROM etudiant LIMIT 1 OFFSET 0;
//SELECT COUNT(Num_etu) FROM etudiant;