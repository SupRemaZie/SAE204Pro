package com.example.sae204.Modele;

public class Promotion {
    private String Id_promo;
    private String Annee_debut;
    private String Annee_fin;
    private String Niveau;

    public Promotion(String id_promo, String niveau, String annee_debut, String annee_fin) {
        Id_promo = id_promo;
        Annee_debut = annee_debut;
        Annee_fin = annee_fin;
        Niveau = niveau;
    }

    @Override
    public String toString() {
        return Niveau+"\n";
    }

    public String getId_promo() {
        return Id_promo;
    }

    public String getAnnee_debut() {
        return Annee_debut;
    }

    public String getAnnee_fin() {
        return Annee_fin;
    }

    public String getNiveau() {
        return Niveau;
    }
}
