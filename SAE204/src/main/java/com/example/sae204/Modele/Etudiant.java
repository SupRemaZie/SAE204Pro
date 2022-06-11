package com.example.sae204.Modele;

public class Etudiant {
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
    private String Id_promo;

    public String getNum_etu() {
        return Num_etu;
    }

    public String getNom_etu() {
        return Nom_etu;
    }

    public String getPrenom_etu() {
        return Prenom_etu;
    }

    public String getMdp_etu() {
        return Mdp_etu;
    }

    public String getAdresse_mail_etu() {
        return Adresse_mail_etu;
    }

    public String getAge_etu() {
        return Age_etu;
    }

    public String getDate_etu() {
        return Date_etu;
    }

    public String getDesc_etu() {
        return Desc_etu;
    }

    public String getPhoto_etu() {
        return photo_etu;
    }

    public String getRed_etu() {
        return Red_etu;
    }

    public String getDem_etu() {
        return Dem_etu;
    }

    public String getId_promo() {
        return Id_promo;
    }

    public Etudiant(String num_etu, String nom_etu, String prenom_etu, String mdp_etu, String adresse_mail_etu, String age_etu, String date_etu, String desc_etu, String photo_etu, String red_etu, String dem_etu, String id_promo) {
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
        Id_promo = id_promo;
    }

}
