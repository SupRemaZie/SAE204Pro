package com.example.sae204.Modele;

public class Promotion {
    private String Id_promo;
    private String Annee_debut;
    private String Annee_fin;
    private String Niveau;

    public Promotion(String id_promo, String annee_debut, String annee_fin, String niveau) {
        Id_promo = id_promo;
        Annee_debut = annee_debut;
        Annee_fin = annee_fin;
        Niveau = niveau;
    }

    @Override
    public String toString() {
        return Niveau+"\n";
    }
}
