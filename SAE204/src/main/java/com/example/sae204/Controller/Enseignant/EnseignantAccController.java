package com.example.sae204.Controller.Enseignant;

import com.example.sae204.Controller.Accueil.ConnexionController;
import com.example.sae204.Controller.Controller;
import com.example.sae204.Controller.Personnel.PersonnelTrombiController;
import com.example.sae204.Modele.DAO.DAO;
import com.example.sae204.Modele.DAO.DAOPromo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EnseignantAccController extends Controller implements Initializable {


    @FXML
    private Label adressemaillabel;

    @FXML
    void onDisconnectButtonClick() {
        GoToPage("Accueil.fxml", "Accueil");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //On affiche l'adresse mail Le Man université de l'étudiant
        String mail = "";
        try {
            mail = DAO.mail(ConnexionController.Harpege);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        adressemaillabel.setText(mail);
    }
    @FXML
    public void deconnexion(){
        GoToPage("Accueil.fxml", "Accueil");
    }
    @FXML
    public void visualiserGr() throws SQLException {
        //On affiche par défaut le trombinoscope de la première promotion stocké dans la base
        PersonnelTrombiController.CurrentGroupeParent= DAOPromo.listerPromo().peek().getNiveau();
        GoToPage("PersonnelTrombi.fxml", "Trombinoscope des étudiants");
    }
}
