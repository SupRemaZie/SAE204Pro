package com.example.sae204.Controller.Secretaire;

import com.example.sae204.Controller.Accueil.ConnexionController;
import com.example.sae204.Controller.Controller;
import com.example.sae204.Modele.DAO.DAO;
import com.example.sae204.Modele.DAO.DAOGroupe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PopUpSuppressionController extends Controller implements Initializable {

    @FXML
    private Button RetourButton;

    @FXML
    private Button ValiderButtonClick;
    @FXML
    private Label adressemaillabel, groupeSup;

    @FXML
    void onRetourButtonClick(ActionEvent event) {
        SecretaireAccController.CurrentGroupeParent=groupeSup.getText();
        GoToPage("SecretaireAcc.fxml","Acceuil secrétaire");
    }

    @FXML
    void onValiderButtonClick(ActionEvent event) throws SQLException, ClassNotFoundException {
        DAOGroupe.RetirerGroupe(groupeSup.getText());
        GoToPage("SecretaireAcc.fxml","Acceuil secrétaire");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String mail = "";
        try {
            mail = DAO.mail(ConnexionController.Harpege);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        adressemaillabel.setText(mail);
        groupeSup.setText(SecretaireAccController.GroupeSupprimer);
    }
}

