package com.example.sae204.Controller;

import com.example.sae204.Modele.DAO.DAOGroupe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PopUpSuppressionController extends  Controller implements Initializable {
    @FXML
    private Label GroupeSupLab;

    @FXML
    private Button RetourButton;

    @FXML
    private Button ValiderButtonClick;

    @FXML
    void onRetourButtonClick(ActionEvent event) {
        SecretaireAccController.CurrentGroupeParent=GroupeSupLab.getText();
        GoToPage("SecretaireAcc.fxml","Acceuil secrétaire");
    }

    @FXML
    void onValiderButtonClick(ActionEvent event) throws SQLException, ClassNotFoundException {
        DAOGroupe.RetirerGroupe(GroupeSupLab.getText());
        GoToPage("SecretaireAcc.fxml","Acceuil secrétaire");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GroupeSupLab.setText(SecretaireAccController.GroupeSupprimer);
    }
}
