package com.example.sae204.Controller;

import com.example.sae204.Modele.DAO.DAO;
import com.example.sae204.Modele.DAO.DAOAppartenance;
import com.example.sae204.Modele.DAO.DAOGroupe;
import com.example.sae204.Modele.Etudiant;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class PopUpValiderController extends Controller implements Initializable {

    protected static String nomGroupe;
    protected static String nomGroupeParent;
    protected static String Harpege;

    @FXML
    private Label VerifGroupeParentLab;

    @FXML
    private Label VerifNomDeGroupeLab, nomGr;

    @FXML
    private Label adressemaillabel;

    @FXML
    void onVerifValiderButtonClick() throws SQLException {

        DAOGroupe.CreerGroupe(CreerGroupeController.NomduGroupe,CreerGroupeController.CurrentGroupeParent);
        for (Etudiant etu : AjouterEtuController.nouveauGroupeliste){
            DAOAppartenance.CreerAppartenance(etu.getPrenom_etu(), etu.getNom_etu(), CreerGroupeController.NomduGroupe);
        }
        GoToPage("SecretaireAcc.fxml","Acceuil secrétaire");

    }
    @FXML
    void onVerifRetourButtonClick(){

        GoToPage("CreerGroupe.fxml","Accueil");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String mail = "";
        try {
            mail = DAO.mail(ConnexionController.Harpege);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        adressemaillabel.setText(mail);
        VerifNomDeGroupeLab.setText(nomGroupe);
        VerifGroupeParentLab.setText(nomGroupeParent);
        nomGr.setText(AjouterEtuController.NouveauGroupe1);
    }
}
