package com.example.sae204.Controller;

import com.example.sae204.Modele.DAO.DAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PopUpValiderController extends Controller implements Initializable {

    protected static String nomGroupe;
    protected static String nomGroupeParent;
    protected static String Harpege;

    @FXML
    private Label VerifGroupeParentLab;

    @FXML
    private Label VerifNomDeGroupeLab;

    @FXML
    private Label adressemaillabel;

    @FXML
    void onVerifValiderButtonClick(){
        GoToPage("SecretaireAcc.fxml","Acceuil secrétaire");

    }
    @FXML
    void onVerifRetourButtonClick(){

        GoToPage("CreerGroupe.fxml","Accueil");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(Harpege);
        String mail = "";
        try {
            mail = DAO.mail(Harpege);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(mail);
        adressemaillabel.setText(mail);
        VerifNomDeGroupeLab.setText(nomGroupe);
        VerifGroupeParentLab.setText(nomGroupeParent);
    }
}
