package com.example.sae204.Controller;

import com.example.sae204.Modele.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EnseignantAccController extends Controller implements Initializable {

    public static String Harpege;

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
            mail = DAO.mail(Harpege);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        adressemaillabel.setText(mail);
    }
}
