package com.example.sae204.Modele;

public class Etudiant  {
    private String Num_etu;
    private String Nom_etu;
    private String Prenom_etu;
    private String Mdp_etu;
    private String Adresse_mail_etu;
    private String Age_etu;
    private String Date_etu;
    private String Desc_etu;
    private String photo_etu;
    private String Red_etu;
    private String Dem_etu;
    private String Id_groupe_TD;
    private String Id_groupe_TP;
    private String Id_promo;

    public Etudiant(String num_etu, String nom_etu, String prenom_etu, String mdp_etu, String adresse_mail_etu, String age_etu, String date_etu, String desc_etu, String photo_etu, String red_etu, String dem_etu, String id_groupe_TD, String id_groupe_TP, String id_promo) {
        Num_etu = num_etu;
        Nom_etu = nom_etu;
        Prenom_etu = prenom_etu;
        Mdp_etu = mdp_etu;
        Adresse_mail_etu = adresse_mail_etu;
        Age_etu = age_etu;
        Date_etu = date_etu;
        Desc_etu = desc_etu;
        this.photo_etu = photo_etu;
        Red_etu = red_etu;
        Dem_etu = dem_etu;
        Id_groupe_TD = id_groupe_TD;
        Id_groupe_TP = id_groupe_TP;
        Id_promo = id_promo;
    }

}
