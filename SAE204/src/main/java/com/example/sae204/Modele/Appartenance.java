package com.example.sae204.Modele;

public class Appartenance {
    private String num_etu;
    private int id_groupe;

    public Appartenance(String num_etu, int id_groupe){
        this.num_etu=num_etu;
        this.id_groupe=id_groupe;
    }

    public String getNum_etu() {
        return num_etu;
    }

    public int getId_groupe() {
        return id_groupe;
    }
}
