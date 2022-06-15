package com.example.sae204.Modele;

public class Groupe {
    private int Id_grp;
    private String Nom_grp;
    private String Grp_parent;

    public Groupe(int id_grp, String nom_grp, String grp_parent) {
        Id_grp = id_grp;
        Nom_grp = nom_grp;
        Grp_parent = grp_parent;
    }

    public String getNom_grp() {
        return Nom_grp;
    }

    public String getGrp_parent() {
        return Grp_parent;
    }


    @Override
    public String toString() {
        return Nom_grp;
    }

    public int getId_grp() {
        return Id_grp;
    }
}
