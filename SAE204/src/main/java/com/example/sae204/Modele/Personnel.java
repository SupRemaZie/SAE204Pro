package com.example.sae204.Modele;

public class Personnel {
    private String Harpege;
    private String Mdp_per;
    private String Nom_per;
    private String Prenom_per;
    private String Adresse_mail;

    public String getHarpege() {return Harpege;}

    public String getMdp_per() {return Mdp_per;}

    public String getNom_per() {return Nom_per;}

    public String getPrenom_per() {return Prenom_per;}

    public String getAdresse_mail() {return Adresse_mail;}

    public Personnel(String harpege, String mdp_per, String nom_per, String prenom_per, String adresse_mail) {
        Harpege = harpege;
        Mdp_per = mdp_per;
        Nom_per = nom_per;
        Prenom_per = prenom_per;
        Adresse_mail = adresse_mail;
    }
}
