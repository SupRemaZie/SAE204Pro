package com.example.sae204.Controller;

import com.example.sae204.Modele.DAO.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AjouterEtuController extends Controller implements Initializable {
    public static String Harpege;
    public static String CurrentGroupeParent1;
    public static String CurrentGroupe1;
    public static String NouveauGroupe1;

    @FXML
    private Label adressemaillabel;

    @FXML
    private Label CurrentGroupeParent;

    @FXML
    private Label CurrentGroupe;

    @FXML
    private Label NouveauGroupe;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String mail = "";
        try {
            mail = DAO.mail(Harpege);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        adressemaillabel.setText(mail);
        CurrentGroupeParent.setText(CurrentGroupeParent1);
        CurrentGroupe.setText(CurrentGroupe1);
        NouveauGroupe.setText(NouveauGroupe1);

    }
    public void retour(ActionEvent event){
        GoToPage("Creergroupe.fxml","Créer un groupe");
    }
}
