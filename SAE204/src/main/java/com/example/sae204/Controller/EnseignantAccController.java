package com.example.sae204.Controller;

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
    void onDisconnectButtonClick(ActionEvent event) {
        GoToPage("Accueil.fxml", "Accueil");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        PersonnelTrombiController.CurrentGroupeParent= DAOPromo.listerPromo().peek().getNiveau();
        GoToPage("PersonnelTrombi.fxml", "Trombinoscope des étudiants");
    }
}
