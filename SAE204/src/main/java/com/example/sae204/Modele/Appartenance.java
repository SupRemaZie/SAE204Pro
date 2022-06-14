package com.example.sae204.Modele;

public class Appartenance {
    private String num_etu;
    private String id_groupe;

    public Appartenance(String num_etu, String id_groupe){
        this.num_etu=num_etu;
        this.id_groupe=id_groupe;
    }

    public String getNum_etu() {
        return num_etu;
    }

    public String getId_groupe() {
        return id_groupe;
    }
}
